package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "Touch Sensor")
public class TouchSensorAuton extends LinearOpMode {
  // Hardware
  DcMotor leftDrive, rightDrive;

  // Sensors
  DigitalChannel touchSensorF, touchSensorB;

  // Objects
  ElapsedTime runtime = new ElapsedTime();

  // Variables
  double power = -0.35;

  @Override
  public void runOpMode() {
    // Hardware Mapping
    leftDrive = hardwareMap.get(DcMotor.class, "left_front");
    rightDrive = hardwareMap.get(DcMotor.class, "right_front");

    touchSensorF = hardwareMap.get(DigitalChannel.class, "touch_f");
    touchSensorB = hardwareMap.get(DigitalChannel.class, "touch_b");

    // Set Direction
    leftDrive.setDirection(DcMotor.Direction.FORWARD);
    rightDrive.setDirection(DcMotor.Direction.REVERSE);

    touchSensorF.setMode(DigitalChannel.Mode.INPUT);
    touchSensorB.setMode(DigitalChannel.Mode.INPUT);

    // Wait for  Start
    telemetry.addLine("Robot Ready!");
    telemetry.update();

    waitForStart();
    while (opModeIsActive()) {
      // OPTION 1
      if (touchSensorB.getState()) {
        power *= -1;
      }

      // FUNCTIONS DO LATER

      if (isTouched(touchSensorB)) {
        power *= -1;
      }

      // OPTION 2
      if (touchSensorF.getState() || touchSensorB.getState()) {
        power = -power;
      }

      // FUNCTIONS

      if (isTouched(touchSensorF) || isTouched(touchSensorB)) {
        power = -power;
      }

      // OPTION 3
        if(touchSensorF.getState()) {
            power = -0.35;
        }

        if(touchSensorB.getState()) {
            power = 0.35;
        }

        // FUNCTIONS

        if(isTouched(touchSensorF)) {
          power = -modPower();
        }

        if(isTouched(touchSensorB)) {
          power = modPower();
        }

      leftDrive.setPower(power);
      rightDrive.setPower(power);
    }
  }

  public boolean isTouched(DigitalChannel touchSensor) {
    if(touchSensor.getState()) {
      return true;
    } else {
      return false;
    }
  }

  public double modPower() {
    double modPower = power*0.85;
    return modPower;

    // could make into one line
    // return power*0.85;
  }
}
