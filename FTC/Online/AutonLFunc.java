package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "MyFirstAutonL w/ Functions")
public class AutonLFunc extends LinearOpMode {
    // Hardware
    DcMotor leftDrive, rightDrive;

    // Objects
    ElapsedTime runtime = new ElapsedTime();

    // Variables
    double power = 0.85;

    @Override
    public void runOpMode() {
        // Hardware Mapping
        leftDrive = hardwareMap.get(DcMotor.class, "left_front");
        rightDrive = hardwareMap.get(DcMotor.class, "right_front");

        // Set Direction
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Wait for  Start
        telemetry.addLine("Robot Ready!");
        telemetry.update();

        waitForStart();

        // Reset runtime variable (to 0 sec)
        runtime.reset();

        telemetry.addData("Runtime", runtime.seconds());
        telemetry.update();


        for(int i=0; i<4; i ++) {
            forwardTurn();
        }
        robotStop();


    }

    public void forwardTurn() {
        // Go forward for 0.7 seconds
        move(power, 700);

        // Turn left for 0.3 seconds
        move(-power, power, 300);
    }

    public void robotStop() {
        // Set motor power to 0
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    public void move(double lPow, double rPow, long time) {
        leftDrive.setPower(lPow);
        rightDrive.setPower(rPow);
        sleep(time);
    }

    // FUNCTION OVERLOADING
    public void move(double power, long time) {
        move(power,power,time);
    }
}
