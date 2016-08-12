package com.doohh.distDeep.nn.conf;

import java.util.ArrayList;
import java.util.List;

import com.doohh.distDeep.weights.WeightInit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class LayerConf {
	protected String layerName;
	protected String activationFunction;
	protected WeightInit weightInit;
    protected double biasInit;
    protected double learningRate;
    protected double biasLearningRate;
    
    public LayerConf(Builder builder) {
        this.layerName = builder.layerName;
    	this.activationFunction = builder.activationFunction;
    	this.weightInit = builder.weightInit;
        this.biasInit = builder.biasInit;
        this.learningRate = builder.learningRate;
        this.biasLearningRate = builder.biasLearningRate;
    }
    
    @Data
    public abstract static class Builder<T extends Builder<T>>{
        protected String layerName = null;
        protected String activationFunction = null;
        protected WeightInit weightInit = null;
        protected double biasInit = Double.NaN;
        protected double learningRate = Double.NaN;
        protected double biasLearningRate = Double.NaN;
          
          public T name(String layerName){
        	  this.layerName = layerName;
        	  return (T) this;
          }
          public T activation(String activationFunction) {
              this.activationFunction = activationFunction;
              return (T) this;
          }
          public T weightInit(WeightInit weightInit) {
              this.weightInit = weightInit;
              return (T) this;
          }
          public T biasInit(double biasInit) {
              this.biasInit = biasInit;
              return (T) this;
          }
          public T learningRate(double learningRate){
              this.learningRate = learningRate;
              return (T)this;
          }
          public T biasLearningRate(double biasLearningRate){
              this.biasLearningRate = biasLearningRate;
              return (T)this;
          }
          
          public abstract <E extends LayerConf> E build();
    }
}
