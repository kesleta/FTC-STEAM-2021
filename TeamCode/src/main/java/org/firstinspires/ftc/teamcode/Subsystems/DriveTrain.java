package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotData.DeviceMap;

public class DriveTrain {

    static final double FRWeight = -1;
    static final double FLWeight = -1;
    static final double BRWeight = -1;
    static final double BLWeight = -1;

    public DeviceMap dm = new DeviceMap();

    public void jakeMecInit(HardwareMap hw){
        dm.wheelInit(hw, false, true, false, true);
    }

    public void lukeMecInit(HardwareMap hw){
        dm.wheelInit(hw, false, false, true, true);
    }

    public void mecanumDrive(double forward, double lateral, double rotation){
        double FRPower = forward + lateral + rotation;
        double FLPower = forward - lateral - rotation;
        double BRPower = forward - lateral + rotation;
        double BLPower = forward + lateral - rotation;

        dm.FR.setPower(FRPower * FRWeight);
        dm.FL.setPower(FLPower * FLWeight);
        dm.BR.setPower(BRPower * BRWeight);
        dm.BL.setPower(BLPower * BLWeight);
    }

    public void tankDrive(double left, double right){
        dm.FR.setPower(right * FRWeight);
        dm.FL.setPower(left * FLWeight);
        dm.BR.setPower(right * BRWeight);
        dm.BL.setPower(left * BLWeight);
    }

}
