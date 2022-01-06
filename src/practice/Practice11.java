package practice;

import lombok.Data;

/**
 * @description: 重写 equals 方法时同时也要重写 hashcode 方法
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/12/6 3:16 下午
 */
public class Practice11 {
    public static void main(String[] args) {
        /**
         * Object规范约定
         *
         * 1. 当在一个应用程序执行过程中，如果在 equals 方法比较中没有修改任何信息，
         * 在一个对象上重复调用 hashCode 方法时，它必须始终返回相同的值。从一个应用
         * 程序到另一个应用程序的每一次执行返回的值可以是不一致的。
         * 2. 如果两个对象根据 equals(Object) 方法比较是相等的，那么在两个对象上调
         * 用 hashCode 就必须产生的结果是相 同的整数。
         * 3. 如果两个对象根据 equals(Object) 方法比较并不相等，则不要求在每个对象
         * 上调用 hashCode 都必须产生不同的 结果。 但是，程序员应该意识到，为不相等
         * 的对象生成不同的结果可能会提高散列表(hash tables)的性能。
         */
    }
}

