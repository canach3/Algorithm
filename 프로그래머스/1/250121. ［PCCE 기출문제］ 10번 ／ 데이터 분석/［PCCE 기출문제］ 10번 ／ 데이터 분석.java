import java.util.*;

class Solution {
    public int[][] solution(int[][] datas, String ext, int val_ext, String sort_by) {
        final int sortIdx;
        switch (sort_by) {
            default:    
            case "code" : 
                sortIdx = 0;
                break;
            case "date" : 
                sortIdx = 1;    
                break;
            case "maximum" : 
                sortIdx = 2;
                break;
            case "remain" : 
                sortIdx = 3;
                break;
        }
        
        int checkIdx;
        switch (ext) {
            default:    
            case "code" : 
                checkIdx = 0;
                break;
            case "date" : 
                checkIdx = 1;    
                break;
            case "maximum" : 
                checkIdx = 2;
                break;
            case "remain" : 
                checkIdx = 3;
                break;
        }
        
        Arrays.sort(datas, (a, b) -> (a[sortIdx] - b[sortIdx]));
        
        int size = 0;
        for (int[] data : datas) {
            if (data[checkIdx] < val_ext) size++;
        }
        
        int[][] result = new int[size][4];
        int cnt = 0;
        
        for (int i = 0; i < datas.length; i++) {
            if (datas[i][checkIdx] < val_ext) {
                for (int j = 0; j < 4; j++) {
                    result[cnt][j] = datas[i][j];
                }   
                cnt++;
            }
        }
        
        return result;
    }
}