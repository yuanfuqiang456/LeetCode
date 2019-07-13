package JSON;

import org.apache.commons.collections.ArrayStack;

import java.util.ArrayList;
import java.util.Collections;

public class Sort {

    ArrayList<Integer> sortList(ArrayList<Integer> list,String flag)
    {
        Collections.sort(list);
        if(flag.equals("ASC"))
            return list;
        else if(flag.equals("DESC"))
        {
            Collections.reverse(list);
            return list;
        }
        else
            return list;
    }
    void test()
    {
        ArrayList<Integer> testlist = new ArrayList<Integer>();
        testlist.add(0);
        testlist.add(4);
        testlist.add(2);
        testlist.add(6);
        System.out.println(sortList(testlist,"ASC"));
        System.out.println(sortList(testlist,"DESC"));
    }
}
