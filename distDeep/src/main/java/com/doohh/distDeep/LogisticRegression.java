package com.doohh
.distDeep;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.impl.transforms.SoftMax;
import org.nd4j.linalg.factory.Nd4j;

*//**
 * Hello world!
 *
 *//*
public class LogisticRegression 
{
	public int N;
	public int n_in;
	public int n_out;
	INDArray W;
	
	public LogisticRegression(int N, int n_in, int n_out) {
		// TODO Auto-generated constructor stub
		this.N = N;
		this.n_in = n_in;
		this.n_out = n_out;
		
		W = Nd4j.rand(new int[]{n_in, n_out});
		System.out.println("W : " + W);
	}
	
	
	private void train(INDArray x, INDArray y, double lr) {
		// TODO Auto-generated method stub
		INDArray hypothesis = Nd4j.create(new int[]{n_out});
		INDArray dy = Nd4j.create(new int[]{n_out});
		
		hypothesis = x.mmul(W);
		Nd4j.getExecutioner().exec(new SoftMax(hypothesis), 1);
		
		dy = y.sub(hypothesis);

	}
	
//	public double[] train(double[] x, int[] y, double lr) {
//        double[] p_y_given_x = new double[n_out];
//        double[] dy = new double[n_out];
//		
//		// 기존 파라미터 기반으로 값을 예측
//        for(int i=0; i<n_out; i++) {
//            p_y_given_x[i] = 0;
//            for(int j=0; j<n_in; j++) {
//                p_y_given_x[i] += W[i][j] * x[j];
//            }
//            p_y_given_x[i] += b[i];
//        }
//        softmax(p_y_given_x);
//		
//		//예측갑과 training data의 결과값을 기준으로 gradient descent
//        for(int i=0; i<n_out; i++) {
//            dy[i] = y[i] - p_y_given_x[i];
//
//            for(int j=0; j<n_in; j++) {
//                W[i][j] += lr * dy[i] * x[j] / N;
//            }
//
//            b[i] += lr * dy[i] / N;
//        }
//
//        return dy;
//	}

	
	 
	 private void predict(INDArray x, INDArray y) {
		// TODO Auto-generated method stub
		 y = x.mmul(W);
		 Nd4j.getExecutioner().exec(new SoftMax(y), 1);

	}
	 
	 
	private static void test_lr() {
		double learning_rate = 0.1;
		int n_epochs = 500;
		
		int train_N = 6;
		int test_N = 2;
		int n_in = 6;
		int n_out = 2;
		
		INDArray train_X = Nd4j.ones(new int[]{train_N+1, n_in});
		train_X.put
		
		INDArray train_X = Nd4j.create(new float[][]{
              {1, 1, 1, 0, 0, 0},
              {1, 0, 1, 0, 0, 0},
              {1, 1, 1, 0, 0, 0},
              {0, 0, 1, 1, 1, 0},
              {0, 0, 1, 1, 0, 0},
              {0, 0, 1, 1, 1, 0}
      });
		train_X.putColumn(0, arg1)
		
		
		INDArray train_Y = Nd4j.create(new float[][]{
                {1, 0},
                {1, 0},
                {1, 0},
                {0, 1},
                {0, 1},
                {0, 1}
        });
     
        LogisticRegression classifier = new LogisticRegression(train_N, n_in, n_out);
        
        //train
        for(int epoch = 0; epoch < n_epochs; epoch++){
        	classifier.train(train_X, train_Y, learning_rate);
        }
        
        INDArray test_X = Nd4j.create(new float[][]{
                {1, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0}
        });
        
        
        INDArray test_Y = Nd4j.create(new int[]{test_N, n_out});

        classifier.predict(test_X, test_Y);
        
        System.out.println(test_Y);
        
        
	}
	
    public static void main( String[] args )
    {
        test_lr();    	
    }
}
