package List;
import java.util.*;
import java.util.ListIterator;

public class LinkedListUse {

    public static void main(String[] args){
        LinkedList<Integer> l = new LinkedList<Integer>();
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l1.add(3);
        l1.add(5);
        l1.add(7);
        l2.add(5);
        l2.add(2);
        l2.add(1);
        //l2.add(3);

        int s = l2.size()>l1.size()?l1.size():l2.size();
        for(int i = 0;i< s;i++)
        {
            l.add(l1.get(i)+l2.get(i));
        }
        if(l1.size()>s)
        {
            for(int i = s ;i<l1.size();i++)
            {
                l.add(l1.get(i));
            }
        }
        if(l2.size()>s)
        {
            for(int i= s ;i <l2.size();i++)
            {
                l.add(l2.get(i));
            }
        }
        for(int i = 0;i<l.size();i++)
        {
            if(l.get(i)>=10)
            {
                int a = l.get(i)%10;
                int b = l.get(i)/10;
                l.set(i,a);
                if(i+1<l.size())
                {
                    l.set(i+1,l.get(i+1)+b);
                }
                else
                {
                    l.add(l.get(i)/10);
                }

            }
        }

        //3,链表支持双向遍历
        ListIterator<Integer> listiterator = l.listIterator();//获得列表迭代器，扩展了Iterator接口
        System.out.println("linkedlist向后遍历的结果：");
        while(listiterator.hasNext()){//向后遍历
            System.out.print(listiterator.next()+", ");
        }
        System.out.println();
        System.out.println("linkedlist向前遍历的结果：");
        while(listiterator.hasPrevious()){//向前遍历，即倒序遍历
            System.out.print(listiterator.previous()+", ");
        }

    }
}
