package com.borzdykooa.fifth.service.impl;

import com.borzdykooa.fifth.model.Factory;
import com.borzdykooa.fifth.model.RobotPart;
import com.borzdykooa.fifth.model.Servant;
import com.borzdykooa.fifth.service.SimulationService;
import org.junit.Test;

import java.util.List;

public class SimulationServiceTest {

    private SimulationService simulationService = new SimulationServiceImpl();

    @Test
    public void testFactory() {
        final List<RobotPart> dump = simulationService.prepareDump();
        Factory factory = new Factory(dump);
        Servant firstServant = new Servant(dump);
        Servant secondServant = new Servant(dump);
        simulationService.startThreadsAndJoin(factory, firstServant, secondServant);
        Long firstServantNumber = simulationService.getTotalRobotNumber(firstServant);
        Long secondServantNumber = simulationService.getTotalRobotNumber(secondServant);
        System.out.println(firstServantNumber > secondServantNumber
                ? "First Servant with " + firstServantNumber + " robots wins!"
                : "Second Servant with " + secondServantNumber + " robots wins!");
    }
}
