import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CommonPrefix {

    public static void main(String[] args){

        String[] strs = {"can", "can"};

        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length < 0){
            return result;
        } else if(strs.length == 1){
            return strs[0];
        }

        return longestCommonPrefix(strs, 0, result);

    }

    public static String longestCommonPrefix(String[] strs, int index, String result){
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        String s = "";

        for(int i = 0; i < strs.length; i++){
            //set string at index i of strs array to a variable
            String string = strs[i];
            //break string up into char array
            char[] ca = string.toCharArray();
            //only if the word is long enough
            if(index < ca.length){
                char key = ca[index];
                //add char as key or update value of occurrences in map
                if(map.containsKey(key)) {
                    int value = map.get(key) + 1;
                    map.replace(key, value);
                    if(value > max){
                        //updates max and value
                        max = value;
                        s = key + "";
                    }
                } else {
                    int value = 1;
                    map.put(key, value);
                    if(value > max){
                        max = value;
                        s = key + "";
                    }
                }
            }

        }



        if(max == strs.length && strs.length > 0){

            result += s;
//            System.out.println(result);
            index++;
            return longestCommonPrefix(strs, index, result);
        }


        return result;
    }
}
