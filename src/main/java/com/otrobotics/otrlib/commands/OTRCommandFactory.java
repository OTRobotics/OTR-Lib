package com.otrobotics.otrlib.commands;

import com.otrobotics.otrlib.commands.OTRCommand;
import com.otrobotics.otrlib.systems.OTRSubsystem;
import com.otrobotics.otrlib.systems.manipulator.arm.NSegmentArm;
import com.otrobotics.otrlib.commands.pid.*;

public class OTRCommandFactory {

    public static OTRCommand buildPIDCommand (String subsystem_id, OTRSubsystem subsystem,
                                              int[] can_ids, double[] setpoints) {
        if (subsystem_id.equals("ARM")) {
                return new MoveArmPIDCommand((NSegmentArm)subsystem, can_ids, setpoints);
        }

        
        // Return empty stub
        return new OTRCommand(){
            protected boolean isFinished() {
                return false;
            }
        };
    }

}