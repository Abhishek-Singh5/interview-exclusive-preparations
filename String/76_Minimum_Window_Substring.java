class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();

        if(t.length() > n){
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int currentlength = t.length();

        int i = 0;
        int j = 0;

        int minWindowsSize = Integer.MAX_VALUE;
        int start = 0;

        while(j < n){
            char ch = s.charAt(j);

            if(map.containsKey(ch) && map.get(ch) > 0){
                currentlength--;
            }

            map.put(ch, map.getOrDefault(ch, 0) -1);

            while(currentlength == 0){

                int currentWindowsSize = j - i + 1;

                if(minWindowsSize > currentWindowsSize){
                    minWindowsSize = currentWindowsSize;
                    start = i;
                }

                char startchar = s.charAt(i);

                map.put(startchar, map.getOrDefault(startchar, 0) + 1);

                if(map.containsKey(startchar) && map.get(startchar) > 0){
                    currentlength++;
                }

                i++;
            }

            j++;
        }

        return minWindowsSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindowsSize);
    }
}
