package com.doohh.distDeep.params;

import java.util.Map;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import com.doohh.distDeep.distribution.Distribution;
import com.doohh.distDeep.distribution.Distributions;
import com.doohh.distDeep.nn.api.ParamInitializer;
import com.doohh.distDeep.nn.conf.FeedForwardLayerConf;
import com.doohh.distDeep.nn.conf.NetConf;
import com.doohh.distDeep.weights.WeightInitUtil;

import lombok.Data;

@Data
public class DefaultParamInitializer implements ParamInitializer {

	@Override
	public int numParams(NetConf conf, boolean backprop) {
		FeedForwardLayerConf layerConf = (FeedForwardLayerConf) conf.getLayerConf();
		int nIn = layerConf.getNIn();
		int nOut = layerConf.getNOut();
		return nIn * nOut + nOut;
	}

	@Override
	public void init(Map<String, INDArray> paramsMap, NetConf conf, boolean initializeParams) {
		if (!(conf.getLayerConf() instanceof FeedForwardLayerConf))
			throw new IllegalArgumentException("unsupported layer type: " + conf.getLayerConf().getClass().getName());

		int length = numParams(conf, true);
		FeedForwardLayerConf layerConf = (FeedForwardLayerConf) conf.getLayerConf();
		int nWeightParams = nIn * nOut;

	}

	@Override
	public Map<String, INDArray> getGradientsFromFlattened(NetConf conf) {
		// TODO Auto-generated method stub
		return null;
	}

	protected INDArray createBias(NetConf conf, boolean initializeParameters) {
		FeedForwardLayerConf layerConf = (FeedForwardLayerConf) conf.getLayerConf();
		INDArray ret = Nd4j.valueArrayOf(layerConf.getNOut(), layerConf.getBiasInit());
		return ret;
	}

	protected INDArray createWeightMatrix(NetConf conf) {
		FeedForwardLayerConf layerConf = (FeedForwardLayerConf)conf.getLayerConf();
		Distribution dist = Distributions.createDistribution(layerConf.getDist());
		INDArray ret = WeightInitUtil.initWeights(layerConf.getNIn(), layerConf.getNOut(), layerConf.getWeightInit(), dist);
		
	}
}
