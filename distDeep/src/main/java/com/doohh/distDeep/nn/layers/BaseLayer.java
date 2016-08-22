package com.doohh.distDeep.nn.layers;

import java.util.Map;

import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.gradient.Gradient;
import com.doohh.distDeep.nn.api.Layer;
import com.doohh.distDeep.nn.conf.LayerConf;
import com.doohh.distDeep.nn.conf.NetConf;

import lombok.Data;

@Data
public class BaseLayer<LayerConfT extends LayerConf> implements Layer{
    protected INDArray input;
    protected INDArray paramsFlattened;
    protected INDArray gradientsFlattened;
    protected Map<String,INDArray> params;
    protected transient Map<String,INDArray> gradientRef;
    protected NetConf conf;
    protected Gradient gradient;
    protected int index = 0;

    public BaseLayer(NetConf conf) {
        this.conf = conf;
    }
    
    public BaseLayer(NetConf conf, INDArray input) {
        this.input = input;
        this.conf = conf;
    }
    
    protected LayerConfT layerConf() {
        return (LayerConfT) this.conf.getLayerConf();
    }
    
    



}
