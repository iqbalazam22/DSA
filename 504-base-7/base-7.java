class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        if(num == 0) return "0";
        boolean isNeg = num < 0;
        num = Math.abs(num);
        while(num != 0){
            sb.append(num % 7);
            num /= 7;
        }
        if(isNeg) sb.append("-");
        sb.reverse();
        return sb.toString();
    }
}