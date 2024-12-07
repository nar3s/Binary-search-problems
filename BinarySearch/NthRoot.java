public class NthRoot {
    public static void main(String[] args) {
        System.out.println(NthRoot(9, 1953125));
    }
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int ans = -1;
        int low = 1;
        int high = m;
        int mid;
        while(high >= low){
            mid = (low)+(high - low)/2;
            int castResult = (int) Math.pow(mid, n); 
            if(castResult == m){
                return mid;
            }
            if (castResult < m) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}
