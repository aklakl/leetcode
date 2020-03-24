package com.others.rotation;


public class RotationMatrix {

	/*
	Given an square matrix, turn it by 90 degrees in anti-clockwise direction

	Examples :

	Input
	 1  2  3
	 4  5  6
	 7  8  9

	Output:
	 3  6  9 
	 2  5  8 
	 1  4  7 

	Input:
	 1  2  3  4 
	 5  6  7  8 
	 9 10 11 12 
	13 14 15 16 

	Output:
	 4  8 12 16 
	 3  7 11 15 
	 2  6 10 14 
	 1  5  9 13
Input:
 1(00)  2(01)  3(02)  4(03) 
 5(10)  6(11)  7(12)  8(13)
 9(20) 10(21) 11(22) 12(23) 
13(30) 14(31) 15(32) 16(33) 

Output:
 4(00)  8(01) 12(02) 16(03) 
 3(10)  7(11) 11(12) 15(13) 
 2(20)  6(21) 10(22) 14(23) 
 1(30)  5(31)  9(32) 13(33) 
 
 
Solution 1 Description：
90 degrees in anti-clockwise (i,j)  ===> (n-1-j,i)
90 degrees in clockwise      （i,j)  ===> （j,n-1-i)

Solution 2 Description：
switch

*/
	

	//turn90Degree anti-clockwise
	public Object[][] testMySolution(Object[][] matrixInput) {
		Object[][] matrixNew = new Object[matrixInput.length][matrixInput[0].length];
		/*
		// solution fault
		int indexi=0;
		int indexj=0;
		for(int i = matrixInput.length-1; i>=0 ;i--,indexi++){
			System.out.println("indexi="+indexi+"|i="+i);
			for(int j = matrixInput[i].length-1;j>=0;j--,indexj++){
				matrixNew[indexi][indexj] = matrixInput[i][j];  
			}
		}
		*/
		/*
		// solution fault
		for(int i = 0; i<matrixInput.length ;i++){
			for(int j = 0;j<matrixInput[i].length;j++){
				System.out.println("|i="+i+"|j="+j);
				matrixNew[j][i] = matrixInput[i][j];  
			}
		}
		*/
		for(int i = 0; i<matrixInput.length ;i++){
			int n = matrixInput[i].length;
			for(int j = 0;j<n;j++){
				matrixNew[n-1-j][i] = matrixInput[i][j];  		//turn 90 degrees in anti-clockwise (i,j)  ===> (n-1-j,i)
				//matrixNew[n-1-j][i] = matrixInput[i][j];  	//turn 90 degrees in clockwise      （i,j)  ===> （j,n-1-i)
			}
		}
		return matrixNew;
		
	}
	
	
	//Clockwise
	public static Object[][] turn90DegreeClockwise(Object[][]matrix){
		Object [][]temp=new Object[matrix[0].length][matrix.length];
		int dst=matrix.length-1;
		for(int i=0;i<matrix.length;i++,dst--){
			for(int j=0;j<matrix[0].length;j++){
				temp[j][dst]=matrix[i][j];
			}
		}
		return temp;
	}
	
	
	
	
	
	public static void main(String[] arg) {
		RotationMatrix  rotationMatrix = new RotationMatrix();
		rotationMatrix.testSolution();
	}
	

	
	private void testSolution() {
		//Integer[][] matrixInput ={{1,2,3},{4,5,6},{7,8,9}};
		//Integer[][] matrixInput = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		Object[][] matrixInput = createMatrix(5,5);
		System.out.println("matrixInput");
		printMatrix(matrixInput);
		System.out.println("\n");
		
		Object[][] matrixNew  = matrixInput;
		//different solution
		matrixNew = testMySolution(matrixInput);
		
		//matrixNew = turn90DegreeClockwise(matrixInput);
		
		printMatrix(matrixNew);
		
	}
	
	
	public static Object[][] createMatrixAndPrint(int row,int col) {
		Object[][] matrixInput = createMatrix(row,col);
		System.out.println("createMatrixAndPrint");
		printMatrix(matrixInput);
		System.out.println("\n");
		return matrixInput;
	}
	
	//createMatrix
	public static Object[][] createMatrix(int row,int col) {
		// TODO Auto-generated method stub
		Object matrix[][]=new Object[row][col];
		int k=1;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				matrix[i][j]=k;
				k++;
			}
		}
		return matrix;
	}
	
	public static void printMatrix(Object[][] matrix) {
		//matrix
		for(int ri=0;ri<matrix.length; ri++) {
			for(int ci=0; ci<matrix[ri].length;ci++) {
				System.out.print(matrix[ri][ci] + " ");
			}
			System.out.println("");
		}

	}
	

	
}
