package com.doohh.distDeep.nn.conf;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class FeedforwardLayerConf extends LayerConf {
	protected int nIn;
	protected int nOut;
	
	public FeedforwardLayerConf(Builder builder) {
		super(builder);
    	this.nIn = builder.nIn;
    	this.nOut = builder.nOut;		
	}
	
	public abstract static class Builder<T extends Builder<T>> extends LayerConf.Builder<T> {
        protected int nIn = 0;
        protected int nOut = 0;
        
        public T nIn(int nIn) {
            this.nIn = nIn;
            return (T) this;
        }

        public T nOut(int nOut) {
            this.nOut = nOut;
            return (T) this;
        }
	}

}
