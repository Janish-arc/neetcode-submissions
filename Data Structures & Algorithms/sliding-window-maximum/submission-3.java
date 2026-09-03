// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int left = 0;
//         int right = 0;
//         int[] result = new int[nums.length - k + 1];
//         int index =0;

//         while (right < nums.length){
//             if(right - left + 1 == k){
//                 int max = Integer.MIN_VALUE;

//                 for(int i = left; i<=right; i++){
//                     max = Math.max(max, nums[i]);
//                 }

//                 result[index] = max;
//                 index++;

//                 left++;
//             }

//             right++;
//         }

//         return result;
//     }
// }




class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int left = 0;
        int right = 0;

        int[] result = new int[nums.length - k + 1];
        int index = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        while (right < nums.length) {

            // Add value and its index
            pq.add(new int[]{nums[right], right});

            if (right - left + 1 == k) {

                // Remove maximum elements that are outside the window
                while (pq.peek()[1] < left) {
                    pq.poll();
                }

                // Maximum is at the top
                result[index] = pq.peek()[0];
                index++;

                // Slide window
                left++;
            }

            right++;
        }

        return result;
    }
}