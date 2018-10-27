import java.math.BigInteger;

public class reverseInt {


    public static void main(String [] args){

        System.out.println(reverse(1234236469));
    }



    public static int reverse(int x){

        Boolean bool = false;
        if (x < 0){
            bool = true;
            x = Math.abs(x);
        }
        int y;
        String s = x + "";
        char[] toCharA = s.toCharArray();
        s = "";

        for (int i = toCharA.length - 1; i >= 0; i--){
            s += toCharA[i];
        }

        try {
            y = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            // The format was incorrect
            return 0;
        }

        int max = (int) Math.pow(2, 31) - 1;
        int min = (int) Math.pow(2, 21) * (-1);


        if (bool){
            y *= -1;
        }

        if (y < min || y > max){
            return 0;
        }

        return y;
    }


}
