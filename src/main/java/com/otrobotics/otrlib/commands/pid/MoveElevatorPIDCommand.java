package com.otrobotics.otrlib.commands.pid;

import com.otrobotics.otrlib.commands.OTRCommand;
import com.otrobotics.otrlib.systems.manipulator.elevator.NStageElevator;;

public class MoveElevatorPIDCommand extends OTRCommand {

    // Each index element at can_ids corresponds to their counterpart in setpoints (i.e., can_ids[i] -> setpoints[i])
    public MoveElevatorPIDCommand (NStageElevator elevator, int[] can_ids, double[] setpoints) {
        super(elevator, can_ids, setpoints);
    }

    // If the angle of every required arm segment is at their respective setpoint
    public boolean isFinished () {
        
        for (int i=0; i<can_ids.length; i++) {
            if (((NStageElevator)subsystem).getStageHeight(can_ids[i]) == setpoints[i]) {
                return true;
            }
        }

        return true;
    }

}