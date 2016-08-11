package com.doohh.distDeep.nn.layers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class BaseOutputLayer extends FeedforwardLayer{
	protected BaseOutputLayer(Builder builder){
		super(builder);
		
	}
	
	@NoArgsConstructor
	public static abstract class Builder<T extends Builder<T>> extends FeedforwardLayer.Builder<T> {
		
	}
}
