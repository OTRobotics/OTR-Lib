package com.otrobotics.otrlib.systems.velocity;

import com.otrobotics.otrlib.systems.OTRPIDObject;
import com.otrobotics.otrlib.systems.OTRController;
import com.otrobotics.otrlib.systems.OTRPIDController;

import com.otrobotics.otrlib.sensors.OTRSensor;

public class VelocityPIDObject extends OTRPIDObject {

    public VelocityPIDObject (int can_id, OTRPIDController PID_controller,
                                 OTRSensor feedback_sensor, OTRController manip_controller) {
        super(can_id, PID_controller, feedback_sensor, manip_controller);
    }

    public int getDeviceID () {
        return can_id;
    }

    public OTRPIDController getPIDController () {
        return PID_controller;
    }

    public void setPIDSetpoint (double setpoint) {
        motor_controller.setPIDVelocity(setpoint);
    }

}