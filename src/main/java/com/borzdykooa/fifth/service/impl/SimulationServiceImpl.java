package com.borzdykooa.fifth.service.impl;

import com.borzdykooa.fifth.model.RobotPart;
import com.borzdykooa.fifth.model.Servant;
import com.borzdykooa.fifth.service.SimulationService;
import com.borzdykooa.fifth.util.RandomUtil;
import com.borzdykooa.general.ApplicationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import static com.borzdykooa.fifth.util.ConstantUtil.INIT_NUMBER_OF_DETAILS;

public class SimulationServiceImpl implements SimulationService {

    @Override
    public List<RobotPart> prepareDump() {
        final List<RobotPart> dump = new ArrayList<>();
        for (int i = 0; i < INIT_NUMBER_OF_DETAILS; i++) {
            dump.add(RobotPart.values()[RandomUtil.getRandom().nextInt(RobotPart.values().length)]);
        }

        return dump;
    }

    @Override
    public void startThreadsAndJoin(Thread... threads) {
        Arrays.stream(threads).forEach(Thread::start);
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ApplicationException("InterruptedException occurred in startThreadsAndJoin::SimulationServiceImpl");
        }
    }

    @Override
    public Long getTotalRobotNumber(Servant servant) {
        Map<RobotPart, Long> map = servant.getRobotParts().stream()
                .collect(Collectors.groupingBy(element -> element, Collectors.counting()));
        OptionalLong total = map.values().stream().mapToLong(Long::longValue).min();
        long result = 0;
        if (total.isPresent() && RobotPart.values().length == map.size()) {
            result = total.getAsLong();
        }

        return result;
    }
}
