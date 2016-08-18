package com.doohh.distDeep.gradient;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class DefaultGradient implements Gradient {
	public static final char DEFAULT_FLATTENING_ORDER = 'f';
	private Map<String, INDArray> gradients = new LinkedHashMap<>();
	private Map<String, Character> flatteningOrders;
	private INDArray flattenedGradient;

	public INDArray gradient() {
		// TODO Auto-generated method stub
		if (flattenedGradient != null)
			return flattenedGradient;

		if (flatteningOrders != null) {
			List<INDArray> toFlatten = new ArrayList<>();
			for (Map.Entry<String, INDArray> entry : gradients.entrySet()) {
				if (flatteningOrders.containsKey(entry.getKey())
						&& flatteningOrders.get(entry.getKey()) != DEFAULT_FLATTENING_ORDER) {
					toFlatten.add(Nd4j.toFlattened(flatteningOrders.get(entry.getKey()), entry.getValue()));
				} else {
					toFlatten.add(entry.getValue());
				}
			}
		} else {
			flattenedGradient = Nd4j.toFlattened(DEFAULT_FLATTENING_ORDER, gradients.values());
		}

		return flattenedGradient;
	}
}
