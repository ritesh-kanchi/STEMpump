package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "MyFirstAuton", group = "Linear Opmode")
//@Disabled
public class MyFirstAuton extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    // Make sure power is between -1 and 1
    double power = 1;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        leftDrive.setPower(power);
        rightDrive.setPower(power);
        sleep(700);

        leftDrive.setPower(-power);
        rightDrive.setPower(power);
        sleep(300);

        leftDrive.setPower(power);
        rightDrive.setPower(power);
        sleep(700);

        leftDrive.setPower(-power);
        rightDrive.setPower(power);
        sleep(300);

        leftDrive.setPower(power);
        rightDrive.setPower(power);
        sleep(700);

        leftDrive.setPower(-power);
        rightDrive.setPower(power);
        sleep(300);

        leftDrive.setPower(power);
        rightDrive.setPower(power);
        sleep(700);


    }
}
