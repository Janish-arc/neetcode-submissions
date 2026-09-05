class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int left = 0;
        int right = 0;

        int[] result = new int[nums.length - k + 1];
        int index = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        while (right < nums.length) {

            // Remove elements smaller than current element
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(right);

            // Window size = k
            if (right - left + 1 == k) {

                // Remove elements that are outside the window
                while (deque.peekFirst() < left) {
                    deque.pollFirst();
                }

                // Front always contains index of maximum element
                result[index] = nums[deque.peekFirst()];
                index++;

                left++;
            }

            right++;
        }

        return result;
    }
}