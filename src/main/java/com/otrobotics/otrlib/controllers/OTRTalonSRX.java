package com.otrobotics.otrlib.controllers;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

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

}
