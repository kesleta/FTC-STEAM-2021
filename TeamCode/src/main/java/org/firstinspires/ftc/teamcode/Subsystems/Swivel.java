package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotData.DeviceMap;

public class Swivel {
    double frontBound = 0.796;
    double backBound = 0.715;
    double pos = 1;

    public DeviceMap dm = new DeviceMap();

    public void init(HardwareMap hw){dm.SWInit(hw);}

    public void set(double p){
        p *= (frontBound-backBound);
        p += backBound;
        p = p>frontBound ? frontBound : p;
        p = p<backBound ? backBound : p;
        pos = p;
        dm.SW.setPosition(pos);
    }

    public void setPos(double p){
        pos = p;
        dm.SW.setPosition(pos);
    }

    public void turn(double s){
        pos += s;
        pos = pos>frontBound ? frontBound : pos;
        pos = pos<backBound ? backBound : pos;
        dm.SW.setPosition(pos);
    }

    public double getPos(){
        return pos;
    }
}

