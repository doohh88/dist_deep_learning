package com.doohh.distDeep.nn.conf;

import java.util.ArrayList;
import java.util.List;

import com.doohh.distDeep.weights.WeightInit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class NeuralNetConf {
	protected List<LayerConf> confs; 
	protected int iterations;
	protected double learningRate;
	
	@Data
	public static class Builder {
		protected List<LayerConf> confs = new ArrayList();
		protected int iterations = 0;
		protected double learningRate = 1e-1;
		
		public Builder confs(List<LayerConf> confs){
			this.confs = confs;
			return this;
		}
		public Builder iterations(int iterations){
			this.iterations = iterations;
			return this;
		}
		public Builder learningRate(double learningRate){
			this.learningRate = learningRate;
			return this;
		}
		
		
		public NeuralNetConf build() {
			// TODO Auto-generated method stub
			NeuralNetConf conf = new NeuralNetConf();
			conf.confs = this.confs;
			conf.iterations = this.iterations;
			
			return conf;
		}
	}
}
