package com.otrobotics.otrlib.systems;

public abstract class OTRSubsystem {

    protected abstract void init();
    protected abstract OTRController getManipulatorControllerType();

    public abstract void setPIDSetpoint(int can_device, double setpoint);

}