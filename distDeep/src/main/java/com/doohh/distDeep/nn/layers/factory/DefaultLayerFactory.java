package com.doohh.distDeep.nn.layers.factory;

import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.nn.api.Layer;
import com.doohh.distDeep.nn.api.LayerFactory;
import com.doohh.distDeep.nn.conf.DenseLayerConf;
import com.doohh.distDeep.nn.conf.LayerConf;
import com.doohh.distDeep.nn.conf.NetConf;
import com.doohh.distDeep.nn.conf.OutputLayerConf;

import lombok.Data;

@Data
public class DefaultLayerFactory implements LayerFactory {
	protected LayerConf layerConf;

	public DefaultLayerFactory(Class<LayerConf> layerConf) {
		try {
			this.layerConf = layerConf.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public <E extends Layer> E create(NetConf conf, int index, INDArray layerParamsRef, boolean initializeParmas) {
        Layer ret = getInstance(conf);
        ret.setIndex(index);
        ret.setConf(conf);
        return (E) ret;
		
		return null;
	}
	
	protected Layer getInstance(NetConf conf){
		if(layerConf instanceof DenseLayerConf){
			return new DenseLayer(conf);
		} else if(layerConf instanceof OutputLayerConf){
			return new OutputLayer(conf);
		} 
		throw new RuntimeException("unknown layer type : " + layerConf);
	}
}
