package com.doohh.distDeep;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.heartbeat.utils.TaskUtils;

public class XorExample {
	public static void main(String[] args) {
		INDArray input = Nd4j.zeros(4, 2);
		INDArray labels = Nd4j.zeros(4, 2);
		input.putScalar(new int[] { 0, 0 }, 0);
		input.putScalar(new int[] { 0, 1 }, 0);
		// then the first output fires for false, and the second is 0 (see class
		// comment)
		labels.putScalar(new int[] { 0, 0 }, 1);
		labels.putScalar(new int[] { 0, 1 }, 0);

		// when first input=1 and second input=0
		input.putScalar(new int[] { 1, 0 }, 1);
		input.putScalar(new int[] { 1, 1 }, 0);
		// then xor is true, therefore the second output neuron fires
		labels.putScalar(new int[] { 1, 0 }, 0);
		labels.putScalar(new int[] { 1, 1 }, 1);

		// same as above
		input.putScalar(new int[] { 2, 0 }, 0);
		input.putScalar(new int[] { 2, 1 }, 1);
		labels.putScalar(new int[] { 2, 0 }, 0);
		labels.putScalar(new int[] { 2, 1 }, 1);

		// when both inputs fire, xor is false again - the first output should
		// fire
		input.putScalar(new int[] { 3, 0 }, 1);
		input.putScalar(new int[] { 3, 1 }, 1);
		labels.putScalar(new int[] { 3, 0 }, 1);
		labels.putScalar(new int[] { 3, 1 }, 0);
		
		System.out.println(input);
		System.out.println("------------------------");
		System.out.println(labels);
		System.out.println("------------------------");
		
		DataSet ds = new DataSet(input, labels);
		System.out.println("------------------------");
		System.out.println(ds);
		System.out.println("------------------------");
		System.out.println(ds.getFeatureMatrix());
		System.out.println("------------------------");
		System.out.println(ds.getLabels());
		System.out.println("------------------------");
		
		System.out.println(TaskUtils.buildTask(input, labels));
	}
}
