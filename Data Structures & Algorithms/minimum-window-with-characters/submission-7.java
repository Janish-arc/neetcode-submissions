// class Solution {
//     public String minWindow(String s, String t) {
//         int left = 0;
//         int right = 0;
//         int min = Integer.MAX_VALUE;
//         String result = "";
//         StringBuilder sb = new StringBuilder();

//         int count[] = new int[128];

//         for(char c: t.toCharArray()){
//             count[c]++;
//         }

//         int length = t.length();

//         while (right < s.length()) {

//             char c = s.charAt(right);
//             sb.append(c);

//             if (count[c] > 0) {
//                 length--;
//             }

//             count[c]--;

//             while (length == 0) {

//                 if (right - left + 1 < min) {
//                     min = right - left + 1;
//                     result = sb.toString();
//                 }

//                 char leftChar = s.charAt(left);

//                 sb.deleteCharAt(0);

//                 count[leftChar]++;

//                 if (count[leftChar] > 0) {
//                     length++;
//                 }

//                 left++;
//             }

//             right++;
//         }
//         return result;
//     }
// }





class Solution {
    public String minWindow(String s, String t) {

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        String result = "";

        StringBuilder sb = new StringBuilder();

        int[] count = new int[128];

        // Store frequency of t
        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int required = t.length();

        while (right < s.length()) {

            char c = s.charAt(right);
            sb.append(c);

            if (count[c] > 0) {
                required--;
            }

            count[c]--;

            // Current window is valid
            while (required == 0) {

                // Check minimum
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = sb.toString();
                }

                // Remove left character
                char leftChar = s.charAt(left);

                sb.deleteCharAt(0);

                count[leftChar]++;

                if (count[leftChar] > 0) {
                    required++;
                }

                left++;
            }

            right++;
        }

        return result;
    }
}