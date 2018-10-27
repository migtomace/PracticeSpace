import java.util.HashMap;

public class RomanToInteger {

    //Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

    public int romanToInt(String s) {

        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        char[] ca = s.toCharArray();
        int num = 0;
        int last = 0;
        int curr = 0;
        for(int i = 0; i < ca.length; i++){
            curr = roman.get(ca[i]);
            if(last < curr){
                num -= last;
                num += (curr-last);
            } else {
                num += curr;
            }

            last = curr;
        }


        return num;
    }
}
