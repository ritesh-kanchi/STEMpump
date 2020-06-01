package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Movement {
  Robot robot = null;
  LinearOpMode opMode = null;

  double power = robot.power;
  double inchCount = 24.5;

  public Movement(Robot arobot, LinearOpMode aOpMode) {
    robot = arobot;
    opMode = aOpMode;
  }

  public void forwardTurn() {
    // Go forward for 0.7 seconds
    move(power, 700);

    // Turn left for 0.3 seconds
    move(-power, power, 300);
  }

  public void robotStop() {
    // Set motor power to 0
    robot.leftDrive.setPower(0);
    robot.rightDrive.setPower(0);
  }

  public void move(double lPow, double rPow, long time) {
    robot.leftDrive.setPower(lPow);
    robot.rightDrive.setPower(rPow);
    opMode.sleep(time);
  }

  // FUNCTION OVERLOADING
  public void move(double power, long time) {
    move(power, power, time);
  }

  public void encoderDrive(double speed, double leftInches, double rightInches, double timeoutS) {
    // Ensure that the opmode is still active
    if (opMode.opModeIsActive()) {

      // Determine new target position, and pass to motor controller
      int newLeftTarget = robot.leftDrive.getCurrentPosition() + (int) (leftInches * inchCount);
      int newRightTarget = robot.rightDrive.getCurrentPosition() + (int) (rightInches * inchCount);
      robot.leftDrive.setTargetPosition(newLeftTarget);
      robot.rightDrive.setTargetPosition(newRightTarget);

      // Turn On RUN_TO_POSITION
      robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

      // reset the timeout time and start motion.
      robot.runtime.reset();
      robot.leftDrive.setPower(Math.abs(speed));
      robot.rightDrive.setPower(Math.abs(speed));

      // keep looping while we are still active, and there is time left, and both motors are
      // running.
      // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor
      // hits
      // its target position, the motion will stop.  This is "safer" in the event that the robot
      // will
      // always end the motion as soon as possible.
      // However, if you require that BOTH motors have finished their moves before the robot
      // continues
      // onto the next step, use (isBusy() || isBusy()) in the loop test.
      while (opMode.opModeIsActive()
          && (robot.runtime.seconds() < timeoutS)
          && (robot.leftDrive.isBusy() && robot.rightDrive.isBusy())) {

        // Display it for the driver.
        opMode.telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
        opMode.telemetry.addData(
            "Path2",
            "Running at %7d :%7d",
            robot.leftDrive.getCurrentPosition(),
            robot.rightDrive.getCurrentPosition());
        opMode.telemetry.update();
      }

      // Stop all motion;
      robotStop();

      // Turn off RUN_TO_POSITION
      robot.setEncoders();

      opMode.sleep(250); // optional pause after each move
    }
  }

  public void encoderDrive(double speed, double inches, double timeOutS) {
    encoderDrive(speed, inches, inches, timeOutS);
  }
}
