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
     *  The following methods are for feedback sensor and PID configuration
     */

    void configureFeedbackSensor (OTRSensor feedback_sensor);
    void configurePIDTerms (double kP, double kI, double kD, double kF);
    double getPIDPosition ();

}
