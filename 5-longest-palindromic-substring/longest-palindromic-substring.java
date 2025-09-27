class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();
        if(s.length() == 0 || s == null) return "";

        int bl = 1;
        int bs = 0;

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < n; j++){

                int left = i;
                int right = j;
                boolean pal = true;

                while(left < right){
                    if(s.charAt(left) != s.charAt(right)){
                        pal = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if(pal){
                    int len = j - i + 1;
                    if(len > bl){
                        bl = len;
                        bs = i;
                    }
                }

            }
        }
        return s.substring(bs, bs + bl);
    }
}