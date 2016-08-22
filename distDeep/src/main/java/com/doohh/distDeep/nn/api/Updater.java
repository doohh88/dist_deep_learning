package com.doohh.distDeep.nn.api;

import com.doohh.distDeep.gradient.Gradient;

public interface Updater {
	void update(Layer layer, Gradient gradient, int iteration, int miniBatchSize);
}
