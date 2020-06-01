package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Hardware;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {
  // Variables
  public static final double servoPosition = 0.45;
  // static - belongs to the class, same for all instances of this class, can be manipulated for all
  // at same, initalized once (at beginning)
  // final - cannot be changed

    public static final double power = 0.85;

  // Hardware
  public DcMotor leftDrive, rightDrive, armMotor;
  public Servo clawServo;

  // Objects
  public ElapsedTime runtime = new ElapsedTime();

  // Prepares the new object for use, often accepting arguments that the constructor uses to set
  // required member variables.
  public Robot() {}

  public void init(HardwareMap hwMap, Telemetry telemetry) {
      // Hardware Mapping
      leftDrive = hwMap.get(DcMotor.class, "left_drive");
      rightDrive = hwMap.get(DcMotor.class, "right_drive");
      armMotor = hwMap.get(DcMotor.class, "arm_motor");

      clawServo = hwMap.get(Servo.class, "claw_servo");

      // Directions
      leftDrive.setDirection(DcMotor.Direction.FORWARD);
      rightDrive.setDirection(DcMotor.Direction.REVERSE);

      // Wait for start
      telemetry.addLine("Robot Ready!"); // Robot Ready!
      telemetry.update();
  }

  public void setEncoders() {
      leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
      rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
  }
}
