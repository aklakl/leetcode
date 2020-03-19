package com.others.loop.graph;

import com.others.rotation.RotationMatrix;

public class LoopGraph {


	public void testSolution() {
		Object[][] matrix = RotationMatrix.createMatrixAndPrint(11,11);
		System.out.println(matrix.length);
		for(int i=0;i<matrix.length;i++) {
			for(int j =0;j<matrix[i].length;j++) {
				matrix[i][j]="#";
			}
		}
		RotationMatrix.printMatrix(matrix);
	
	}


	//java print graph
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoopGraph loopGraph = new LoopGraph();
		loopGraph.testSolution();

	}

}
