package com.doohh.distDeep.activation;

public class Sigmoid implements IActivation {

	public double execute(double x) {
		// TODO Auto-generated method stub
		return 1. / (1. + Math.pow(Math.E, -x));
	}

}
