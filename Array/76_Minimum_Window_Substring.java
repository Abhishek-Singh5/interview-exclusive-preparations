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

        int requiredCount = t.length();

        int i = 0;
        int j = 0;

        int minWindowsSize = Integer.MAX_VALUE;
        int start = 0;

        while(j < n){
            char ch = s.charAt(j);

            if(map.containsKey(ch) &&  map.get(ch) > 0){
                requiredCount--;
            }

            map.put(ch, map.getOrDefault(ch, 0) -1);

            while(requiredCount == 0){
                // Start SHrinking Windows

                int currentWindowsSize = j - i + 1;

                if(minWindowsSize > currentWindowsSize){
                    minWindowsSize = currentWindowsSize;
                    start = i;
                }

                char startChar = s.charAt(i);
                map.put(startChar, map.getOrDefault(startChar, 0) + 1);

                if(map.containsKey(startChar) && map.get(startChar) > 0) {
                    requiredCount++;
                }

                i++;
            }

            j++;
        }

        return minWindowsSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindowsSize);
    }
}
