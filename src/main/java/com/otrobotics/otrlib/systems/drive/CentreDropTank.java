package com.otrobotics.otrlib.systems.drive;

import com.otrobotics.otrlib.controllers.OTRMotorController;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import java.util.ArrayList;
import java.util.List;

public abstract class CentreDropTank extends OTRDrive
{
    protected List<OTRMotorController> left_controllers = new ArrayList<>();
    protected List<OTRMotorController> right_controllers = new ArrayList<>();
    protected DoubleSolenoid shift_solenoids = new DoubleSolenoid(this.shifter_can_ids.get(0), this.shifter_can_ids.get(1));

}
