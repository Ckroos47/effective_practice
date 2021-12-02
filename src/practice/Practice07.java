package practice;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @description: 消除过期的对象引用
 * 清空对象引用只是一种例外，不是一种规范行为。
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/12/2 10:50 上午
 */

public class Practice07 {

    public static void main(String[] args) throws InterruptedException {
        //只要在缓存之外存在对某个项（entry）的键（key）引用，那么这项就是明确有关联的，就可以用WeakHashMap来表示缓存；
        //对于更复杂的缓存，可能直接需要使用java.lang.ref。
        //HashMap<Integer,String> codeCache = new HashMap<>();
        WeakHashMap<Integer,String> codeCache = new WeakHashMap<>();
        //为了测试，使用固定验证码
        String code = "000000";
        for (int i = 0;i < 10000000; i++){
            codeCache.put(i,code);
            Thread.sleep(1);
        }
    }
}

class Stack{

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }
    //一个单元弹出，指向这个单元的引用就过期了，需要清空引用
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
        //改进方式，指向null
//        Object result = elements[--size];
//        elements[size] = null;
//        return result;
}

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements,2 * size + 1);
    }


}
