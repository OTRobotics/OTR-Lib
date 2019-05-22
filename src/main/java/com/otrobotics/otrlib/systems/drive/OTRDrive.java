package com.otrobotics.otrlib.systems.drive;

import java.util.List;

public abstract class OTRDrive
{

    protected List<Integer> left_can_ids;
    protected List<Integer> right_can_ids;
    protected List<Integer> shifter_can_ids;
    protected DriveController controller_type;

    public OTRDrive()
    {

    }
    public OTRDrive(List<Integer> left_can_ids, List<Integer> right_can_ids)
    {
        this.left_can_ids = left_can_ids;
        this.right_can_ids = right_can_ids;
    }
    public OTRDrive(List<Integer> left_can_ids, List<Integer> right_can_ids, List<Integer> shifter_can_ids)
    {
        this(left_can_ids,right_can_ids);
        this.shifter_can_ids = shifter_can_ids;
    }

    protected abstract void init();
    protected abstract DriveController getDriveControllerType();

    public abstract void drive(double speed, double turn);
    public abstract void shiftUp();
    public abstract void shiftDown();

    //TODO: Current Limiting Structure


}
