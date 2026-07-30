class Solution {
    public int solution(int[] diffs, int[] times, long limit) {   
        int left = 1;
        int right = 100000;
        int result = 0;
        
        while (left <= right) {
            long sum = times[0];
            int level = left + (right - left) / 2;  
            
            for (int i = 1; i < diffs.length; i++) {
                int q = Math.max(0, diffs[i] - level);
                
                sum += times[i] + (q * times[i]) + (q * times[i - 1]);
            }
            
            if (sum <= limit) {
                result = level;
                right = level  - 1;
            } else {
                left = level + 1;
            }
        }
        
        return result;
    }
}