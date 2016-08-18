package com.doohh.distDeep.nn.api;

import org.apache.commons.lang3.tuple.Pair;
import org.nd4j.linalg.api.ndarray.INDArray;

import com.doohh.distDeep.gradient.Gradient;

public interface Layer {
    enum Type {
        FEED_FORWARD,RECURRENT,CONVOLUTIONAL,SUBSAMPLING,RECURSIVE,MULTILAYER,NORMALIZATION
     }

     enum TrainingMode {
         TRAIN,TEST
     }
     
     Type type();
     Gradient calcGradient(Gradient layerError, INDArray indArray);
     Pair<Gradient,INDArray> backpropGradient(INDArray epsilon);
     void update(Gradient gradient);
     INDArray activate(INDArray input,TrainingMode training);

}
