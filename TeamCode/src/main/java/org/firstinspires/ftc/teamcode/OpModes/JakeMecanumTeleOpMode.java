package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.DuckSpinner;

@TeleOp(name = "JakeMecTeleOp")
public class JakeMecanumTeleOpMode extends OpMode {
    DriveTrain driveTrain = new DriveTrain();
    DuckSpinner duckSpinner = new DuckSpinner();

    //Runs once when "Init" button is pressed
    @Override
    public void init() {
        driveTrain.jakeMecInit(hardwareMap);
        duckSpinner.init(hardwareMap);
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
        double forward = gamepad1.right_stick_y;
        double lateral = gamepad1.right_stick_x;
        double rotation = gamepad1.left_stick_x;

        driveTrain.mecanumDrive(forward, lateral, rotation);


        double spin = gamepad1.left_trigger;

        duckSpinner.turn(-spin);
    }

    //Runs once when "Stop" button is pressed
    @Override
    public void stop() {
    }
}
