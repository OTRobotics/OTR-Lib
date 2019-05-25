package com.otrobotics.otrlib.systems.velocity;

import java.util.List;
import java.util.ArrayList;

import com.otrobotics.otrlib.sensors.OTRSensor;
import com.otrobotics.otrlib.systems.OTRSubsystem;
import com.otrobotics.otrlib.systems.OTRController;
import com.otrobotics.otrlib.systems.OTRPIDController;
import com.otrobotics.otrlib.systems.velocity.VelocityPIDObject;

public abstract class OTRVelocity extends OTRSubsystem {

    protected List<VelocityPIDObject> PID_motor_controllers;
    protected OTRController controller_type;

    public OTRVelocity (List<Integer> can_ids, List<OTRPIDController> PID_controllers,
                           List<OTRSensor> feedback_sensors, OTRController controller_type) {
        // Set the controller type (VelocityController)
        this.controller_type = controller_type;

        // Instantiate PID_motor_controllers as an ArrayList of VelocityPIDObjects
        PID_motor_controllers = new ArrayList<VelocityPIDObject>();
        // Initialize each VelocityPIDObject
        can_ids.forEach(i -> this.PID_motor_controllers.add(new VelocityPIDObject
                                                    (i, PID_controllers.get(i), 
                                                    feedback_sensors.get(i), controller_type)));
    }

    protected abstract void setPIDSetpoint(int can_device, double setpoint);

    protected OTRPIDController getPID_Values (int deviceIndex) {
        for (int i=0; i<PID_motor_controllers.size(); i++) {
            if (PID_motor_controllers.get(i).getDeviceID() == deviceIndex) {
                return PID_motor_controllers.get(i).getPIDController();
            }
        }
        // This should never be reached
        return null;
    }

}