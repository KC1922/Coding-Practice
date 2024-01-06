/*
 * Similar to the jump game, but this time we need to find the minimum number of jumps to reach the end of the array.
 * This code will implement two functions: dynamicJump and bfsJump.
 * dynamicJump is a dynamic programming approach that uses an iterative solution to find the minimum number of jumps.
 * bfsJump is a greedy algorithm approach that uses a breadth first search to find the minimum number of jumps.
 * Out of the three functions, bfsJump is the fastest with a time complexity of O(n) and a space complexity of O(1).
 * dynamicJump has a time complexity of O(n^2) and a space complexity of O(n).
 */

public class jump_game2 {
    public static void main (String[] args){
        int[] nums = {2,1,1,1,4};
        int dynamic = dynamicJump(nums);
        int bfs = bfsJump(nums);
        System.out.println("Dynamic: " + dynamic + "\nGreedy BFS: " + bfs);
    }

    public static int dynamicJump(int[] nums){
        int jumps = 0;
        int[] totalJumps = new int[nums.length];
        //populate dp array with max values, except for the first index which is 0
        for (int i = 1; i < nums.length; i++){
            totalJumps[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] + j >= i){
                    totalJumps[i] = Math.min(totalJumps[i], totalJumps[j] + 1);
                }
            }
        }
        jumps = totalJumps[nums.length - 1];

        return jumps;
    }

    public static int bfsJump(int[] nums){
        int jumps = 0;
        int currentEnd = 0;
        int currentFarthest = 0;

        //starting from the first index, we check if we can reach the end of the array
        //if we can't reach the end of the array, we update the currentFarthest index to the max of the currentFarthest and the current index + the value at the current index
        //if we reach the currentEnd index, we update the currentEnd index to the currentFarthest index and increment the number of jumps
        for (int i = 0; i < nums.length - 1; i++){
            currentFarthest = Math.max(currentFarthest, nums[i] + i);
            if (i == currentEnd){
                jumps++;
                currentEnd = currentFarthest;
            }
        }
        return jumps;
    }
}

