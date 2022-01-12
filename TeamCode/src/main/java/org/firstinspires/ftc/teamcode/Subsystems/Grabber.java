package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotData.DeviceMap;


public class Grabber {
    double open = 0.4800;
    double closed = 0.4350;
    enum States {OPEN, CLOSED}
    States state;

    public DeviceMap dm = new DeviceMap();

    public void init(HardwareMap hw){dm.GBInit(hw);}

    public void close(){
        dm.GB.setPosition(closed);
        state = States.CLOSED;
    }

    public void open(){
        dm.GB.setPosition(open);
        state = States.OPEN;
    }

    public void toggleState(){
        if(state == States.OPEN){
            close();
        } else if(state == States.CLOSED){
            open();
        }
    }

    public States getState(){
        return state;
    }
}

