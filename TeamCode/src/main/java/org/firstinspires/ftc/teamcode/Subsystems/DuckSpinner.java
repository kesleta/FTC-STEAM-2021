package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotData.DeviceMap;

public class DuckSpinner {

    public DeviceMap dm = new DeviceMap();

    public void init(HardwareMap hw){dm.DSInit(hw);}
    public void turn(double speed) {
        dm.DS.setPower(speed);
    }
}
