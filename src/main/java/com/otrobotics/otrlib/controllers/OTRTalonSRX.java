package com.otrobotics.otrlib.controllers;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import com.otrobotics.otrlib.sensors.OTRSensor;

public class OTRTalonSRX extends TalonSRX implements OTRMotorController
{
    public OTRTalonSRX(int deviceNumber)
    {
        super(deviceNumber);
    }
    
    public void setPercentOutput (double power) {
        this.set(ControlMode.PercentOutput, power);
    }

    public void setPIDPosition (double position) {
        this.set(ControlMode.Position, position);
    }

    public void setPIDVelocity (double velocity) {
        this.set(ControlMode.Velocity, velocity);
    }

    public void configureFeedbackSensor (OTRSensor feedback_sensor) {
        switch (feedback_sensor.getSensorType()) {
            case "QUAD_ENCODER":
                this.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
                break;
            case "POTENTIOMETER":
                this.configSelectedFeedbackSensor(FeedbackDevice.Analog);
                break;
        }
    }

}
