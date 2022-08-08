package fx;

import creature.herbivorous.Boar;
import island.Island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Runner {
    public static ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(12);


    public static void main(String[] args) {
        Island island = new Island();
        island.fillIsland(island.getIslandArray());
        System.out.println(island);




        scheduledPool.scheduleAtFixedRate(()->{
            //запускаємо нитки усіх комірок
            for (int i = 0; i < island.getIslandArray().length; i++) {
                for (int j = 0; j < island.getIslandArray()[i].length; j++) {

 //                   island.getIslandArray()[i][j].start();
                    scheduledPool.scheduleAtFixedRate(island.getIslandArray()[i][j],0,5,TimeUnit.SECONDS);

                    try {
                        island.getIslandArray()[i][j].join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            //чекаємо 3 секнди і запускаємо метод переміщення тварин
//            for (int i = 0; i < island.getIslandArray().length; i++) {
//                for (int j = 0; j < island.getIslandArray()[i].length; j++) {
//                    island.moveAnimal(island.getIslandArray()[i][j],i,j);
//                }
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(island);

        }, 0 ,7 , TimeUnit.SECONDS);



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

    }
}
