// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {

//         int n = position.length;
//         double[] distance = new double[n];
//         double[] time = new double[n];

//         for(int i=0; i<n; i++){
//             distance[i] = target - position[i];
//             time[i] = distance[i] / speed[i];
//         } 

//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {

//                 if (position[i] < position[j]) {

//                     int tempPos = position[i];
//                     position[i] = position[j];
//                     position[j] = tempPos;

//                     double tempTime = time[i];
//                     time[i] = time[j];
//                     time[j] = tempTime;
//                 }
//             }
//         }

//         int fleets = 0;
//         double maxTime = 0;

//         for(int i = n-1; i>=0; i--){
//             if (time[i] > maxTime) {
//                 fleets++;
//                 maxTime = time[i];
//             }
//         }

//         return fleets;
//     }
// }




class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        double[] time = new double[n];

        // Calculate time
        for (int i = 0; i < n; i++) {
            time[i] = (double)(target - position[i]) / speed[i];
        }

        // Sort positions and keep time connected to each position
        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> position[b] - position[a]);

        int fleets = 0;
        double maxTime = 0;

        for (int i : index) {

            if (time[i] > maxTime) {
                fleets++;
                maxTime = time[i];
            }
        }

        return fleets;
    }
}