package com.otrobotics.otrlib.controllers;

public interface OTRMotorController
{

    /*
     *  The following methods are used in subclass OTRMotorController classes
     *  for ctre phoenix control mode activation
     */

    void setPercentOutput (double power);
    void setPIDPosition (double position);
    void setPIDVelocity (double velocity);

}
