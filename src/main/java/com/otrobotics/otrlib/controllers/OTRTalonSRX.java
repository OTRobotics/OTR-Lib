package com.otrobotics.otrlib.controllers;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class OTRTalonSRX extends TalonSRX implements OTRMotorController
{
    public OTRTalonSRX(int deviceNumber)
    {
        super(deviceNumber);
    }
    // TODO: Extend the Phoenix SRX Class @RICO
}
