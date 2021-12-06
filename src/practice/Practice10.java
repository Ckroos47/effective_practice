package practice;

import java.util.Objects;

/**
 * @description: 重写equals方法时遵守通用约定
 * 总结(高质量equals方法)：
 * 1。使用 == 运算符检查参数是否为该对象的引用。如果是，返回 true。这只是一种性能优化，但是如果这种比较可能很昂贵的话，那就值得去做。
 * 2。使用 instanceof 运算符来检查参数是否具有正确的类型。 如果不是，则返回 false。 通常，正确的类型是 equals 方法所在的那个类。
 * 有时候，改类实现了一些接口。 如果类实现了一个接口，该接口可以改进 equals 约 定以允许实现接口的类进行比较，那么使用接口。 集合接口
 * (如 Set，List，Map 和 Map.Entry)具有此特性。
 * 3。参数转换为正确的类型。因为转换操作在 instanceof 中已经处理过，所以它肯定会成功。
 * 4。对于类中的每个“重要”的属性，请检查该参数属性是否与该对象对应的属性相匹配。如果所有这些测试成功，返回 true，否则返回 false。
 * 如果步骤 2 中的类型是一个接口，那么必须通过接口方法访问参数的属性;如果类型是类，则可以直接访问属性，这取决于属性的访问权限。
 *
 * 注意：
 * 1. 当重写 equals 方法时，同时也要重写 hashCode 方法(条目 11)。
 * 2. 不要让 equals 方法试图太聪明。
 * 3. 在 equals 时方法声明中，不要将参数 Object 替换成其他类型。
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/12/3 1:53 下午
 */
public class Practice10 {

    public static void main(String[] args) {
        /**
         * ========== 满足以下任一条件，则说明做法是正确的  ============================
         *
         * 1。每个类的实例都是固有唯一的。 对于像 Thread 这样代表活动实体而不是值的类来说，这是正确的。
         * Object 提供 的 equals 实现对这些类完全是正确的行为。
         * 2。类不需要提供一个“逻辑相等(logical equality)”的测试功能。例如 java.util.regex.Pattern
         * 可以重写 equals 方法检查两个是否代表完全相同的正则表达式 Pattern 实例，但是设计者并不认为客
         * 户需要或希望使用此 功能。在这种情况下，从 Object 继承的 equals 实现是最合适的。
         * 3。父类已经重写了 equals 方法，则父类行为完全适合于该子类。例如，大多数 Set 从 AbstractSet
         * 继承了 equals 实 现、List 从 AbstractList 继承了 equals 实现，Map 从 AbstractMap 的 Map
         * 继承了 equals 实现。
         * 4。类是私有的或包级私有的，可以确定它的 equals 方法永远不会被调用。如果你非常厌恶风险，可以重写
         * equals 方法，以确保不会被意外调用
         *
         * =========================================================================
         */
        /**
         *  equals 方法实现了一个等价关系 (equivalence relation)。它有以下这些属性:============
         *
         *  1。自反性：对于任何非空引用 x， x.equals(x)必须返回 true。
         *  -------------//第一个要求只是说一个对象必须与自身相等
         *  2。对称性：对于任何非空引用 x 和 y，如果且仅当y.equals(x)返回true的时候，x.equals(y)必
         *  须返回true
         *  -------------//任何两个对象必须在是否相等的问题上达成一致
         *  3。传递性：对于任何非空引用 x、y、z，如果x.equals(y)返回true，y.equals(z)也返回true,则
         *  x.equals(z)也必须返回true
         *  -------------//如果第一个对象等于第二个对象，第二个对象等于第三 个对象，那么第一个对象必须
         *  等于第三个对象。
         *  4。一致性：对于任何非空引用 x 和 y，如果在 equals 比较中使用的信息没有修改，则x.equals(y)
         *  的多次调用必须始终返回true或始终返回false
         *  -------------//如果两个对象是相等的，除非一个(或两个)对象被修 改了， 那么它们必须始终保持相等
         *  5。对于任何非空引用 x，x.equals(null)必须返回false
         *  -------------//意思是说说 所有的对象都必须不等于 null
         *
         *  =============================================================================
         */
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s)); // true
        System.out.println(s.equals(cis)); // false
    }
}


final class CaseInsensitiveString{
    private final String s;
    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);//Checks that the specified object reference is not null
    }

    @Override
    public boolean equals(Object o) {
//        if (o instanceof CaseInsensitiveString)
//            return s.equalsIgnoreCase(
//                    ((CaseInsensitiveString) o).s);
//        if (o instanceof String)  // One-way interoperability!
//            return s.equalsIgnoreCase((String) o);
//        return false;
        //重构为
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
}
