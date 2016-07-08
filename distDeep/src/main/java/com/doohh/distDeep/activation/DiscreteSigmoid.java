package com.doohh.distDeep.activation;

public class DiscreteSigmoid implements IActivation {

	public double execute(double x) {
		// TODO Auto-generated method stub
		return x * (1. - x);
	}

}
