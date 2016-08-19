package com.doohh.distDeep.params;

import java.util.Map;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import com.doohh.distDeep.nn.api.ParamInitializer;
import com.doohh.distDeep.nn.conf.FeedForwardLayerConf;
import com.doohh.distDeep.nn.conf.NetConf;

import lombok.Data;

@Data
public class DefaultParamInitializer implements ParamInitializer {

	int nIn;
	int nOut;
	
	@Override
	public int numParams(NetConf conf, boolean backprop) {
		FeedForwardLayerConf layerConf = (FeedForwardLayerConf)conf.getLayerConf();
		this.nIn = layerConf.getNIn();
		this.nOut = layerConf.getNOut();
		return nIn*nOut + nOut;
	}

	@Override
	public void init(Map<String, INDArray> paramsMap, NetConf conf, boolean initializeParams) {
		if(!(conf.getLayerConf() instanceof FeedForwardLayerConf))
            throw new IllegalArgumentException("unsupported layer type: " + conf.getLayerConf().getClass().getName());
		
		int length = numParams(conf, true);
		FeedForwardLayerConf layerConf = (FeedForwardLayerConf)conf.getLayerConf();
		int nWeightParams = nIn*nOut;
				
	}

	@Override
	public Map<String, INDArray> getGradientsFromFlattened(NetConf conf) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected INDArray createBias(NetConf conf, boolean initializeParameters){
		FeedForwardLayerConf layerConf = (FeedForwardLayerConf)conf.getLayerConf();
		if(initializeParameters){
			INDArray ret = Nd4j.valueArrayOf(layerConf.getNOut(), layerConf.getBiasInit());
			return ret;
		}
	}
	
	protected INDArray createWeightMatrix(){
		
	}

}
