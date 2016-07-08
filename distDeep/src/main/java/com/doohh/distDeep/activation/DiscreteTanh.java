package com.doohh.distDeep.activation;

public class DiscreteTanh implements IActivation {

	public double execute(double x) {
		// TODO Auto-generated method stub
		return 1. - x * x;
	}

}
