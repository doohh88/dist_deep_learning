package com.doohh.distDeep.nn.layers;

import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.nn.conf.NetConf;
import com.doohh.distDeep.nn.conf.OutputLayerConf;

public class OutputLayer extends BaseOutputLayer<OutputLayerConf>{
	public OutputLayer(NetConf conf){
		super(conf);
	}
	
	public OutputLayer(NetConf conf, INDArray input){
		super(conf, input);
	}
}
