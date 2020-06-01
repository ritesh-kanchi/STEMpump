package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeleOp w/ Class")
public class OOPTeleOp extends LinearOpMode {
  Robot robot = new Robot();

  @Override
  public void runOpMode() {

    robot.init(hardwareMap, telemetry);

    waitForStart();

    robot.runtime.reset();

    while (opModeIsActive()) {
      double drive = -gamepad1.left_stick_y;
      double turn = -gamepad1.right_stick_x;

      double leftPower = Range.clip(drive - turn, -1.0, 1.0);
      double rightPower = Range.clip(drive + turn, -1.0, 1.0);

      double armPower = -gamepad1.left_trigger + gamepad1.right_trigger;

      if (gamepad1.a) {
        robot.clawServo.setPosition(robot.servoPosition);
      }

      if (gamepad1.b) {
        robot.clawServo.setPosition(0);
      }

      robot.leftDrive.setPower(leftPower);
      robot.rightDrive.setPower(rightPower);
      robot.armMotor.setPower(armPower);

      telemetry.addData("Runtime", robot.runtime.seconds()); // Runtime: 30.243
      telemetry.update();
    }
  }
}
