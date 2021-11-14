
import java.util.ArrayList;
import java.util.Objects;

public class ArrayStack implements IStackable {

       ArrayList<Integer> s2 = new ArrayList<Integer>();
       int size2 = 0;
       int v2;

       public void push(int v2){
             s2.add(v2);
             size2++;
       }

       public int pop(){
            size2--; 
            return s2.remove(s2.size()-1);
       }       

       public int size(){
            return size2;
       }

}

