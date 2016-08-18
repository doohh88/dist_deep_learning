package com.doohh.distDeep.weights;

import org.apache.commons.math3.util.FastMath;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.rng.distribution.Distribution;
import org.nd4j.linalg.factory.Nd4j;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WeightInitUtil {
	public static final char DEFAULT_WEIGHT_INIT_ORDER = 'f';

	public static INDArray initWeights(int[] shape, float min, float max) {
		return Nd4j.rand(shape, min, max, Nd4j.getRandom());
	}

	public static INDArray uniformBasedOnInAndOut(int[] shape, int nIn, int nOut) {
        double min = -4.0 * Math.sqrt(6.0 / (double) (nOut + nIn));
        double max = 4.0 * Math.sqrt(6.0 / (double) (nOut + nIn));
        return Nd4j.rand(shape, Nd4j.getDistributions().createUniform(min, max));
    }
    
	public static INDArray initWeights(int[] shape, WeightInit initScheme, Distribution dist, char order, INDArray paramView) {
        INDArray ret;
        switch (initScheme) {
            case DISTRIBUTION:
                ret = dist.sample(shape);
                break;
            case NORMALIZED:
                ret = Nd4j.rand(order, shape);
                ret.subi(0.5).divi(shape[0]);
                break;
            case RELU:
                ret = Nd4j.randn(order, shape).muli(FastMath.sqrt(2.0 / shape[0]));   //N(0, 2/nIn)
                break;
            case SIZE:
                ret = uniformBasedOnInAndOut(shape, shape[0], shape[1]);
                break;
            case UNIFORM:
                double a = 1 / (double) shape[0];
                ret = Nd4j.rand(order, shape).muli(2 * a).subi(a);
                break;
            case VI:
                ret = Nd4j.rand(order, shape);
                int len = 0;
                for (int aShape : shape) {
                    len += aShape;
                }
                double r = Math.sqrt(6) / Math.sqrt(len + 1);
                ret.muli(2 * r).subi(r);
                break;
            case XAVIER:
                ret = Nd4j.randn(order, shape).divi(FastMath.sqrt(shape[0] + shape[1]));
                break;
            case ZERO:
                ret = Nd4j.create(shape, order);
                break;
            default:
                throw new IllegalStateException("Illegal weight init value: " + initScheme);
        }

        INDArray flat = Nd4j.toFlattened(order, ret);
        if (flat.length() != paramView.length())
            throw new RuntimeException("ParamView length does not match initialized weights length");

        paramView.assign(flat);

        return paramView.reshape(order, shape);
    }
	
	public static INDArray initWeights(int[] shape, WeightInit initScheme, Distribution dist, INDArray paramView) {
		return initWeights(shape, initScheme, dist, DEFAULT_WEIGHT_INIT_ORDER, paramView);
	}
	public static INDArray initWeights(int nIn, int nOut, WeightInit initScheme, Distribution dist,
			INDArray paramView) {
		return initWeights(new int[] { nIn, nOut }, initScheme, dist, paramView);
	}
}
