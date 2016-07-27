package com.doohh.distDeep;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetricOperationExample {
	
		private static final Logger log = LoggerFactory.getLogger(MetricOperationExample.class);
		

		public static void main(String[] args) {
			log.info("start");
			
//			try{
//	            System.out.println("Trying to load: "+"libopenblas");
//	            System.loadLibrary("libopenblas");
//	        }catch (Throwable e){
//	            System.out.println("Failed: "+e.getMessage());
//	            return;
//	        }
//	        System.out.println("Success");
			
//	        INDArray nd = Nd4j.create(new float[]{1, 2, 3, 4}, new int[]{2, 2});
//	        INDArray nd3 = Nd4j.create(new float[]{5,6,7,8},new int[]{2,2});
//	        INDArray ndv;
//	        log.info("start");
//	        
//	        //INDArray nd = Nd4j.ones(new int[]{2, 3});
//	        INDArray b = Nd4j.create(new float[]{1, 2}, new int[]{1, 2});
//	        System.out.println("nd");	        
//	        System.out.println(nd);
//	        System.out.println("b");
//	        System.out.println(b);
//	        //INDArray rst = nd.addRowVector(b);
//	        INDArray rst = nd.muli(2).divi(4);
//	        System.out.println("rst");
//	        System.out.println(rst);
	       
			int size = 1000;
			
	        float[][] mat1 = new float[size][size];	        
	        float[][] mat2 = new float[size][size];
	        float[][] rst = new float[size][size];
	        int i , j;    
	        
	        for(i = 0; i < size; i++){
	        	for(j = 0;j < size; j++){
	        		mat1[i][j] = j+1;
	        		mat2[i][j] = j+1;
	        	}
	        }
	        
	        
	        long startTime = System.currentTimeMillis();
	        for (i = 0; i < size; i++) { // aRow
	            for (j = 0; j < size; j++) { // bColumn
	                for (int k = 0; k < size; k++) { // aColumn
	                    rst[i][j] += mat1[i][k] * mat2[k][j];
	                }
	            }
	        }	
	    	long endTime   = System.currentTimeMillis();
	    	long totalTime = endTime - startTime;
	    	System.out.println(totalTime);
	        
//	        for(i=0;i<size;i++){
//	        	System.out.println();
//	            for(j=0;j<size;j++)
//	                System.out.print(rst[i][j] + " ");
//	        }
	        INDArray ndmat1 = Nd4j.create(mat1);
	        //System.out.println(ndmat1);
	        INDArray ndmat2 = Nd4j.create(mat2);
	        //ndmat2.setOrder('f');
	        //System.out.println(ndmat2);
	        
	        startTime = System.currentTimeMillis();
	        ndmat1.mmul(ndmat2);
	        endTime   = System.currentTimeMillis();
	    	totalTime = endTime - startTime;
	    	System.out.println(totalTime);
	    	
	        //System.out.println(ndmat1.mmul(ndmat2));
	        
//	        ndv = nd.transpose(); // the two and the three switch - a simple transpose
//	        System.out.println("ndv");
//	        System.out.println(ndv);
//
//	        INDArray nd2 = Nd4j.create(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, new int[]{2, 6});
//	        System.out.println("nd2");
//	        System.out.println(nd2);
//
//	        ndv = nd2.transpose(); // this will make a long-rowed matrix into a tall-columned matrix
//	        System.out.println("nd2-transpose");
//	        System.out.println(ndv);
//
//	        ndv = nd2.reshape(3,4); // reshape allows you to enter new row and column parameters, as long as the product
//	        System.out.println("nd2-reshapte");
//	        System.out.println(ndv); // of the new rows and columns equals the product of the old; e.g. 2 * 6 = 3 * 4
//
//	        ndv = nd2.transpose(); // one more transpose just for fun.
//	        System.out.println(ndv);
//
//	        ndv = nd2.linearView(); //make the matrix one long line
//	        System.out.println(ndv);
//
//	        nd2 = Nd4j.create(new float[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}); //now we want a linear matrix, i.e. a row vector
//
//	        ndv = nd2.broadcast(new int[]{6,12}); // broadcast takes a row vector and adds it to all the rows
//	        System.out.println(ndv);


	    }




}
