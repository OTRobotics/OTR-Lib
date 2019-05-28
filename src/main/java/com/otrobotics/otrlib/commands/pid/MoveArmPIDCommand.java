package com.otrobotics.otrlib.commands.pid;

import com.otrobotics.otrlib.systems.manipulator.arm.NSegmentArm;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArmPIDCommand extends Command {

    private NSegmentArm arm;
    private int[] can_ids;
    private double[] setpoints;

    // Each index element at can_ids corresponds to their counterpart in setpoints (i.e., can_ids[i] -> setpoints[i])
    public MoveArmPIDCommand (NSegmentArm arm, int[] can_ids, double[] setpoints) {
        this.arm = arm;
        this.can_ids = can_ids;
        this.setpoints = setpoints;
    }

    // Overrided initialize method
    protected void initialize () {
        for (int i=0; i<can_ids.length; i++) {
            arm.setPIDSetpoint(can_ids[i], setpoints[i]);
        }
    }

    // If the angle of every required arm segment is at their respective setpoint
    public boolean isFinished () {
        
        for (int i=0; i<can_ids.length; i++) {
            if (arm.getAngleAtSegment(can_ids[i]) == setpoints[i]) {

            }
        }

        return true;
    }

}