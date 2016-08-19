package com.doohh.distDeep.params;

import java.util.Collections;
import java.util.Map;

import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.nn.api.ParamInitializer;
import com.doohh.distDeep.nn.conf.NetConf;

public class EmptyParamInitilizer implements ParamInitializer {

	@Override
	public int numParams(NetConf conf, boolean backprop) {
		return 0;
	}

	@Override
	public void init(Map<String, INDArray> paramsMap, NetConf conf, boolean initializeParams) {
	}

	@Override
	public Map<String, INDArray> getGradientsFromFlattened(NetConf conf) {
		return Collections.emptyMap();
	}

}
