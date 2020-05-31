package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "MyFirstTeleOpL")
public class MyFirstTeleOpL extends LinearOpMode {
    // Hardware
    DcMotor leftDrive, rightDrive, armMotor;
    Servo clawServo;

    // Object
    ElapsedTime runtime = new ElapsedTime();

    // Variables
    double servoPosition = 0.45;

    @Override
    public void runOpMode() {
        // Hardware Mapping
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        armMotor = hardwareMap.get(DcMotor.class, "arm_motor");

        clawServo = hardwareMap.get(Servo.class, "claw_servo");

        // Directions
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Wait for start
        telemetry.addLine("Robot Ready!"); // Robot Ready!
        telemetry.update();

        waitForStart();

        runtime.reset();

        while(opModeIsActive()) {
            double drive = -gamepad1.left_stick_y;
            double turn = -gamepad1.right_stick_x;

            double leftPower = Range.clip(drive - turn, -1.0, 1.0);
            double rightPower = Range.clip(drive + turn, -1.0, 1.0);

            double armPower = -gamepad1.left_trigger + gamepad1.right_trigger;

            if(gamepad1.a) {
                clawServo.setPosition(servoPosition);
            }

            if(gamepad1.b) {
                clawServo.setPosition(0);
            }

            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
            armMotor.setPower(armPower);

            telemetry.addData("Runtime", runtime.seconds()); // Runtime: 30.243
            telemetry.update();
        }

    }
}
