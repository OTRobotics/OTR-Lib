package com.otrobotics.otrlib.systems.manipulator.arm;

import java.util.List;

import com.otrobotics.otrlib.systems.manipulator.ManipulatorController;
import com.otrobotics.otrlib.systems.manipulator.OTRManipulator;

public class NSegmentArm extends OTRManipulator {

    public NSegmentArm (List<Integer> can_ids, double kP, double kI, double kD, double kF) {
        super(can_ids);
        setPIDController(kP, kI, kD, kF);
    }

    public void init () {

    }

    public ManipulatorController getManipulatorControllerType () {
        return ManipulatorController.SRX;
    }

    public void setPIDSetpoint (int can_device, double setpoint) {
        
    }

}
