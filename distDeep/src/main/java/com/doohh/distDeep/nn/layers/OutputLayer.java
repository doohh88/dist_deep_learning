package com.doohh.distDeep.nn.layers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OutputLayer extends BaseOutputLayer {
    protected OutputLayer(Builder builder) {
    	super(builder);
    }
    
    @NoArgsConstructor
    public static class Builder extends BaseOutputLayer.Builder<Builder>{
    		
    	
    	@Override
    	public OutputLayer build() {
    		// TODO Auto-generated method stub
    		return new OutputLayer(this);
    	}
    }
}
