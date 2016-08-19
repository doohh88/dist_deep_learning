package com.doohh.distDeep.nn.conf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DenseLayerConf extends FeedForwardLayerConf {

	public DenseLayerConf(Builder builder) {
		super(builder);
	}
	
	@AllArgsConstructor
	public static class Builder extends FeedForwardLayerConf.Builder<Builder>{

		@Override
		public DenseLayerConf build() {
			// TODO Auto-generated method stub
			return new DenseLayerConf(this);
		}
		
	}
}
