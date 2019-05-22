package com.otrobotics.otrlib.systems.manipulator;

public class ManipulatorPIDController {

    public double kP;
    public double kI;
    public double kD;
    public double kF;

    public ManipulatorPIDController (double kP, double kI, double kD) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    public ManipulatorPIDController (double kP, double kI, double kD, double kF) {
        this(kP, kI, kD);
        this.kF = kF;
    }

}