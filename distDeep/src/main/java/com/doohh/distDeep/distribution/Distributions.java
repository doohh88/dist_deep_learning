package com.doohh.distDeep.distribution;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Distributions {
	public static Distribution createDistribution(Distribution dist) {
		if(dist == null){
			return null;
		}
        throw new RuntimeException("unknown distribution type: " + dist.getClass());
	}
}
