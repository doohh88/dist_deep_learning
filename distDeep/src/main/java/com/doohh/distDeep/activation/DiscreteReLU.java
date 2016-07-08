package com.doohh.distDeep.activation;

public class DiscreteReLU implements IActivation {
	public double execute(double x) {
		// TODO Auto-generated method stub
		if(x > 0) {
            return 1.;
        } else {
            return 0.;
        }
	}
}
