package com.otrobotics.otrlib.systems;

public class OTRPIDController {

    public double kP;
    public double kI;
    public double kD;
    public double kF;

    public OTRPIDController (double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.kF = 0;
    }

    public OTRPIDController (double kP, double kI, double kD, double kF) {
        this(kP, kI, kD);
        this.kF = kF;
    }

}