package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotData.DeviceMap;

public class Elevator {
    public DeviceMap dm = new DeviceMap();

    public void init(HardwareMap hw){dm.ELInit(hw);}
    public void turn(double speed) {
        dm.EL.setPower(speed);
    }
}
