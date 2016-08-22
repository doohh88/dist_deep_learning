package com.doohh.distDeep.optimize;

import com.doohh.distDeep.nn.conf.NetConf;
import com.doohh.distDeep.optimize.api.ConvexOptimizer;

public class Solver {
	private ConvexOptimizer optimizer;
	private NetConf conf;

	public void optimize() {
		if (optimizer == null) {
			optimizer.getOptimizer();
		}
		optimizer.optimize();
	}

	public ConvexOptimizer getOptimizer() {
		if (optimizer != null)
			return optimizer;
		switch (conf.getOptimizationAlgo()) {
		case STOCHASTIC_GRADIENT_DESCENT:
			optimizer = new StochasticGradientDescent(conf, stepFunction, model);
			break;
		default:
			throw new IllegalStateException("No optimizer found");
		}
		return optimizer;

	}
}
