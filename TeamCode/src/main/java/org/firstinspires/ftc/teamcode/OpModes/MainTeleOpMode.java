package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.DuckSpinner;
import org.firstinspires.ftc.teamcode.Subsystems.Elevator;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.Swivel;

@TeleOp(name = "MainTeleOpMode")
public class MainTeleOpMode extends OpMode {
    DriveTrain driveTrain = new DriveTrain();
    Elevator elevator = new Elevator();
    Swivel swivel = new Swivel();
    Grabber grabber = new Grabber();
    DuckSpinner duckSpinner = new DuckSpinner();

    boolean grabTogPressed = false;
    boolean reversed = true;
    boolean reverseTogPressed = false;

    //Runs once when "Init" button is pressed
    @Override
    public void init() {
        driveTrain.lukeMecInit(hardwareMap);
        elevator.init(hardwareMap);
        swivel.init(hardwareMap);
        grabber.init(hardwareMap);
        duckSpinner.init(hardwareMap);
    }

    //Runs repeatedly after the driver hits INIT, but before they hit PLAY
    @Override
    public void init_loop() {
    }

    //Runs once when "Start" button is pressed
    @Override
    public void start() {
        swivel.set(1);
        grabber.open();
    }

    //Runs repeatedly after the driver hits START, but before they hit STOP
    @Override
    public void loop() {
        double fastMode = 0.7;
        double slowMode = 0.3;
        double str = -gamepad1.right_stick_y * (gamepad1.left_bumper ? 0.3 : 0.7) * (reversed ? -1 : 1);
        double lat = -gamepad1.right_stick_x * (gamepad1.left_bumper ? 0.5 : 1) * (reversed ? -1 : 1);
        double rot = gamepad1.left_stick_x  * (gamepad1.left_bumper ? 0.3 : 0.6);
        driveTrain.mecanumDrive(str, lat, rot);
        duckSpinner.turn(gamepad1.right_trigger*0.7);

        //Elevator
        elevator.turn(gamepad2.left_trigger - gamepad2.right_trigger);
        //Close
        if (gamepad2.y) {
            grabber.close();
        }
        //Open
        if (gamepad2.a) {
            grabber.open();
        }
        //Toggle Grabber
        if(gamepad2.b && !grabTogPressed){
            grabber.toggleState();
            grabTogPressed = true;
        } else if(!gamepad2.b){
            grabTogPressed = false;
        }
        //Toggle Reversed
        if(gamepad1.right_bumper && !reverseTogPressed){
            reversed = !reversed;
            reverseTogPressed = true;
        } else if(!gamepad1.right_bumper){
            reverseTogPressed = false;
        }
        //Swivel
        swivel.turn((gamepad2.dpad_left ? -0.0005 : 0) + (gamepad2.dpad_right ? 0.0005 : 0));
        if(gamepad2.left_bumper){
            swivel.setPos(0.792);
        }




        telemetry.addData("swivel", "Swivel : " + swivel.getPos());
    }

    //Runs once when "Stop" button is pressed
    @Override
    public void stop() {
    }
}





