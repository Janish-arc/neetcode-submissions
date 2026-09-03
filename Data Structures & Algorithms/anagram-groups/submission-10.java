class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String, List<String>> value = new HashMap <> (); 

        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);
            if(!value.containsKey(key)){
                value.put(key, new ArrayList<>());
            }

            value.get(key).add(str);
        }
        return new ArrayList<>(value.values());
    }
}
