class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();

        for(String str: strs){
            s.append(str.length()).append("#").append(str);
        }

        return s.toString();
    }

    public List<String> decode(String str) {
        List<String> s = new ArrayList<> ();
        
        int i=0;
        while (i < str.length()){
            int j = i;

            while(str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            String res = str.substring(j+1, j+1 + length);
            s.add(res);

            i = j+1+length;

        }

        return s;
    }
}
