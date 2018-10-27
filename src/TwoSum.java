import java.util.Arrays;
import java.util.LinkedList;

public class TwoSum {

    public static void main(String[] args){
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(9);
        l1.add(9);
        l1.add(9);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(9);
        l2.add(9);
        l2.add(9);

        System.out.println(twoSum(l1, l2));
    }

    public static LinkedList<Integer> twoSum(LinkedList<Integer> l1,LinkedList<Integer> l2){

        long start = System.currentTimeMillis();
        Integer[] a1 = l1.toArray(new Integer[l1.size()]);
        Integer[] a2 = l2.toArray(new Integer[l2.size()]);

        int length;
        int rem = 0;

            if(a1.length >= a2.length){
            length = a1.length;
        } else {
            length = a2.length;
        }

        int[] a3 = new int[length+ 2];
            String string = "";

            for(int i = 0; i < length; i++){
                int num = a1[i] + a2[i];

                if(num > 9){
                    num = num + rem - 10;
                    string += num + "";
                    rem = 1;
                } else {
                    string += num + rem;
                }

            }

            if (rem > 0){
                string += rem;
            }


            char[] toCharacterArray = string.toCharArray();

        LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < string.length(); i++){
                String c = toCharacterArray[i] + "";
                list.add(Integer.parseInt(c));
            }

            long end = System.currentTimeMillis();

            System.out.println((end - start));

            return list;
    }
}
