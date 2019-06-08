package com.otrobotics.otrlib.commands;

import com.otrobotics.otrlib.systems.OTRSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public abstract class OTRCommand extends Command {
    
    protected OTRSubsystem subsystem;
    protected int[] can_ids;
    protected double[] setpoints;

    // Blank constructor stub (SHOULD NEVER BE USED!!!)
    public OTRCommand () {}

    // Each index element at can_ids corresponds to their counterpart in setpoints (i.e., can_ids[i] -> setpoints[i])
    public OTRCommand (OTRSubsystem subsystem, int[] can_ids, double[] setpoints) {
        this.subsystem = subsystem;
        this.can_ids = can_ids;
        this.setpoints = setpoints;
    }

    // Overrided initialize method
    protected void initialize () {
        for (int i=0; i<can_ids.length; i++) {
            subsystem.setPIDSetpoint(can_ids[i], setpoints[i]);
        }
    }   


}