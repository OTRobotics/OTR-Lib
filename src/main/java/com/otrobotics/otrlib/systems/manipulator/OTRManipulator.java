package com.otrobotics.otrlib.systems.manipulator;

import java.util.List;
import java.util.ArrayList;

import com.otrobotics.otrlib.sensors.OTRSensor;
import com.otrobotics.otrlib.systems.OTRSubsystem;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorController;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorPIDController;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorPIDObject;

public abstract class OTRManipulator extends OTRSubsystem {

    protected List<ManipulatorPIDObject> PID_motor_controllers;
    protected ManipulatorController controller_type;

    public OTRManipulator (List<Integer> can_ids, List<ManipulatorPIDController> PID_controllers,
                           List<OTRSensor> feedback_sensors, ManipulatorController controller_type) {
        // Set the controller type (ManipualtorController)
        this.controller_type = controller_type;

        // Instantiate PID_motor_controllers as an ArrayList of ManipulatorPIDObjects
        PID_motor_controllers = new ArrayList<ManipulatorPIDObject>();
        // Initialize each ManipulatorPIDObject
        can_ids.forEach(i -> this.PID_motor_controllers.add(new ManipulatorPIDObject
                                                    (i, PID_controllers.get(i), 
                                                    feedback_sensors.get(i), controller_type)));
    }

    protected abstract void init();
    protected abstract ManipulatorController getManipulatorControllerType();

    protected abstract void setPIDSetpoint(int can_device, double setpoint);

    protected ManipulatorPIDController getPID_Values (int deviceIndex) {
        return PID_motor_controllers.get(deviceIndex).getPIDController();
    }

}