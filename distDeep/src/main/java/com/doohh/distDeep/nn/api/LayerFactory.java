package com.doohh.distDeep.nn.api;

import com.doohh.distDeep.nn.conf.NetConf;

public interface LayerFactory {
	<E extends Layer> E create(NetConf conf, int index, boolean initializeParmas);
	ParamInitializer initializer();
}
