package practice;

import java.util.regex.Pattern;

/**
 * @description: 避免创建不必要的对象
 * 未能在需要的情况下防御性复制会导致潜在的错误和安全漏洞;而不必要地创建对象只会影响程序的风格和性能。
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/12/1 10:51 上午
 */
public class Practice06 {
}

class Demo01{
    String s = new String("bikini");//don't do this!
    String s2 = "bikini";//just do it
}

//don't do this
class Demo02{
    static boolean isRomanNumeral(String s){
        //String.matches内部创建了一个pattern实例，并且只使用一次
        //pattern实例需要将正则表达式编译成有限状态机
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})");
    }
}

//just do it
class RomanNumerals{
    //显式编译为不可变，缓存他
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})");

    static boolean isRomanNumeral(String s){
        return ROMAN.matcher(s).matches();
    }
}

//有的时候自动装箱会创建出不必要的对象
//优先使用基本类型而不是装箱的基本类型，也要注意无意识的自动装箱
class Demo03{
    private static long sum(){
        //应该声明为long
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE;i++)
            sum += i;
        return sum;
    }
}