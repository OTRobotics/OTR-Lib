package com.otrobotics.otrlib.systems.manipulator;

import com.otrobotics.otrlib.systems.manipulator.ManipulatorPIDController;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorController;

import com.otrobotics.otrlib.controllers.OTRMotorController;
import com.otrobotics.otrlib.controllers.OTRTalonSRX;

public class ManipulatorPIDObject {

    public int can_id;
    public OTRMotorController motor_controller;
    public ManipulatorPIDController PID_controller;

    public ManipulatorPIDObject (int can_id, ManipulatorPIDController PID_controller,
                                 ManipulatorController manip_controller) {
        this.can_id = can_id;
        this.PID_controller = PID_controller;

        switch (manip_controller) {
            case SRX:
                motor_controller = new OTRTalonSRX(can_id);
                break;
        }

    }

    public int getDeviceID () {
        return can_id;
    }

    public ManipulatorPIDController getPIDController () {
        return PID_controller;
    }

    public void setPIDSetpoint (double setpoint) {
        // TODO: ADD CONTROL MODE SETPOINT METHODS IN OTR TALONSRX
    }

}