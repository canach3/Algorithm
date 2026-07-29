import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int maxM = Integer.parseInt(video_len.substring(0, 2));
        int maxS = Integer.parseInt(video_len.substring(3, 5));
        int startM = Integer.parseInt(pos.substring(0, 2));
        int startS = Integer.parseInt(pos.substring(3, 5));
        int opStartM = Integer.parseInt(op_start.substring(0, 2));
        int opStartS = Integer.parseInt(op_start.substring(3, 5));
        int opEndM = Integer.parseInt(op_end.substring(0, 2));
        int opEndS = Integer.parseInt(op_end.substring(3, 5));
        
        int m = startM;
        int s = startS;
        
        for (String command : commands) {
            if ((m > opStartM || (m == opStartM && s >= opStartS)) &&
                (m < opEndM || (m == opEndM && s < opEndS))) {
                m = opEndM;
                s = opEndS;
            }
            
            if (command.equals("prev")) {
                if ((s -= 10) < 0) {
                    m--;
                    s += 60;
                }
                
                if (m < 0) {
                    m = 0;
                    s = 0;
                }
            }
            
            else {
                if ((s += 10) >= 60) {
                    m++;
                    s -= 60;
                }
                
                if (m > maxM || (m == maxM && s > maxS)) {
                    m = maxM;
                    s = maxS;
                }
            }
        }
        
        if ((m > opStartM || (m == opStartM && s >= opStartS)) &&
                (m < opEndM || (m == opEndM && s < opEndS))) {
                m = opEndM;
                s = opEndS;
        }
        
        String mStr = m < 10 ? "0" + m : String.valueOf(m);
        String sStr = s < 10 ? "0" + s : String.valueOf(s);
        
        return mStr + ":" + sStr;
    }
}