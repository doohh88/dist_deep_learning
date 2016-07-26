package com.doohh.distDeep;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.impl.transforms.SoftMax;
import org.nd4j.linalg.factory.Nd4j;

public class LogisticRegressionND4j 
{
	public int N;
	public int n_in;
	public int n_out;
	INDArray W;
	INDArray b;
	
	
	public LogisticRegressionND4j(int N, int n_in, int n_out) {
		// TODO Auto-generated constructor stub
		this.N = N;
		this.n_in = n_in;
		this.n_out = n_out;
		
		W = Nd4j.rand(new int[]{n_in, n_out});
		b = Nd4j.rand(new int[]{n_out});
		
	}
	
	
	private void train(INDArray x, INDArray y, double lr) {
		// TODO Auto-generated method stub
		INDArray hypothesis = Nd4j.create(new int[]{n_out});
		INDArray dy = Nd4j.create(new int[]{N, n_out});
		hypothesis = x.mmul(W).addRowVector(b);		
		Nd4j.getExecutioner().exec(new SoftMax(hypothesis), 1);
		
		dy = y.sub(hypothesis);
		for(int i = 0; i < N; i++){
			W = W.add(x.getRow(i).transpose().mmul(dy.getRow(i)));
			b = b.add(dy.getRow(i).muli(lr).divi(N));
		}
	}
	 
	 private INDArray predict(INDArray x, INDArray y) {
		// TODO Auto-generated method stub
		 y = x.mmul(W).addRowVector(b);
		 Nd4j.getExecutioner().exec(new SoftMax(y), 1);
		 return y;
	}
	 
	 
	private static void test_lr() {
		long startTime = System.currentTimeMillis();
		
		double learning_rate = 0.1;
		int n_epochs = 500;
		
		int train_N = 6;
		int test_N = 2;
		int n_in = 6;
		int n_out = 2;
		
		INDArray train_X = Nd4j.create(new float[][]{
              {1, 1, 1, 0, 0, 0},
              {1, 0, 1, 0, 0, 0},
              {1, 1, 1, 0, 0, 0},
              {0, 0, 1, 1, 1, 0},
              {0, 0, 1, 1, 0, 0},
              {0, 0, 1, 1, 1, 0}
      });
				
		INDArray train_Y = Nd4j.create(new float[][]{
                {1, 0},
                {1, 0},
                {1, 0},
                {0, 1},
                {0, 1},
                {0, 1}
        });
     
        LogisticRegressionND4j classifier = new LogisticRegressionND4j(train_N, n_in, n_out);
        
        //train
        for(int epoch = 0; epoch < n_epochs; epoch++){
        	classifier.train(train_X, train_Y, learning_rate);        	
        }
        
        INDArray test_X = Nd4j.create(new float[][]{
                {1, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0}
        });
        
        
        INDArray test_Y = Nd4j.create(new int[]{test_N, n_out});

        test_Y = classifier.predict(test_X, test_Y);
        
        System.out.println("y : " + test_Y);
        long endTime   = System.currentTimeMillis();
    	long totalTime = endTime - startTime;
    	System.out.println(totalTime);
        
	}
	
    public static void main( String[] args )
    {
    	test_lr();    	
    }
}
