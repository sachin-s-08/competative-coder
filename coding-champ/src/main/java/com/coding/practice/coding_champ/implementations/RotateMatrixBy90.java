package com.coding.practice.coding_champ.implementations;

public class RotateMatrixBy90 {
	
	public static void main(String[] args) throws Exception {
		RotateMatrixBy90 test = new RotateMatrixBy90();
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] arr2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		
		test.rotate(arr2);
		

	}

	public void rotate(int[][] arr) {
		
		int N = arr.length;
		for (int i = 0; i < N/2; i++) {
			for (int j = i; j < N -1-i; j++) {
				int temp = arr[j][N-1-i];
				arr[j][N-1-i] = arr[i][j];
				arr[i][j] = arr[N-1-j][N-1 - (N-1-i)] ;
				arr[N-1-j][N-1 - (N-1-i)] =  arr[N-1-i][N-1-j];
				arr[N-1-i][N-1-j] = temp;
			}
			
		}
	}
}
