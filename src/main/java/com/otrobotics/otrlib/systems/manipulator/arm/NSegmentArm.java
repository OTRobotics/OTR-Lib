package com.otrobotics.otrlib.systems.manipulator.arm;

import java.util.List;

import com.otrobotics.otrlib.sensors.OTRSensor;
import com.otrobotics.otrlib.systems.OTRController;
import com.otrobotics.otrlib.systems.OTRPIDController;
import com.otrobotics.otrlib.systems.manipulator.OTRManipulator;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorPIDObject;

public class NSegmentArm extends OTRManipulator {

    public NSegmentArm (List<Integer> can_ids, List<OTRPIDController> PID_controllers, 
                        List<OTRSensor> feedback_sensors, OTRController controller_type) {
        super(can_ids, PID_controllers, feedback_sensors, controller_type);
    }

    public void init () {

    }

    public OTRController getManipulatorControllerType () {
        return OTRController.SRX;
    }

    public void setPIDSetpoint (int can_device, double setpoint) {
        for (ManipulatorPIDObject p : PID_motor_controllers) {
            if (p.getDeviceID() == can_device) {
                p.setPIDSetpoint(setpoint);
                break;
            }
        }
    }

    public double getAngleAtSegment (int can_device) {
        for (ManipulatorPIDObject p : PID_motor_controllers) {
            if (p.getDeviceID() == can_device) {
                return p.motor_controller.getPIDPosition();
            }
        }
        // This should never be reached
        return 0;
    }

}
