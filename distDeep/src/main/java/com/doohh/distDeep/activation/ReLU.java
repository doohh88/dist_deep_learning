package com.doohh.distDeep.activation;

public class ReLU implements IActivation{
	public double execute(double x) {
		// TODO Auto-generated method stub
		if(x > 0) {
            return x;
        } else {
            return 0.;
        }
	}
}
