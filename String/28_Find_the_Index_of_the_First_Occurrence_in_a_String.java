class Solution {

    public boolean match(String s, String w, int index){

        int j = 0;

        while(index < s.length() && j < w.length()){

            if(s.charAt(index) != w.charAt(j)){
                return false;

            }

            index++;
            j++;
        }

        return j == w.length();
    }

    public int strStr(String s, String w) {
        
        int n = s.length();
        int m = s.length();


        for(int i = 0; i < n; i++){

            if(match(s, w, i) == true){
                return i;
            }
        }

        return -1;
    }
}
