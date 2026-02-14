public class MaxChunkToMakeArraySorted {
    // Leetcode 769: https://leetcode.com/problems/max-chunks-to-make-sorted/

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 4};
        System.out.println(maxChunksToSorted(nums));
    }

    public static int maxChunksToSorted(int[] arr) {
        int max = Integer.MIN_VALUE;
        int count  = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(arr[i], max);
            if(max == i){
                count++;
            }
        }

        return count;
    }
}
