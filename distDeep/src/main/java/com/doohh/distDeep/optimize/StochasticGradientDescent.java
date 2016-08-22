package com.doohh.distDeep.optimize;

import org.apache.commons.math3.analysis.function.StepFunction;
import org.apache.commons.math3.util.Pair;

import com.doohh.distDeep.gradient.Gradient;
import com.doohh.distDeep.nn.api.Model;
import com.doohh.distDeep.nn.conf.NetConf;

public class StochasticGradientDescent extends BaseOptimizer {
	public StochasticGradientDescent(NetConf conf, StepFunction stepFunction, Model model) {
		  super(conf, stepFunction, model);
	}
	
	public boolean optimize(){
		for(int i = 0 ;i < conf.getNumInteration(); i++){
			Pair<Gradient, Double> pair = gradientAndScore();
			Gradient gradient = pair.getFirst();
			INDArray params = model.params();
			stepFunction.step(params, gradient.gradient());
		}
		return true;
	}
}
