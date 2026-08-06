class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length, cnt5=0, cnt10=0, cnt20=0;
        for (int i : bills) {
            if (i==5) cnt5++;
            else if (i==10) {
                cnt10++; 
                if (cnt5>=1) cnt5--;
                else return false;
            }
            else if (i==20) {
                cnt20++;
                if (cnt5>=1 && cnt10>=1) {
                    cnt5--;
                    cnt10--;
                }
                else if (cnt5>=3) {
                    cnt5=cnt5-3;
                }
                else return false;
            }
        }
        return true;
    }
}