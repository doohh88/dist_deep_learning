package com.doohh.distDeep.nn.layers.factory;

import com.doohh.distDeep.nn.api.LayerFactory;
import com.doohh.distDeep.nn.conf.LayerConf;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LayerFactories {
	
	public static LayerFactory getFactory(LayerConf layerConf){
		Class<? extends LayerConf> clazz = layerConf.getClass();
		return new DefaultLayerFactory(clazz);
	}
}
