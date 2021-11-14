
import java.util.LinkedList;
import java.util.Objects;

public class LinkedStack implements IStackable {

     LinkedList<Integer> s1 = new LinkedList<Integer>();
       int size = 0;
       int v1;

       public void push(int v1){
             s1.add(v1);
             size++;
       }

       public int pop(){
            size--; 
            return s1.remove(0);
       }       

       public int size(){
            return size;
       }

}

