import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses {

    //Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    //Open brackets must be closed by the same type of brackets.
    //Open brackets must be closed in the correct order.

    public boolean isValid(String s) {

        //create a map that links open and end brackets
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        //create a linkedlist or stack to store closed brackets
        LinkedList<Character> ll = new LinkedList<>();

        //iterate through string
        //if map contains the key then add value to list/stack
        //else
        //if list/stack is empty return false
        //else if last one added to list/stack equals the current character, remove character from list/stack
        //else return false
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                ll.addLast(map.get(c));
            } else {
                if(ll.isEmpty()){
                    return false;
                } else if(ll.getLast() == c){
                    ll.removeLast();
                } else {
                    return false;
                }
            }

        }



        return ll.isEmpty();
    }
}
