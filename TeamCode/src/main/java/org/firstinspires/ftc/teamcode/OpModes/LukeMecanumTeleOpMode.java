package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;

@TeleOp(name = "LukeMecTeleOp")
public class LukeMecanumTeleOpMode extends OpMode {
    DriveTrain driveTrain = new DriveTrain();

    //Runs once when "Init" button is pressed
    @Override
    public void init() {
        driveTrain.lukeMecInit(hardwareMap);
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
        driveTrain.mecanumDrive(gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
    }

    //Runs once when "Stop" button is pressed
    @Override
    public void stop() {
    }
}





