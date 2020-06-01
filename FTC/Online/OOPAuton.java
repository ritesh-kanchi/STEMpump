package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Auton w/ Class")
public class OOPAuton extends LinearOpMode {
    // Objects
    Robot robot = new Robot();
    Movement move = new Movement(robot,this);
    ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
       robot.init(hardwareMap,telemetry);

        waitForStart();

        // Reset runtime variable (to 0 sec)
        runtime.reset();

        telemetry.addData("Runtime", runtime.seconds());
        telemetry.update();


        for(int i=0; i<4; i ++) {
            move.forwardTurn();
        }
        move.robotStop();


    }
}
