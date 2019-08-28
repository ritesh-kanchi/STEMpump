package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="BaseLinear", group="Linear Opmode")
//@Disabled
public class BaseLinear extends LinearOpMode {

   // Declare OpMode members.
   private ElapsedTime runtime = new ElapsedTime();
   private DcMotor leftDrive = null;
   private DcMotor rightDrive = null;
   private DcMotor leftArm = null;
   private DcMotor rightArm = null;
  private Servo leftServo = null;
   private Servo rightServo = null;

   double servoPosition = 0.0;

   @Override
   public void runOpMode() {
       telemetry.addData("Status", "Initialized");
       telemetry.update();

       leftDrive  = hardwareMap.get(DcMotor.class, "Left_Motor");
       rightDrive = hardwareMap.get(DcMotor.class, "Right_Motor");
       leftArm  = hardwareMap.get(DcMotor.class, "Arm_Left_Motor");
       rightArm = hardwareMap.get(DcMotor.class, "Arm_Right_Motor");
      leftServo = hardwareMap.get(Servo.class, "Arm_Left_Servo");
       rightServo = hardwareMap.get(Servo.class,"Arm_Right_Servo");

       leftDrive.setDirection(DcMotor.Direction.FORWARD);
       rightDrive.setDirection(DcMotor.Direction.REVERSE);

       waitForStart();
       runtime.reset();

       while (opModeIsActive()) {

           double leftPower;
           double rightPower;

           double leftArmPower;
           double rightArmPower;
          
           double drive = -gamepad1.left_stick_y;
           double turn  = -gamepad1.right_stick_x;
           leftPower    = Range.clip(drive - turn, -1.0, 1.0) ;
           rightPower   = Range.clip(drive + turn, -1.0, 1.0) ;

           leftArmPower = .90;
           rightArmPower = .90;
          
           leftDrive.setPower(leftPower);
           rightDrive.setPower(rightPower);

            leftServo.setPosition(-servoPosition);
           rightServo.setPosition(servoPosition);

           if (gamepad1.right_bumper) {
               leftArm.setPower(leftArmPower);
               rightArm.setPower(-rightArmPower);
           }
           if (gamepad1.left_bumper) {
               leftArm.setPower(-leftArmPower);
               rightArm.setPower(rightArmPower);
           }
           else {
               leftArmPower = 0.0;
               rightArmPower = 0.0;
               leftArm.setPower(leftArmPower);
               rightArm.setPower(rightArmPower);
           }

            if (gamepad1.a) {

               leftServo.setPosition(-servoPosition);
               rightServo.setPosition(servoPosition);
           }

           if (gamepad1.b) {
               servoPosition = 1.0;
               leftServo.setPosition(-servoPosition);
               rightServo.setPosition(servoPosition);

           }


           telemetry.addData("Status", "Run Time: " + runtime.toString());
           telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
           telemetry.update();
       }
   }
}


