/*package com.doohh.distDeep;

import java.util.ArrayList;
import java.util.Random;

import com.doohh.distDeep.layer.HiddenLayer;

public class MLPmultiHidden {
	public int N;
    public int n_in;
    public ArrayList<Integer> n_hidden;
    public int n_out;
    public HiddenLayer hiddenLayer1;
    public HiddenLayer hiddenLayer2;
    public LogisticRegression logisticLayer;
    public Random rng;


    public MLPmultiHidden(int N, int n_in, ArrayList<Integer> n_hidden, int n_out, Random rng) {

        this.N = N;
        this.n_in = n_in;
        this.n_hidden = n_hidden;
        this.n_out = n_out;

        if (rng == null)rng = new Random(1234);
        this.rng = rng;

        // construct hiddenLayer
        
        this.hiddenLayer1 = new HiddenLayer(N, n_in, 3, null, null, rng, "tanh");
        this.hiddenLayer2 = new HiddenLayer(N, 3, 3, null, null, rng, "tanh");
        
        // construct logisticLayer
        this.logisticLayer = new LogisticRegression(N, 3, n_out);
    }


    public void train(double[][] train_X, int[][] train_Y, double lr) {
    	double[] layer_input;
    	double[] hidden_layer_input;
        double[] logistic_layer_input;
        double[] dy;

        for(int n=0; n<N; n++) {
        	layer_input = new double[2];
            hidden_layer_input = new double[3];
            logistic_layer_input = new double[3];

            for(int j=0; j<n_in; j++) layer_input[j] = train_X[n][j];

            // forward hiddenLayer
            hiddenLayer1.forward(layer_input, hidden_layer_input);
            hiddenLayer2.forward(hidden_layer_input, logistic_layer_input);

            // forward and backward logisticLayer
            // dy = new double[n_out];  // define delta of y for backpropagation
            dy = logisticLayer.train(logistic_layer_input, train_Y[n], lr); //, dy);

            // backward hiddenLayer
            hiddenLayer2.backward(hidden_layer_input, null, logistic_layer_input, dy, logisticLayer.W, lr);
            hiddenLayer1.backward(layer_input, null, hidden_layer_input, dy, logisticLayer.W, lr);

        }
    }

    public void predict(double[] x, double[] y) {
    	double[] hidden_layer_input = new double[3];
        double[] logistic_layer_input = new double[3];
        hiddenLayer1.forward(x, hidden_layer_input);
        hiddenLayer2.forward(hidden_layer_input, logistic_layer_input);
        logisticLayer.predict(logistic_layer_input, y);
    }



    private static void test_mlp() {
        Random rng = new Random(123);

        double learning_rate = 0.1;
        int n_epochs = 5000;

        int train_N = 4;
        int test_N = 4;
        int n_in = 2;
        ArrayList<Integer> n_hidden = new ArrayList();
        n_hidden.add(3);
        n_hidden.add(3);
        int n_out = 2;

        double[][] train_X = {
                {0., 0.},
                {0., 1.},
                {1., 0.},
                {1., 1.},
        };

        int[][] train_Y = {
                {1, 0},
                {0, 1},
                {0, 1},
                {0, 1},
        };

        // construct MLP
        MLPmultiHidden classifier = new MLPmultiHidden(train_N, n_in, n_hidden, n_out, rng);

        // train
        for(int epoch=0; epoch<n_epochs; epoch++) {
            classifier.train(train_X, train_Y, learning_rate);
        }

        // test data
        double[][] test_X = {
                {0., 0.},
                {0., 1.},
                {1., 0.},
                {1., 1.},
        };

        double[][] test_Y = new double[test_N][n_out];


        // test
        for(int i=0; i<test_N; i++) {
            classifier.predict(test_X[i], test_Y[i]);
            for(int j=0; j<n_out; j++) {
                System.out.print(test_Y[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        test_mlp();
    }
}
*/