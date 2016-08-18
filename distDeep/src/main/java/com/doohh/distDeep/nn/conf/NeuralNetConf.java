package com.doohh.distDeep.nn.conf;

import java.util.ArrayList;
import java.util.List;

import org.nd4j.linalg.factory.Nd4j;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NeuralNetConf {
	protected List<NetConf> confs;
	protected boolean backprop = false;

	public NetConf getConf(int i) {
		return confs.get(i);
	}

	@Data
	public static class Builder {
		protected List<NetConf> confs = new ArrayList<>();
		protected boolean backprop = false;

		public Builder backprop(boolean backprop) {
			this.backprop = backprop;
			return this;
		}

		public Builder confs(List<NetConf> confs) {
			this.confs = confs;
			return this;
		}

		public NeuralNetConf build() {
			NeuralNetConf conf = new NeuralNetConf();
			conf.confs = this.confs;
			conf.backprop = backprop;
			Nd4j.getRandom().setSeed(conf.getConf(0).getSeed());
			return conf;
		}
	}
}
