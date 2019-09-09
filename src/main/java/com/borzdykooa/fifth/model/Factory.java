package com.borzdykooa.fifth.model;

import com.borzdykooa.fifth.util.RandomUtil;
import com.borzdykooa.general.ApplicationException;

import java.util.List;

import static com.borzdykooa.fifth.util.ConstantUtil.MAX_NUMBER_OF_DETAILS_PER_NIGHT;
import static com.borzdykooa.fifth.util.ConstantUtil.NIGHT_DURATION;

public class Factory extends Thread {

    private final List<RobotPart> dump;
    private volatile int count = 100;

    public Factory(List<RobotPart> dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        while (count > 0) {
            synchronized (dump) {
                int numberOfProducedDetails = RandomUtil.getRandom().nextInt(MAX_NUMBER_OF_DETAILS_PER_NIGHT) + 1;
                for (int i = 0; i < numberOfProducedDetails; i++) {
                    RobotPart robotPart = RobotPart.values()[RandomUtil.getRandom().nextInt(RobotPart.values().length)];
                    dump.add(robotPart);
                    System.out.println("Factory added " + robotPart);
                }
                count--;
            }
            try {
                Thread.sleep(NIGHT_DURATION);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new ApplicationException("InterruptedException occurred in run::Factory");
            }
        }
    }
}
