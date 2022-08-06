package fx;

import island.Island;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(12);
    public static void main(String[] args) {
        Island island = new Island();
        island.fillIsland(island.getIslandArray());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(island);
        island.getIslandArray()[0][0].start();
        try {
            island.getIslandArray()[0][0].join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(island);


//        scheduledPool.scheduleAtFixedRate(() -> System.out.println(island),0,5000, TimeUnit.MILLISECONDS);
//        scheduledPool.scheduleAtFixedRate(()-> {System.out.println("ssssss");
//            System.out.println("asdsadasdasdasd");
//            System.out.println("asdasdsadsadassad");
//        },100,1000,TimeUnit.MILLISECONDS);

//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        scheduledPool.shutdown();


//        Cow cow = new Cow(1,Double.valueOf(1));
//        System.out.println(cow);

    }
}
