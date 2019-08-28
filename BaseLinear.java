/* Copyright (c) 2017 FIRST. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification,
* are permitted (subject to the limitations in the disclaimer below) provided that
* the following conditions are met:
*
* Redistributions of source code must retain the above copyright notice, this list
* of conditions and the following disclaimer.
*
* Redistributions in binary form must reproduce the above copyright notice, this
* list of conditions and the following disclaimer in the documentation and/or
* other materials provided with the distribution.
*
* Neither the name of FIRST nor the names of its contributors may be used to endorse or
* promote products derived from this software without specific prior written permission.
*
* NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
* LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
* "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
* THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
* ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
* FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
* DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
* CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
* OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
* OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/**
* This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
* the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
* of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
* class is instantiated on the Robot Controller and executed.
*
* This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
* It includes all the skeletal structure that all linear OpModes contain.
*
* Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
* Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
*/

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

       // Initialize the hardware variables. Note that the strings used here as parameters
       // to 'get' must correspond to the names assigned during the robot configuration
       // step (using the FTC Robot Controller app on the phone).
       leftDrive  = hardwareMap.get(DcMotor.class, "Left_Motor");
       rightDrive = hardwareMap.get(DcMotor.class, "Right_Motor");
       leftArm  = hardwareMap.get(DcMotor.class, "Arm_Left_Motor");
       rightArm = hardwareMap.get(DcMotor.class, "Arm_Right_Motor");
      leftServo = hardwareMap.get(Servo.class, "Arm_Left_Servo");
       rightServo = hardwareMap.get(Servo.class,"Arm_Right_Servo");

       // Most robots need the motor on one side to be reversed to drive forward
       // Reverse the motor that runs backwards when connected directly to the battery
       leftDrive.setDirection(DcMotor.Direction.FORWARD);
       rightDrive.setDirection(DcMotor.Direction.REVERSE);

       // Wait for the game to start (driver presses PLAY)
       waitForStart();
       runtime.reset();

       // run until the end of the match (driver presses STOP)
       while (opModeIsActive()) {

           // Setup a variable for each drive wheel to save power level for telemetry
           double leftPower;
           double rightPower;

           double leftArmPower;
           double rightArmPower;

           // Choose to drive using either Tank Mode, or POV Mode
           // Comment out the method that's not used.  The default below is POV.

           // POV Mode uses left stick to go forward, and right stick to turn.
           // - This uses basic math to combine motions and is easier to drive straight.
           double drive = -gamepad1.left_stick_y;
           double turn  = -gamepad1.right_stick_x;
           leftPower    = Range.clip(drive - turn, -1.0, 1.0) ;
           rightPower   = Range.clip(drive + turn, -1.0, 1.0) ;

           leftArmPower = .90;
           rightArmPower = .90;


           // Tank Mode uses one stick to control each wheel.
           // - This requires no math, but it is hard to drive forward slowly and keep straight.
           // leftPower  = -gamepad1.left_stick_y ;
           // rightPower = -gamepad1.right_stick_y ;

           // Send calculated power to wheels
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


           // Show the elapsed game time and wheel power.
           telemetry.addData("Status", "Run Time: " + runtime.toString());
           telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
           telemetry.update();
       }
   }
}


