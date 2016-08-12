package com.doohh.distDeep.weights;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class WeightInitUtil {
	public static INDArray initWeights(int[] shape, float min, float max){
		return Nd4j.rand(shape, min, max, Nd4j.getRandom());
	}
}
