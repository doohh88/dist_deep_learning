package com.doohh.distDeep.nn.api;

public interface LayerFactory {
	<E extends Layer> E create();
}
