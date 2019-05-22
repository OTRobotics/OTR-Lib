package com.otrobotics.otrlib.sensors;

import com.otrobotics.otrlib.sensors.OTRSensor;

import com.ctre.phoenix.motorcontrol.RemoteFeedbackDevice;

public class OTRPotentiometer implements OTRSensor
{

    public String getSensorType () {
        return "POTENTIOMETER";
    }

}
