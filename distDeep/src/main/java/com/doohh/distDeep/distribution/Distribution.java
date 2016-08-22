package com.doohh.distDeep.distribution;

public class Distribution implements Cloneable {
	@Override
	public Distribution clone() {
		try {
			return (Distribution)super.clone();			
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
}
