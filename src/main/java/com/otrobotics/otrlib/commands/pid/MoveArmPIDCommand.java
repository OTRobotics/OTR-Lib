package com.otrobotics.otrlib.commands.pid;

import com.otrobotics.otrlib.commands.OTRCommand;
import com.otrobotics.otrlib.systems.manipulator.arm.NSegmentArm;

public class MoveArmPIDCommand extends OTRCommand {

    // Each index element at can_ids corresponds to their counterpart in setpoints (i.e., can_ids[i] -> setpoints[i])
    public MoveArmPIDCommand (NSegmentArm arm, int[] can_ids, double[] setpoints) {
        super(arm, can_ids, setpoints);
    }

    // If the angle of every required arm segment is at their respective setpoint
    public boolean isFinished () {
        
        for (int i=0; i<can_ids.length; i++) {
            if (((NSegmentArm)subsystem).getAngleAtSegment(can_ids[i]) == setpoints[i]) {
                return true;
            }
        }

        return true;
    }

}