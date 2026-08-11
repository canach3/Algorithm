import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int[] arr = new int[10];
        for (int num : numbers) {
            arr[num]++;
        }
        
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            if (arr[i] == 0) sum += i;
        }
        
        return sum;
    }
}