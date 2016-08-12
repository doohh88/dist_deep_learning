package com.doohh.distDeep.nn.layers.factory;

import com.doohh.distDeep.nn.api.Layer;
import com.doohh.distDeep.nn.api.LayerFactory;
import com.doohh.distDeep.nn.conf.LayerConf;

public class DefaultLayerFactory implements LayerFactory {
	
	protected LayerConf layerConf;
	
	public DefaultLayerFactory(Class<? extends LayerConf> layerConf) {
		// TODO Auto-generated constructor stub
		try {
			this.layerConf = layerConf.newInstance();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public <E extends Layer> E create(LayerConf conf) {
		// TODO Auto-generated method stub
		Layer ret = getInstance(conf);
		return null;
	}
	
	protected Layer getInstance(LayerConf conf){
		return new Layer
	}
}
