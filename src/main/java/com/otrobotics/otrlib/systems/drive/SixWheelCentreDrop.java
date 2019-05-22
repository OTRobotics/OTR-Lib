package com.otrobotics.otrlib.systems.drive;

import com.otrobotics.otrlib.controllers.OTRTalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class SixWheelCentreDrop extends CentreDropTank
{
    @Override
    protected void init()
    {

        switch(getDriveControllerType())
        {
            case SR:
            case SRX:
            case SPX:
                this.left_can_ids.forEach(i -> this.left_controllers.add(new OTRTalonSRX(i)));

        }
    }

    @Override
    protected DriveController getDriveControllerType()
    {
        return DriveController.SRXMASTER_SPXSLAVE;
    }

    @Override
    public void drive(double speed, double turn)
    {

    }

    @Override
    public void shiftUp()
    {
        this.shift_solenoids.set(DoubleSolenoid.Value.kForward);
    }

    @Override
    public void shiftDown()
    {
        this.shift_solenoids.set(DoubleSolenoid.Value.kReverse);
    }
}
