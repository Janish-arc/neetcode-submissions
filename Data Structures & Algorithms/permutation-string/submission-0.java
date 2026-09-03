// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
        
//         char [] c1 = s1.toCharArray();
//         Arrays.sort(c1);

//         String string1 = new String(c1);

//         char[] c2 = s2.toCharArray();
//         Arrays.sort(c2);

//         String string2 = new String(c2);

//         int left = 0;
//         int right = 0;

//         StringBuilder sb = new StringBuilder();

//         while (right < string2.length()){
//             sb.append(string2.charAt(right)){
//                 if(right - left + 1 == string1.length){
//                     char[] sub = sb.toString().toCharArray();
//                     Arrays.sort(sub);
//                 }
//             }
//         } 
//     }
// }



class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Sort s1
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);

        String string1 = new String(c1);

        int left = 0;
        int right = 0;

        StringBuilder sb = new StringBuilder();

        while (right < s2.length()) {

            // Add current character to window
            sb.append(s2.charAt(right));

            // Window size should be same as s1
            if (right - left + 1 == s1.length()) {

                // Convert current window to char array
                char[] window = sb.toString().toCharArray();

                // Sort the window
                Arrays.sort(window);

                String string2 = new String(window);

                // Compare with sorted s1
                if (string1.equals(string2)) {
                    return true;
                }

                // Remove left character
                sb.deleteCharAt(0);

                left++;
            }

            right++;
        }

        return false;
    }
}