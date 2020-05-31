package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Color Sensor")
public class ColorSensorAuton extends LinearOpMode {
  // Hardware
  DcMotor leftDrive, rightDrive;

  // Sensors
  ColorSensor colorSensor;

  // Objects
  ElapsedTime runtime = new ElapsedTime();

  // Variables
  double power = 0.35;

  @Override
  public void runOpMode() {
    // Hardware Mapping
    leftDrive = hardwareMap.get(DcMotor.class, "left_front");
    rightDrive = hardwareMap.get(DcMotor.class, "right_front");

    colorSensor = hardwareMap.get(ColorSensor.class, "color_sensor");

    // Set Direction
    leftDrive.setDirection(DcMotor.Direction.FORWARD);
    rightDrive.setDirection(DcMotor.Direction.REVERSE);

    colorSensor.enableLed(true);

    // Wait for  Start
    telemetry.addLine("Robot Ready!");
    telemetry.update();

    waitForStart();

      telemetry.addData("Alpha", colorSensor.alpha());
      telemetry.addData("Red  ", colorSensor.red());
      telemetry.addData("Green", colorSensor.green());
      telemetry.addData("Blue ", colorSensor.blue());

      while (colorSensor.red() < 20) {
        leftDrive.setPower(power);
        rightDrive.setPower(power);
    }

      leftDrive.setPower(0);
      rightDrive.setPower(0);

  }
}
