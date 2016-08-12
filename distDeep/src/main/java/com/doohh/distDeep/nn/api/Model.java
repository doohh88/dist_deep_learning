package com.doohh.distDeep.nn.api;

import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.nn.conf.NeuralNetConf;

public interface Model {
	void fit();
	void update(INDArray gradient, String paramType);
	INDArray params();
	int numParams();
	void setParams(INDArray params);
	void fit(INDArray data);
	int batchSize();
	NeuralNetConf conf();
	void setConf(NeuralNetConf conf);
	INDArray input();
	void initParams();
	void clear();
}
