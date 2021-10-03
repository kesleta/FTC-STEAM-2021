package org.firstinspires.ftc.teamcode.RobotData;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class DeviceMap {
    public DcMotor FR, FL, BR, BL;


    ElapsedTime time = new ElapsedTime();

    public DeviceMap(){}

    private DcMotorSimple.Direction dir(boolean reversed){
        if(reversed){
            return DcMotor.Direction.REVERSE;
        } else {
            return DcMotor.Direction.FORWARD;
        }
    }

    public void init(HardwareMap hwMap, boolean frr, boolean flr, boolean brr, boolean blr){
        FR = hwMap.get(DcMotor.class, "FR");
        FL = hwMap.get(DcMotor.class, "FL");
        BR = hwMap.get(DcMotor.class, "BR");
        BL = hwMap.get(DcMotor.class, "BL");

        FR.setDirection(dir(frr));
        FL.setDirection(dir(blr));
        BR.setDirection(dir(brr));
        BL.setDirection(dir(blr));

        FR.setPower(0);
        FL.setPower(0);
        BR.setPower(0);
        BL.setPower(0);

        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

}