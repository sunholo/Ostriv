package runner;

import island.Island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Runner {
    public static ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(30);


    public static void main(String[] args) {
        Island island = new Island();
        island.fillIsland(island.getIslandArray());
        System.out.println(island);

        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[0][0], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[0][1], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[0][2], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[0][3], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[0][4], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[1][0], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[1][1], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[1][2], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[1][3], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[1][4], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[2][0], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[2][1], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[2][2], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[2][3], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[2][4], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[3][0], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[3][1], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[3][2], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[3][3], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[3][4], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[4][0], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[4][1], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[4][2], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[4][3], 0, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(island.getIslandArray()[4][4], 0, 5, TimeUnit.SECONDS);

        scheduledPool.scheduleAtFixedRate(() -> {
            for (int i = 0; i < island.getIslandArray().length; i++) {
                for (int j = 0; j < island.getIslandArray()[i].length; j++) {
                    island.moveAnimal(island.getIslandArray()[i][j], i, j);
                }
            }
        }, 1, 5, TimeUnit.SECONDS);
        scheduledPool.scheduleAtFixedRate(() -> System.out.println(island), 2, 5, TimeUnit.SECONDS);

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scheduledPool.shutdown();

    }
}
