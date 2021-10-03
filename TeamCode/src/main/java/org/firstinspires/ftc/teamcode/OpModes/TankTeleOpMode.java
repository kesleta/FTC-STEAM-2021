package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;

@TeleOp(name = "TankTeleOp")
public class TankTeleOpMode extends OpMode {
    DriveTrain driveTrain = new DriveTrain();

    //Runs once when "Init" button is pressed
    @Override
    public void init() {
        driveTrain.mecanumInit(hardwareMap);
    }

    //Runs repeatedly after the driver hits INIT, but before they hit PLAY
    @Override
    public void init_loop() {
    }

    //Runs once when "Start" button is pressed
    @Override
    public void start() {
    }

    //Runs repeatedly after the driver hits START, but before they hit STOP
    @Override
    public void loop() {
        double left = gamepad1.left_stick_y;
        double right = gamepad1.right_stick_y;

        driveTrain.tankDrive(left, right);
    }

    //Runs once when "Stop" button is pressed
    @Override
    public void stop() {
    }
}
