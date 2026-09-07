class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] a = new int [n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int ans = stack.pop();
                a[ans] = i - ans;
            }
            stack.push(i);
        }
        return a;
    }
}
