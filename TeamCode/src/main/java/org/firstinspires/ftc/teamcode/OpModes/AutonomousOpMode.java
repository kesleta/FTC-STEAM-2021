package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RobotData.DeviceMap;
import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.DuckSpinner;

@Autonomous(name = "Auto")
public class AutonomousOpMode extends LinearOpMode {
    DriveTrain driveTrain = new DriveTrain();
    DuckSpinner duckSpinner = new DuckSpinner();

    @Override
    public void runOpMode() throws InterruptedException {
        driveTrain.lukeMecInit(hardwareMap);
        duckSpinner.init(hardwareMap);
        // wait for start button.

        waitForStart();
        driveTrain.mecanumDrive(0.3, 0, 0);

        sleep(2000);

        driveTrain.mecanumDrive(0,0,0);

        sleep(3000);

        duckSpinner.turn(1);

        sleep(15000);
    }
}