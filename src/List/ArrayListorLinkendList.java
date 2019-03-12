package List;
import java.util.*;
//arraylist 和 linkedlist 逆序的问题 arrayList 比linkedlist 快

public class ArrayListorLinkendList {
    public static void main(String[] args) {
        int length = 1000000;
        List<Integer> list = new ArrayList<Integer>(length); // or new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Collections.reverse(list);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        List<Integer> list1 = new LinkedList<Integer>();
        for(int i = 0;i<length;i++)
        {
            list1.add(i);
        }
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Collections.reverse(list1);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
    }
}
/*

public static void reverse(List<?> list) {
        int size = list.size();
        if (size < REVERSE_THRESHOLD || list instanceof RandomAccess) {
            for (int i=0, mid=size>>1, j=size-1; i<mid; i++, j--)
                swap(list, i, j);
        } else {
            ListIterator fwd = list.listIterator();
            ListIterator rev = list.listIterator(size);
            for (int i=0, mid=list.size()>>1; i<mid; i++) {
        Object tmp = fwd.next();
                fwd.set(rev.previous());
                rev.set(tmp);
            }
        }
    }
if (size < REVERSE_THRESHOLD || list instanceof RandomAccess)
是数组实现或集合长度小于16时，第一个和最后一个交换，第二个和倒数第二个交换，以些类推。。。。　
RandomAccess：随机访问接口，数组的实现才支持随机访问。而链表的实现LinkedList是不支持此接口的。
链表的get(i)必须从头指针开始，移动i-1次到指定的位置，当然链表里元素个数较大的时候，不停的移动增加了复杂度。所以采用

            ListIterator fwd = list.listIterator();
            ListIterator rev = list.listIterator(size);
            for (int i=0, mid=list.size()>>1; i<mid; i++) {
                Object tmp = fwd.next();
                fwd.set(rev.previous());
                rev.set(tmp);
                }
前移后移来实现，是为了降低移动指针的复杂度。

swap(list, i, j);是交换两个元素的引用
fwd.set(rev.previous()); rev.set(tmp);也是交换的元素的引用。

所以说数组交换的是值，链表交换的是引用的说法是不正确的。
综合起来看数组reverse稍快些，但差别不太大，因为是同一个复杂度等级。

逆序涉及所有元素的遍历，在遍历元素上数组操作比链表的迭代操作快。
就算是数组需要进行元素交换，但是链表也需要进行链路的交换，这种交换在性能上基本上是一样的。
 */