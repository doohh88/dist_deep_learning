package com.doohh.distDeep.nn.network;

import java.util.LinkedHashMap;

import org.apache.commons.lang3.tuple.Pair;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doohh.distDeep.gradient.Gradient;
import com.doohh.distDeep.nn.api.Layer;

import lombok.Data;

@Data
public class NeuralNetwork implements Layer{
    private static final Logger log = LoggerFactory.getLogger(NeuralNetwork.class);
    protected Layer[] layers;
    protected LinkedHashMap<String, Layer> layerMap = new LinkedHashMap<>();
    protected INDArray input, labels;
    protected boolean initCalled = false;
    protected Gradient gradient;
    protected INDArray flattenedParams;     //Params for all layers are a view/subset of this array
    protected transient INDArray flattenedGradients; //Gradients for all layers are a view/subset of this array

	
	
	public void init(INDArray parameters){
	
		
	}
	
	@Override
	public INDArray activate(INDArray input, TrainingMode training) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Pair<Gradient, INDArray> backpropGradient(INDArray epsilon) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Gradient calcGradient(Gradient layerError, INDArray indArray) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Type type() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void update(Gradient gradient) {
		// TODO Auto-generated method stub
		
	}
	
}
