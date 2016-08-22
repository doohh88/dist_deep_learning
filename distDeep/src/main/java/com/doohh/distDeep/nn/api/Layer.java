package com.doohh.distDeep.nn.api;

import org.apache.commons.lang3.tuple.Pair;
import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.gradient.Gradient;

public interface Layer extends Model {
    enum Type {
        FEED_FORWARD,RECURRENT,CONVOLUTIONAL,SUBSAMPLING,RECURSIVE,MULTILAYER,NORMALIZATION
     }

     enum TrainingMode {
         TRAIN,TEST
     }
     
     Type type();
}
