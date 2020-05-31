package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "MecanumDrive")
public class MecanumDrive extends LinearOpMode {
    DcMotor leftFront, rightFront, leftBack, rightBack;

    ElapsedTime runtime = new ElapsedTime();

    double clip = 0.5;

    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotor.class, "left_front");
        rightFront = hardwareMap.get(DcMotor.class, "right_front");
        leftBack = hardwareMap.get(DcMotor.class, "left_back");
        rightBack = hardwareMap.get(DcMotor.class, "right_back");

        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addLine("Robot Ready!");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()) {
            double forward = -gamepad1.left_stick_y;
            double strafe = -gamepad1.left_stick_x;
            double turn = -gamepad1.right_stick_x;

            leftFront.setPower(Range.clip(forward+turn+strafe, -clip, clip));
            rightFront.setPower(Range.clip(forward-turn-strafe, -clip, clip));
            leftBack.setPower(Range.clip(forward+turn-strafe, -clip, clip));
            rightBack.setPower(Range.clip(forward-turn+strafe, -clip, clip));

            telemetry.addData("Runtime", runtime.seconds());
            telemetry.update();
        }
    }
}
