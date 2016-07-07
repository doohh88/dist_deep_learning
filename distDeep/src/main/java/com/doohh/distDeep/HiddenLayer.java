package com.doohh.distDeep;

import java.util.Random;
import java.util.function.DoubleFunction;

public class HiddenLayer {
	public int N;
	public int n_in;
	public int n_out;
	public double[][] W;
	public double[] b;
	public Random rng;
	public DoubleFunction<Double> activation;
	public DoubleFunction<Double> dactivation;
	
	public HiddenLayer(int N, int n_in, int n_out, double[][] W, double[] b, Random rng, String activation) {
		// TODO Auto-generated constructor stub
		this.N = N;
		this.n_in = n_in;
		this.n_out = n_out;
		
		if(rng == null) this.rng = new Random(1234);
		else this.rng = rng;
		
		if (W == null){
			this.W = new double[n_out][n_in];
			double a = 1.0 / this.n_in;
			
			for(int i = 0; i < n_out; i++){
				for(int j = 0; j < n_in; j++){
					this.W[i][j] = uniform(-a, a, rng);
				}
			}
		}
	}
}
