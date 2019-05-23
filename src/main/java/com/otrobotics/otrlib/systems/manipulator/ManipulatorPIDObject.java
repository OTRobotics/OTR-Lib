package com.otrobotics.otrlib.systems.manipulator;

import com.otrobotics.otrlib.systems.OTRPIDController;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorController;

import com.otrobotics.otrlib.sensors.OTRSensor;

import com.otrobotics.otrlib.controllers.OTRMotorController;
import com.otrobotics.otrlib.controllers.OTRTalonSRX;

public class ManipulatorPIDObject {

    public int can_id;
    public OTRSensor feedback_sensor;
    public OTRMotorController motor_controller;
    public OTRPIDController PID_controller;

    public ManipulatorPIDObject (int can_id, OTRPIDController PID_controller,
                                 OTRSensor feedback_sensor, ManipulatorController manip_controller) {
        this.can_id = can_id;
        this.feedback_sensor = feedback_sensor;
        this.PID_controller = PID_controller;

        switch (manip_controller) {
            case SRX:
                motor_controller = new OTRTalonSRX(can_id);
                if (feedback_sensor != null) {
                    motor_controller.configureFeedbackSensor(feedback_sensor);
                }
                motor_controller.configurePIDTerms(PID_controller.kP,
                                                   PID_controller.kI, 
                                                   PID_controller.kD, 
                                                   PID_controller.kF);
                break;
        }

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