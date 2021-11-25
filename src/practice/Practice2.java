package practice;

/**
 * @description: 当构造方法参数过多时使用builder模式
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/11/22 4:18 PM
 */
public class Practice2 {

    public static void main(String[] args) {
        Animal animal = new Animal.Builder(210.1,221.2).name("lion").age(10).build();
    }
}

class Animal{

    private final double high;
    private final double weight;
    private final String name;
    private final int age;

    public static class Builder{
        private final double high;
        private final double weight;
        private String name = "lion";
        private int age = 13;

        public Builder(double high,double weight){
            this.high = high;
            this.weight = weigeefht;
        }

        public Builder name(String val){
            name = val;
            return this;
        }
        public Builder age(int val){
            age = val;
            return this;
        }
        public Animal build(){
            return new Animal(this);
        }
    }

    private Animal(Builder builder){
        high = builder.high;
        weight = builder.weight;
        name = builder.name;
        age = builder.age;
    }
}
