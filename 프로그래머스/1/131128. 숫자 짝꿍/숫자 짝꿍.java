import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        
        for (char num : X.toCharArray()) {
            arr1[num - '0']++;
        }
        
        for (char num : Y.toCharArray()) {
            arr2[num - '0']++;
        }
    
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i > 0; i--) {
            if (arr1[i] > 0 && arr2[i] > 0) {
                for (int j = 0; j < Math.min(arr1[i], arr2[i]); j++) {
                    sb.append(i);
                }
            }
        }
        
        // 0 처리
        if (arr1[0] > 0 && arr2[0] > 0) {
            if (sb.toString().equals("")) sb.append(0);
            else {
                for (int i = 0; i < Math.min(arr1[0], arr2[0]); i++) {
                    sb.append(0);
                } 
            }
        }
        
        String result = sb.toString();
        if (sb.toString().equals("")) return "-1";
        
        return sb.toString();
    }
}