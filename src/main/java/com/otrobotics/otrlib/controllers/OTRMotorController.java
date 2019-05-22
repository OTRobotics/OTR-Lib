package com.otrobotics.otrlib.controllers;

import com.otrobotics.otrlib.sensors.OTRSensor;

public interface OTRMotorController
{

    /*
     *  The following methods are used in subclass OTRMotorController classes
     *  for ctre phoenix control mode activation
     */

    void setPercentOutput (double power);
    void setPIDPosition (double position);
    void setPIDVelocity (double velocity);

    /*
     *  The following methods are for feedback sensor configuration
     */

    void configureFeedbackSensor (OTRSensor feedback_sensor);

}
