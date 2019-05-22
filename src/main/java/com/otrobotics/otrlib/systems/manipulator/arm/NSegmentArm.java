package com.otrobotics.otrlib.systems.manipulator.arm;

import java.util.List;

import com.otrobotics.otrlib.systems.manipulator.ManipulatorController;
import com.otrobotics.otrlib.systems.manipulator.ManipulatorPIDController;
import com.otrobotics.otrlib.systems.manipulator.OTRManipulator;

public class NSegmentArm extends OTRManipulator {

    public NSegmentArm (List<Integer> can_ids, List<ManipulatorPIDController> PID_controllers, 
                        ManipulatorController controller_type) {
        super(can_ids, PID_controllers, controller_type);
    }

    public void init () {

    }

    public ManipulatorController getManipulatorControllerType () {
        return ManipulatorController.SRX;
    }

    public void setPIDSetpoint (int can_device, double setpoint) {
        
    }

}