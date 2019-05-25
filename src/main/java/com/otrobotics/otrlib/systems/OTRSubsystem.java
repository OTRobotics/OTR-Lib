package com.otrobotics.otrlib.systems;

public abstract class OTRSubsystem {

    protected abstract void init();
    protected abstract OTRController getManipulatorControllerType();

}