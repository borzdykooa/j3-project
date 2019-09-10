package com.borzdykooa.fifth.service;

import com.borzdykooa.fifth.model.RobotPart;
import com.borzdykooa.fifth.model.Servant;

import java.util.List;

public interface SimulationService {
    List<RobotPart> prepareDump();

    void startThreadsAndJoin(Thread... threads);

    Long getTotalRobotNumber(Servant servant);
}
