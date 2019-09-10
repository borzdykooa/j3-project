package com.borzdykooa.fifth.model;

import com.borzdykooa.fifth.util.RandomUtil;
import com.borzdykooa.general.ApplicationException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.borzdykooa.fifth.util.ConstantUtil.MAX_NUMBER_OF_DETAILS_PER_NIGHT;
import static com.borzdykooa.fifth.util.ConstantUtil.NIGHT_DURATION;

@RequiredArgsConstructor
public class Servant extends Thread {

    private final List<RobotPart> dump;
    private List<RobotPart> robotParts = new ArrayList<>();
    private volatile int count = 100;

    public List<RobotPart> getRobotParts() {
        return robotParts;
    }

    @Override
    public void run() {
        while (count > 0) {
            synchronized (dump) {
                int numberOfDetails = RandomUtil.getRandom().nextInt(MAX_NUMBER_OF_DETAILS_PER_NIGHT) + 1;
                numberOfDetails = Math.min(numberOfDetails, dump.size());
                for (int i = 0; i < numberOfDetails; i++) {
                    RobotPart robotPart = dump.get(RandomUtil.getRandom().nextInt(dump.size()));
                    robotParts.add(robotPart);
                    System.out.println(Thread.currentThread().getName() + " Servant took " + robotPart);
                }
                count--;
            }
            try {
                Thread.sleep(NIGHT_DURATION);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new ApplicationException("InterruptedException occurred in run::Servant");
            }
        }
    }
}
