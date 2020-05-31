package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "MyFirstTeleOpO")
public class MyFirstTeleOpO extends OpMode {

    DcMotor leftDrive, rightDrive, armMotor;
    Servo clawServo;

    ElapsedTime runtime = new ElapsedTime();

    double servoPosition = 0.45;

    @Override
    public void init() {
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        armMotor = hardwareMap.get(DcMotor.class,"arm_motor");

        clawServo = hardwareMap.get(Servo.class, "claw_sevro");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    public void init_loop() {
        telemetry.addLine("Robot Ready");
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        double drive = -gamepad1.left_stick_y;
        double turn = -gamepad1.right_stick_x;

        double leftPower = Range.clip(drive - turn, -1.0, 1.0);
        double rightPower = Range.clip(drive + turn, -1.0, 1.0);

        double armPower = -gamepad1.left_trigger + gamepad1.right_trigger;

        if(gamepad1.a) {
            clawServo.setPosition(servoPosition);
        }

        if(gamepad2.b) {
            clawServo.setPosition(0);
        }

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
        armMotor.setPower(armPower);

        telemetry.addData("Runtime",runtime.seconds());
    }

    @Override
    public void stop() {}
}
