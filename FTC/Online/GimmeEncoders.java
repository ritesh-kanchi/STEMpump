package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name = "GimmeEncoders")
public class GimmeEncoders extends LinearOpMode {

    Robot robot = new Robot();

    @Override
    public void runOpMode() {

        robot.init(hardwareMap, telemetry);
        robot.leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        robot.setEncoders();

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Left given", robot.leftDrive.getCurrentPosition());
            telemetry.addData("Right given", robot.rightDrive.getCurrentPosition());
            telemetry.update();
        }
    }
}