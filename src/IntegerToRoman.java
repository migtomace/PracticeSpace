import java.util.HashMap;

public class IntegerToRoman {

    //Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

    public String intToRoman(int num) {
        String string = "";

        HashMap<Integer, String> roman = new HashMap<>();
        roman.put(1,"I");
        roman.put(5,"V");
        roman.put(10,"X");
        roman.put(50,"L");
        roman.put(100,"C");
        roman.put(500,"D");
        roman.put(1000,"M");
        roman.put(4,"IV");
        roman.put(9,"IX");
        roman.put(40,"XL");
        roman.put(90,"XC");
        roman.put(400,"CD");
        roman.put(900,"CM");


        String length = num+"";
        int[] arr = new int[length.length()];
        int e = 0;
        int c = length.length() -1;
        int x;
        int y;
        while(num>0){
            x = num%10;
            y = x * (int) Math.pow(10, e);
            arr[c] = y;
            num = num/10;
            c--;
            e++;
        }

        e = length.length() - 1;
        for(int i = 0; i < arr.length; i++){
            y = arr[i];
            if(roman.get(y) != null){
                string += roman.get(y);
            } else {
                if (y / (int) Math.pow(10, e) > 5){
                    int rem = 5 * (int) Math.pow(10, e);
                    string += roman.get(rem);
                    y = y - rem;
                }
                int m = y / (int) Math.pow(10, e);
                for(int j = 0; j < m; j++){
                    string += roman.get((int)Math.pow(10, e));
                }
            }
            e--;

        }

        return string;
    }
}
