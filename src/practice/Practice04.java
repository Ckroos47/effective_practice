package practice;

/**
 * @description: 使用私有构造方法执行非实例化
 * 主要用在工具类，不用实例化，工具类就可以向调用者提供服务
 * 实例化的过程其实本质是向内存中申请一个空间，我们对于不用实例化的类，
 * 避免它使用编译器默认的实例方法，这样节约了内存，也避免了非实例化类的默认构造函数不稳定性。
 * 不过这种写法，也有一种缺点，让调用者查看时，会感觉构造器就是设计成不能调用的一样，因此添加一句注释，会是一种明智的选择。
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/11/30 9:56 上午
 */
public class Practice04 {
}

class UtilityUtils{
    //此类无需实例化
    private UtilityUtils(){
        throw new AssertionError();
    }
}