package com.otrobotics.otrlib.systems.manipulator.elevator;

import java.util.List;

import com.otrobotics.otrlib.sensors.OTRSensor;

import com.otrobotics.otrlib.systems.OTRPIDController;
import com.otrobotics.otrlib.systems.manipulator.OTRManipulator;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorController;

public class NStageElevator extends OTRManipulator {

    public NStageElevator (List<Integer> can_ids, List<OTRPIDController> PID_controllers, 
                        List<OTRSensor> feedback_sensors, ManipulatorController controller_type) {
        super(can_ids, PID_controllers, feedback_sensors, controller_type);
    }

    public void init () {

    }

    public ManipulatorController getManipulatorControllerType () {
        return ManipulatorController.SRX;
    }

    public void setPIDSetpoint (int can_device, double setpoint) {
        PID_motor_controllers.get(can_device).setPIDSetpoint(setpoint);
    }

}