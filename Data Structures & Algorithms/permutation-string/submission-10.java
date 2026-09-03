class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        char [] c1 = s1.toCharArray();
        Arrays.sort(c1);

        String string1 = new String(c1);

        int left = 0;
        int right = 0;

        StringBuilder sb = new StringBuilder();

        while (right < s2.length()){
            sb.append(s2.charAt(right));
                if(right - left + 1 == string1.length()){
                    char[] sub = sb.toString().toCharArray();
                    Arrays.sort(sub);

                    String string2 = new String(sub);
                    if(string1.equals(string2)){
                        return true;
                    }
                 
                    sb.deleteCharAt(0);
                    left++;
                }
                right++;
            }
            return false;
        } 
    }

