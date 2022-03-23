class Solution {
    public int brokenCalc(int X, int Y) {
        if(X >= Y) {
            return X-Y;
        }
        else if( Y % 2 == 0) {
            return 1 + brokenCalc(X, Y/2);
        } else {
            return 1 + brokenCalc(X, Y+1);
        }
    }
}