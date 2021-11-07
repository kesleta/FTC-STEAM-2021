package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;

@TeleOp(name = "JakeMecTeleOp")
public class JakeMecanumTeleOpMode extends OpMode {
    DriveTrain driveTrain = new DriveTrain();
    DuckSpinner duckSpinner = new DuckSpinner();
    Elevator elevator = new Elevator();

    //Runs once when "Init" button is pressed
    @Override
    public void init() {
        driveTrain.jakeMecInit(hardwareMap);
        duckSpinner.init(hardwareMap);
        elevator.init(hardwareMap);
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
        duckSpinner.turn(gamepad1.a ? -1 : 0);
        elevator.turn(gamepad1.left_trigger - gamepad1.right_trigger);
    }

    //Runs once when "Stop" button is pressed
    @Override
    public void stop() {
    }
}
