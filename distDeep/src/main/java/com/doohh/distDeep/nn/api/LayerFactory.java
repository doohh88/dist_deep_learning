package com.doohh.distDeep.nn.api;

import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.nn.conf.NetConf;

public interface LayerFactory {
	<E extends Layer> E create(NetConf conf, int index, INDArray layerParamsRef,boolean initializeParmas);
	ParamInitializer initializer();
}
