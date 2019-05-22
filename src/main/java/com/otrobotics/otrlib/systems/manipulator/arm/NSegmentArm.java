package com.otrobotics.otrlib.systems.manipulator.arm;

import java.util.List;

import com.otrobotics.otrlib.sensors.OTRSensor;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorController;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorPIDController;
import com.otrobotics.otrlib.systems.manipulator.OTRManipulator;

public class NSegmentArm extends OTRManipulator {

    public NSegmentArm (List<Integer> can_ids, List<ManipulatorPIDController> PID_controllers, 
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
