import java.util.*;

class Solution {
    public int solution(int a, int b, int bottles) {
        int result = 0;
        
        while (bottles >= a) {
            int get = bottles / a * b;
            result += get;
            bottles = bottles % a + get;
        }
    
        return result;    
    }
}