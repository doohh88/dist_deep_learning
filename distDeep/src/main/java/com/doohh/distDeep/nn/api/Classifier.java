package com.doohh.distDeep.nn.api;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;

public interface Classifier {
    void fit(INDArray examples, INDArray labels);
    void fit(DataSet data);
}
