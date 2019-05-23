package com.otrobotics.otrlib.systems.manipulator;

import com.otrobotics.otrlib.systems.OTRPIDObject;
import com.otrobotics.otrlib.systems.OTRPIDController;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorController;

import com.otrobotics.otrlib.sensors.OTRSensor;

import com.otrobotics.otrlib.controllers.OTRMotorController;
import com.otrobotics.otrlib.controllers.OTRTalonSRX;

public class ManipulatorPIDObject extends OTRPIDObject {

    public int can_id;
    public OTRSensor feedback_sensor;
    public OTRMotorController motor_controller;
    public OTRPIDController PID_controller;

    public ManipulatorPIDObject (int can_id, OTRPIDController PID_controller,
                                 OTRSensor feedback_sensor, ManipulatorController manip_controller) {
        super(can_id, PID_controller, feedback_sensor, manip_controller);

    }

    public int getDeviceID () {
        return can_id;
    }

    public OTRPIDController getPIDController () {
        return PID_controller;
    }

    public void setPIDSetpoint (double setpoint) {
        motor_controller.setPIDPosition(setpoint);
    }

}