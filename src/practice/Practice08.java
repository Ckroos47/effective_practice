package practice;

import java.lang.ref.Cleaner;

/**
 * @description: 避免使用Finalizer和Cleaner机制
 * 除了作为一个安全网或者终止非关键的本地资源，不要使用cleaner和finalizer。
 * 使用要当心不确定性和性能影响
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/12/2 3:44 下午
 */
public class Practice08 {

    public static void main(String[] args) {
        //Nice job
//        try (Room myRoom = new Room(7)){
//            System.out.println("GoodBye");
//        }
        //never clean
        new Room(99);
        System.out.println("Peace out");
    }

}

class Room implements AutoCloseable{

    private static final Cleaner cleaner = Cleaner.create();

    //Resources of Cleaner method.
    //非静态内部类包含对其宿主类的实例的引用，state不引用room是非常重要的，所以必须为静态的嵌内部类
    private static class State implements Runnable{
        int numJunkPiles;//Number of junk piles in this room
        State(int numJunkPiles){
            this.numJunkPiles = numJunkPiles;
        }
        //Invoked by close method or cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }
    //The state of this room,shared with our cleanable
    private final State state;
    //Our cleanable.Cleans the room when it's elegible for gc
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles){
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this,state);
    }

    @Override
    public void close() {
        cleanable.clean();
    }
}