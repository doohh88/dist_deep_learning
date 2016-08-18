package com.doohh.distDeep.nn.layers;

import java.util.Map;

import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.nn.api.Layer;
import com.doohh.distDeep.nn.network.NeuralNetwork;

public class BaseLayer implements Layer{
    protected INDArray input;
    protected INDArray paramsFlattened;
    protected INDArray gradientsFlattened;
    protected Map<String,INDArray> params;
    protected NeuralNetwork conf;
    
    
    public BaseLayer(NeuralNetwork conf) {
        this.conf = conf;
    }

    public BaseLayer(NeuralNetwork conf, INDArray input) {
        this.input = input;
        this.conf = conf;
    }
    
    
}
