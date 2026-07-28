class Solution {
    public int solution(int[] players, int m, int k) {
        int[] servers = new int[k + 2];
        int totalServer = 0;
        int result = 0;
        
        for (int i = 0; i < 24; i++) {
            // 서버 제거
            for(int j = 0; j <= k; j++) {
                servers[j] = servers[j + 1];
            }
            totalServer -= servers[0];
            
            // 서버 증설
            int plus = Math.max(0, players[i] / m - totalServer);
            
            servers[k] = plus;
            totalServer += plus;
            result += plus;
        }
        
        return result;        
    }
}