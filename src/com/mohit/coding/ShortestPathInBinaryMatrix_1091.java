package com.mohit.coding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathInBinaryMatrix_1091 {
	
	   public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
		   int n = sc.nextInt();
		   int [][] grid = new int[n][n];
		   for (int i = 0; i < grid.length; i++) {
			   for (int j = 0; j < grid.length; j++) {
				   grid[i][j] = sc.nextInt();
			   }
		   }
		   System.out.println("result: " + shortestPathBinaryMatrix(grid));
		   sc.close();
	   }
	   private static int shortestPathBinaryMatrix(int[][] grid) {
	        if(grid[0][0] == 1)return -1;
			int n = grid.length;
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] {0,0,1});
			grid[0][0] = 1;
			int [][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
			while(!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i <size; i++) {
					int[] point = q.poll();
					int r = point[0], c = point[1];
					if(r == n-1 && c == n-1) {
						return point[2];
					}
					
					for (int[] d : dir) {
						r = point[0] + d[0];
						c = point[1] + d[1];
						
						if(r >= 0 && c >= 0 && r < n && c < n && grid[r][c] == 0) {
							q.add(new int[] {r,c,point[2]+1});
							grid[r][c]=1;
						}
					}
				}
			}
			return -1;
	    }
}
