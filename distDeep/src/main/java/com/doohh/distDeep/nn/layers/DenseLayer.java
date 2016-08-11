package com.doohh.distDeep.nn.layers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DenseLayer extends FeedforwardLayer {

	public DenseLayer(Builder builder) {
		super(builder);
	}
	
	@AllArgsConstructor
	public static class Builder extends FeedforwardLayer.Builder<Builder>{

		@Override
		public DenseLayer build() {
			// TODO Auto-generated method stub
			return new DenseLayer(this);
		}
		
	}
}
