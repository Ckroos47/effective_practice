package practice;

import java.sql.Date;

/**
 * @description: 使用静态工厂方法替代构造方法
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/11/22 11:28 AM
 */
public class Practice1 {
    public static void main(String[] args) {
        System.out.println(Demo.toStr(100L));
    }

}

class Demo {
    private Long transTime;

    public Demo(Long l){
        transTime = l;
    }

    public static String toStr(Long l){
        return l+"";
    }
}

