package com.otrobotics.otrlib.systems.manipulator;

import java.util.List;

public abstract class OTRManipulator {

    protected List<Integer> can_ids;
    protected ManipulatorController controller_type;

    protected ManipulatorPIDController PID_controller;

    public OTRManipulator (List<Integer> can_ids) {
        this.can_ids = can_ids;
    }

    protected abstract void init();
    protected abstract ManipulatorController getManipulatorControllerType();

    protected abstract void setPIDSetpoint(int can_device, double setpoint);

    protected void setPIDController (double kP, double kI, double kD, double kF) {
        PID_controller = new ManipulatorPIDController(kP, kI, kD, kF);
    }

    protected ManipulatorPIDController getPID_Values () {
        return PID_controller;
    }

}