package com.doohh.distDeep.nn.api;

import java.util.Map;

import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.nn.conf.NetConf;

public interface ParamInitializer {
	int numParams(NetConf conf, boolean backprop);
    void init(Map<String, INDArray> paramsMap, NetConf conf, INDArray parmasRef, boolean initializeParams);
	Map<String, INDArray> getGradientsFromFlattened(NetConf conf, INDArray gradientRef);
}
