package com.doohh.distDeep;

public class utils {
	public static double sigmoid(double x){
		return 1. / (1. + Math.pow(Math.E, -x));
	}
	
	public static double ReLU(double x){
		if(x > 0)
			return x;
		else
			return 0.;
	}
}
