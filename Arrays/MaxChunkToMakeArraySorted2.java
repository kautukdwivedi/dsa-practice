public class MaxChunkToMakeArraySorted2 {

    // Leetcode 768: https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 4};
        System.out.println(maxChunksToSorted(nums));
    }

    public static int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int[] suffixMin = new int[len+1];
        suffixMin[len] = Integer.MAX_VALUE;
        int prefixMax = 0;
        int chunk = 0;

        for(int i = len-1; i >= 0; i--){
            suffixMin[i] = Math.min(suffixMin[i+1], arr[i]);
        }

        for(int i = 0; i < len-1; i++){
            prefixMax = Math.max(prefixMax, arr[i]);
            if(prefixMax <= suffixMin[i+1]){
                chunk++;
            }
        }

        return chunk + 1;
    }
}
