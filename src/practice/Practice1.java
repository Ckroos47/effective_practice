package practice;

import java.sql.Date;

/**
 * @description: 使用静态工厂方法替代构造方法
 *  优点
 *  1. 它们是有名字的，可以通过名称来突出差异
 *  2. 不需要每次调用的时候都创建对象
 *  3. 可以返回其返回类型的任何子类型的对象
 *  4. 返回对象的类可以根据输入参数的不同而不同
 *  5. 在编写包含该方法的类时，返回的对象的类不需要存在
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/11/22 11:28 AM
 */
public class Practice1 {
    public static void main(String[] args) {
        System.out.println(Demo.toStr(100L));
        System.out.println(Demo.toStr(10));
    }

}

class Demo {
    private Long transTime;
    private Integer age;

    public Demo(Long l){
        transTime = l;
    }
    public Demo(Integer i){
        age = i;
    }

    public static String toStr(Long l){
        return l+"";
    }

    public static String toStr(Integer i){
        return i + "";
    }
}

