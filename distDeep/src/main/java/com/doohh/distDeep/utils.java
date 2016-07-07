package com.doohh.distDeep;

import java.util.Random;

public class utils {
	
	public static double uniform(double min, double max, Random rng) {
        return rng.nextDouble() * (max - min) + min;
    }
	
	
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
