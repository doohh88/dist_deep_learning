package com.doohh.distDeep.nn.layers;

import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.nn.conf.DenseLayerConf;
import com.doohh.distDeep.nn.conf.NetConf;

public class DenseLayer extends BaseLayer<DenseLayerConf>{
	public DenseLayer(NetConf conf){
		super(conf);
	}
	public DenseLayer(NetConf conf, INDArray input){
		super(conf, input);
	}
	
	public void fit(INDArray input){}
}
