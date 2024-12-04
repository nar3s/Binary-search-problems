
/* 
You are given an array containing n positive integers.
Your task is to divide the array into k subarrays so that the maximum sum in a subarray is as small as possible.
Input
The first input line contains two integers n and k: the size of the array and the number of subarrays in the division.
The next line contains n integers x1,x2,......,xn: the contents of the array.
Output
Print one integer: the maximum sum in a subarray in the optimal division.

Example
Input:
5 3
2 4 7 3 5

Output:
8

Explanation: An optimal division is [2,4],[7],[3,5] where the sums of the subarrays are 6,7,8. The largest sum is the last sum 8. 
*/

public class ArrayDivision {
    public static void main(String args[]){
        int arr[] = {1, 3 , 4, 6 ,5};
        int k = 1;
        System.out.println(splitArray(arr, k));
    }
    public static int splitArray(int[] nums, int k) {
        // Step 1: Determine the bounds for binary search
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num); // The maximum single element
            sum += num;              // The total sum of the array
        }
        
        // The range of binary search: [max, sum]
        int low = max, high = sum;
        
        // Step 2: Perform binary search
        while (low < high) {
            int mid = low + (high - low) / 2; // Middle value
            
            // Check if `mid` can be the maximum sum of subarrays
            if (canSplit(nums, k, mid)) {
                high = mid; // Try to minimize further
            } else {
                low = mid + 1; // Increase the allowable maximum sum
            }
        }
        
        return low; // The minimized maximum sum
    }
    
    // Helper function to check if we can split the array into `k` subarrays
    // such that each subarray sum is <= `maxSum`.
    private static boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0; // Sum of the current subarray
        int subarrays = 1;  // Start with one subarray
        
        for (int num : nums) {
            // If adding this number exceeds `maxSum`, start a new subarray
            if (currentSum + num > maxSum) {
                subarrays++;
                currentSum = num; // Start the new subarray with this number
                
                // If we exceed the allowed number of subarrays, return false
                if (subarrays > k) {
                    return false;
                }
            } else {
                currentSum += num; // Add the number to the current subarray
            }
        }
        
        return true; // Successfully split into <= k subarrays
    }
}
