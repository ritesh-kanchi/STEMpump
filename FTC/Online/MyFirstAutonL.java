package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "MyFirstAutonL")
public class MyFirstAutonL extends LinearOpMode {
  // Hardware
  DcMotor leftDrive, rightDrive;

  // Objects
  ElapsedTime runtime = new ElapsedTime();

  // Variables
  double power = 0.85;

  @Override
  public void runOpMode() {
    // Hardware Mapping
    leftDrive = hardwareMap.get(DcMotor.class, "left_front");
    rightDrive = hardwareMap.get(DcMotor.class, "right_front");

    // Set Direction
    leftDrive.setDirection(DcMotor.Direction.FORWARD);
    rightDrive.setDirection(DcMotor.Direction.REVERSE);

    // Wait for  Start
    telemetry.addLine("Robot Ready!");
    telemetry.update();
    
    waitForStart();

    // Reset runtime variable (to 0 sec)
    runtime.reset();

    telemetry.addData("Runtime", runtime.seconds());
    telemetry.update();

    // Go forward for 0.7 seconds
    leftDrive.setPower(power);
    rightDrive.setPower(power);
    sleep(700);

    // Turn left for 0.3 seconds
    leftDrive.setPower(-power);
    rightDrive.setPower(power);
    sleep(300);

    // Go forward for 0.7 seconds
    leftDrive.setPower(power);
    rightDrive.setPower(power);
    sleep(700);

    // Turn left for 0.3 seconds
    leftDrive.setPower(-power);
    rightDrive.setPower(power);
    sleep(300);



    // Go forward for 0.7 seconds
    leftDrive.setPower(power);
    rightDrive.setPower(power);
    sleep(700);

    // Turn left for 0.3 seconds
    leftDrive.setPower(-power);
    rightDrive.setPower(power);
    sleep(300);


  }
}
