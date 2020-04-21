package leetcode975;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] A = {2,3,1,1,4};
		
		System.out.println("Input: " + Arrays.toString(A));
		
		FindNumOfWayToHaveOddEvenFunction solution = new FindNumOfWayToHaveOddEvenFunction();
		
		System.out.println("Solution: " + solution.oddEvenJumps(A));
	}
}
