class Solution {
    public int lengthOfLongestSubstring(String s) {

        int count = 0;

        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;

        char arr[] = s.toCharArray();
        int n = arr.length;

        while(j < n){
            int index = map.getOrDefault(arr[j], -1);

            if(index != -1 && index >= i){
                count = Math.max(count, j - 1 - i + 1);
                i = index + 1;
            }

            map.put(arr[j], j);
            j++;
        }

        return Math.max(count, j - 1 - i + 1);
        
    }
}
