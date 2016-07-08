package com.doohh.distDeep.layer;

import java.util.Random;

import com.doohh.distDeep.activation.DiscreteReLU;
import com.doohh.distDeep.activation.DiscreteSigmoid;
import com.doohh.distDeep.activation.DiscreteTanh;
import com.doohh.distDeep.activation.IActivation;
import com.doohh.distDeep.activation.ReLU;
import com.doohh.distDeep.activation.Sigmoid;
import com.doohh.distDeep.activation.Tanh;
import com.doohh.distDeep.utils.Utils;

public class HiddenLayer implements ILayer {
	public int N;
	public int n_in;
	public int n_out;
	public double[][] W;
	public double[] b;
	public Random rng;
	public IActivation activation;
	public IActivation dactivation;

	public HiddenLayer(int N, int n_in, int n_out, double[][] W, double[] b, Random rng, String activation) {
		// TODO Auto-generated constructor stub
		this.N = N;
		this.n_in = n_in;
		this.n_out = n_out;

		if (rng == null)
			this.rng = new Random(1234);
		else
			this.rng = rng;

		if (W == null) {
			this.W = new double[n_out][n_in];
			double a = 1.0 / this.n_in;

			for (int i = 0; i < n_out; i++) {
				for (int j = 0; j < n_in; j++) {
					this.W[i][j] = Utils.uniform(-a, a, rng);
				}
			}
		} else {
			this.W = W;
		}

		if (b == null)
			this.b = new double[n_out];
		else
			
			this.b = b;

		if (activation == "sigmoid" || activation == null) {
			this.activation = new Sigmoid();
			this.dactivation = new DiscreteSigmoid();

		} else if (activation == "tanh") {
			this.activation = new Tanh();
			this.dactivation = new DiscreteTanh();
		} else if (activation == "ReLU") {
			this.activation = new ReLU();
			this.dactivation = new DiscreteReLU();
		} else {
			throw new IllegalArgumentException("activation function not supported");
		}
	}

	public double output(double[] input, double[] W, double b) {
		double linear_output = 0.0;
		for(int j = 0 ; j < n_in; j++){
			linear_output += W[j] * input[j];
		}
		linear_output += b;
		return activation.execute(linear_output);
	}
	
	public void forward(double[] input, double[] output){
		for(int i = 0 ;i < n_out; i++){
			output[i] = this.output(input, W[i], b[i]);
		}
	}
	
	public void backward(double[] input, double[] dy, double[] prev_layer_input, double[] prev_layer_dy, double[][] prev_layer_W, double lr){
		if(dy == null) dy = new double[n_out];
		
		int prev_n_in = n_out;
		int prev_n_out = prev_layer_dy.length;
		
		for(int i = 0; i < prev_n_in; i++){
			dy[i] = 0;
			for(int j = 0 ; j < prev_n_out; j++){
				dy[i] += prev_layer_dy[i] * prev_layer_W[j][i];
			}
			dy[i] *= dactivation.execute(prev_layer_input[i]);
		}
		
		for(int i = 0 ;i <n_out;i++){
			for(int j = 0 ;j <n_in; j++){
				W[i][j] += lr * dy[i] * input[j] /N;
			}
			b[i] += lr * dy[i] / N;
		}
	}
	
	public int[] dropout(int size, double p, Random rng){
		int[] mask = new int[size];
		
		for(int i = 0 ;i < size; i++){
			mask[i] = Utils.binomial(1, p, rng);
		}
		
		return mask;
	}
}
