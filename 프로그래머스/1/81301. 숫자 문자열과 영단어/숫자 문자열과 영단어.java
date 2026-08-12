import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            
            switch (c) {
                case 'z':
                    sb.append(0);
                    i += 4;
                    break;
                case 'o':
                    sb.append(1);
                    i += 3;
                    break;
                case 't':
                    if (s.charAt(i + 1) == 'w') {
                        sb.append(2);
                        i += 3;
                    } else {
                        sb.append(3);
                        i += 5;
                    }
                    break;
                case 'f':
                    if (s.charAt(i + 1) == 'o') {
                        sb.append(4);
                        i += 4;
                    } else {
                        sb.append(5);
                        i += 4;
                    }
                    break;
                case 's':
                    if (s.charAt(i + 1) == 'i') {
                        sb.append(6);
                        i += 3;
                    } else {
                        sb.append(7);
                        i += 5;
                    }
                    break;
                case 'e':
                    sb.append(8);
                    i += 5;
                    break;
                case 'n':
                    sb.append(9);
                    i += 4;
                    break;
                default:
                    sb.append(c);
                    i++;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}