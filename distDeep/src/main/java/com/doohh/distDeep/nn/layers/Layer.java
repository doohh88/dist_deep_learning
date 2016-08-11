package com.doohh.distDeep.nn.layers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Layer {
	protected String layerName;
	protected String activationFunction;
    protected double learningRate;
    protected double biasLearningRate;
    protected double dropOut;
    
    public Layer(Builder builder) {
        this.layerName = builder.layerName;
    	this.activationFunction = builder.activationFunction;
        this.learningRate = builder.learningRate;
        this.biasLearningRate = builder.biasLearningRate;
        this.dropOut = builder.dropOut;
    }
    
    public abstract static class Builder<T extends Builder<T>>{
    	  protected String layerName = null;
          protected String activationFunction = null;
          protected double biasInit = Double.NaN;
          protected double learningRate = Double.NaN;
          protected double biasLearningRate = Double.NaN;
          protected double dropOut = Double.NaN;
          
          public T name(String layerName){
        	  this.layerName = layerName;
        	  return (T) this;
          }
          public T activation(String activationFunction) {
              this.activationFunction = activationFunction;
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
          public T dropOut(double dropOut) {
              this.dropOut = dropOut;
              return (T) this;
          }
          
          public abstract <E extends Layer> E build();
    }
    
    
}
