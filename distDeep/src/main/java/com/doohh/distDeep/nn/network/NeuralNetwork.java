package com.doohh.distDeep.nn.network;

import java.util.LinkedHashMap;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.NDArrayIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doohh.distDeep.gradient.Gradient;
import com.doohh.distDeep.nn.api.Classifier;
import com.doohh.distDeep.nn.api.Layer;
import com.doohh.distDeep.nn.conf.LayerConf;
import com.doohh.distDeep.nn.conf.NetConf;
import com.doohh.distDeep.nn.conf.NeuralNetConf;
import com.doohh.distDeep.nn.layers.factory.LayerFactories;

import lombok.Data;

@Data
public class NeuralNetwork implements Layer, Classifier{
    private static final Logger log = LoggerFactory.getLogger(NeuralNetwork.class);
    protected LayerConf[] layersConf;
    protected LinkedHashMap<String, LayerConf> layerMap = new LinkedHashMap<>();
    protected INDArray input, labels;
    protected boolean initCalled = false;
    protected Gradient gradient;
    protected INDArray flattenedParams;     //Params for all layers are a view/subset of this array
    protected transient INDArray flattenedGradients; //Gradients for all layers are a view/subset of this array
    
    protected NetConf defaultConfiguration;
    protected NeuralNetConf layerWiseConfigurations;

	
	public void NeralNetwork(NeuralNetConf conf) {
		// TODO Auto-generated method stub
		this.layerWiseConfigurations = conf;
		this.defaultConfiguration = conf.getConf(0).clone();
	}
    
	protected void intializeConfigurations() {
		if(layerWiseConfigurations == null)
			layerWiseConfigurations = new NeuralNetConf.Builder().build();
		
		if(layersConf == null){
			layersConf = new LayerConf[getnLayers()];
		}
		
		if(defaultConfiguration == null){
			defaultConfiguration = new NetConf.Builder().build();
		}
	}
	
    public void init() {
        init(null,false);
    }
	
    public void init(INDArray parameters, boolean cloneParametersArray){
		if(layerWiseConfigurations == null || layersConf == null){
			intializeConfigurations();
		}
		
		if (initCalled) return;
		
		int nLayers = getnLayers();
		
		if(this.layersConf == null || this.layersConf[0] == null){
			if(this.layersConf == null){
				this.layersConf = new LayerConf[nLayers];
			}

			
			//First: Work out total length of (backprop) params
			int backpropParamLength = 0;
			int[] nParamsPerLayer = new int[nLayers]; // save number of parameter
			for(int i =0; i < nLayers; i++){
				NetConf conf = layerWiseConfigurations.getConf(i);
				nParamsPerLayer[i] = LayerFactories.getFactory(conf).initializer().numParams(conf, true);
				backpropParamLength += nParamsPerLayer[i]; //backpropParamLength -> total parameter of all layers
			}
			
			//Create parameters array, if required
			boolean initializeParams;
			if(parameters != null){
                if(!parameters.isRowVector()) throw new IllegalArgumentException("Invalid parameters: should be a row vector");
                if(parameters.length() != backpropParamLength) throw new IllegalArgumentException("Invalid parameters: expected length " + backpropParamLength + ", got length " + parameters.length());
                if(cloneParametersArray) flattenedParams = parameters.dup();
                else flattenedParams = parameters;
			} else {
				flattenedParams = Nd4j.create(1, backpropParamLength);
				initializeParams = true;
			}
			
			// construct multi-layer
            int paramCountSoFar = 0;
            for (int i = 0; i < nLayers; i++) {
                INDArray paramsRef;
                if(nParamsPerLayer[i] > 0){
                	paramsRef = flattenedParams.get(NDArrayIndex.point(0), NDArrayIndex.interval(paramCountSoFar, paramCountSoFar + nParamsPerLayer[i]));
                } else {
                	paramsRef = null;
                }
                paramCountSoFar += nParamsPerLayer[i];
                NetConf conf = layerWiseConfigurations.getConf(i);
                layersConf[i] = LayerFactories.getFactory(conf).create(conf, i, paramsRef, initializeParams);
                layerMap.put(conf.getLayerConf().getLayerName(), layersConf[i]);
            }
            initCalled = true;
		}
	
	}

    public void fit() {
        fit(input, labels);
    }
    
    public void fit(DataSet data) {
    	fit(data.getFeatureMatrix(), data.getLabels());
    }
    
    public void fit(INDArray data, INDArray labels) {
        setInput(data);
        setLabels(labels);
   	
    }

}
