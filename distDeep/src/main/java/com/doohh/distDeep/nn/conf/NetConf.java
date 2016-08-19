package com.doohh.distDeep.nn.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nd4j.linalg.factory.Nd4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doohh.distDeep.weights.WeightInit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NetConf implements Cloneable {
	private static final Logger log = LoggerFactory.getLogger(NetConf.class);

	protected LayerConf layerConf;
	protected boolean miniBatch = true;
	protected int numIterations;
	protected long seed;
    protected boolean useDropConnect = false;

    @Override
    public NetConf clone(){
    	// TODO Auto-generated method stub
    	try {
    		NetConf clone = (NetConf) super.clone();
        	if(clone.layerConf != null) clone.layerConf.clone();
       		return clone;	
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
    }
    
	@Data
	public static class ListBuilder extends NeuralNetConf.Builder {
		private Map<Integer, Builder> layerwise;

		public ListBuilder backprop(boolean backprop) {
			this.backprop = backprop;
			return this;
		}

		public ListBuilder layer(int ind, LayerConf layerConf) {
			if (layerwise.containsKey(ind)) {

			} else {
			}
			return this;
		}

		public NeuralNetConf build() {
			List<NetConf> list = new ArrayList<>();

			return new NeuralNetConf.Builder().confs(list).build();
		}
	}

	@Data
	public static class Builder {
		protected String activationFunction = "sigmoid";
		protected WeightInit weightInit = WeightInit.XAVIER;
		protected double biasInit = 0.0;
		protected double learningRate = 1e-1;
		protected double biasLearningRate = Double.NaN;
		protected double dropOut = 0;
		protected Updater updater = Updater.SGD;
		protected LayerConf layerConf;
		protected boolean miniBatch = true;
		protected int numIterations = 5;
		protected long seed = System.currentTimeMillis();
		protected boolean useDropConnect = false;
		protected LearningRatePolicy learningRatePolicy = LearningRatePolicy.None;

		public Builder miniBatch(boolean miniBatch) {
			this.miniBatch = miniBatch;
			return this;
		}

		public Builder useDropConnect(boolean useDropConnect) {
			this.useDropConnect = useDropConnect;
			return this;
		}

		public Builder layer(LayerConf layerConf) {
			this.layerConf = layerConf;
			return this;
		}

		public Builder iterations(int numIterations) {
			this.numIterations = numIterations;
			return this;
		}

		public Builder seed(int seed) {
			this.seed = (long) seed;
			Nd4j.getRandom().setSeed(seed);
			return this;
		}

		public Builder seed(long seed) {
			this.seed = seed;
			Nd4j.getRandom().setSeed(seed);
			return this;
		}

		public Builder activation(String activationFunction) {
			this.activationFunction = activationFunction;
			return this;
		}

		public Builder weightInit(WeightInit weightInit) {
			this.weightInit = weightInit;
			return this;
		}

		public Builder biasInit(double biasInit) {
			this.biasInit = biasInit;
			return this;
		}

		public Builder learningRate(double learningRate) {
			this.learningRate = learningRate;
			return this;
		}

		public Builder biasLearningRate(double biasLearningRate) {
			this.biasLearningRate = biasLearningRate;
			return this;
		}

		public Builder dropOut(double dropOut) {
			this.dropOut = dropOut;
			return this;
		}

		public Builder updater(Updater updater) {
			this.updater = updater;
			return this;
		}

		public NetConf build() {
			NetConf conf = new NetConf();
			conf.layerConf = layerConf;
			conf.numIterations = numIterations;
			conf.seed = seed;
            conf.useDropConnect = useDropConnect;
            conf.miniBatch = miniBatch;
            
            if(layerConf != null ) {
                if (Double.isNaN(layerConf.getLearningRate())) layerConf.setLearningRate(learningRate);
                if (Double.isNaN(layerConf.getBiasLearningRate())) layerConf.setBiasLearningRate(layerConf.getLearningRate());
                if (layerConf.getActivationFunction() == null) layerConf.setActivationFunction(activationFunction);
                if (layerConf.getWeightInit() == null) layerConf.setWeightInit(weightInit);
                if (Double.isNaN(layerConf.getBiasInit())) layerConf.setBiasInit(biasInit);
                if (Double.isNaN(layerConf.getDropOut())) layerConf.setDropOut(dropOut);
                if (layerConf.getUpdater() == null) layerConf.setUpdater(updater);

            }
			return conf;
		}
	}
}
