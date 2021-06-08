package leetcode975;

import java.util.Map;
import java.util.TreeMap;

public class FindNumOfWayToHaveOddEvenFunction {
	// odd when A[i] <= A[j]
	// even when A[i] >= A[j]
	public int oddEvenJumps(int[] A) {
        int result = 1;
        
        int n = A.length - 1;
        
        // mark true if current element could do odd jump
        boolean[] oddHigher = new boolean[n + 1];
        
        // mark true if current element could do even jump
        boolean[] evenLower = new boolean[n + 1];
        
        // default last element could do even or odd jump
        oddHigher[n] = true;
        evenLower[n] = true;
        
        // Key will be the element
        // value will be the index of element
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        
        // Put the last element as base case
        sortedMap.put(A[n], n);
        
        // start from 2nd last element
        for(int i = n - 1; i >= 0; i--){
        	// Ceiling entry will get anything bigger or equal to a number
            Map.Entry high = sortedMap.ceilingEntry(A[i]);
            
            // Floor entry will get anything smaller or equal to a number
            Map.Entry low = sortedMap.floorEntry(A[i]);
            
            // Always check odd first
            if(high != null){
                oddHigher[i] = evenLower[(int) high.getValue()];
            }
            
            // Then check even after
            if(low != null){
                evenLower[i] = oddHigher[(int) low.getValue()];
            }
            
            // Check if current element could do an odd jump
            if(oddHigher[i]){
            	// Increase the number of element could start to do even odd jump
                result++;
            }
            
            // save the input
            sortedMap.put(A[i], i);
        }
        
        return result;
    }
}
