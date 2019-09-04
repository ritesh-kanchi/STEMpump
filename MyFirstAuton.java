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

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


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

@Autonomous(name="BaseAuto", group="Linear Opmode")
//@Disabled
public class BaseAuto extends LinearOpMode {

   // Declare OpMode members.
   private ElapsedTime runtime = new ElapsedTime();
   //private DcMotor leftDrive = null;
   //private DcMotor rightDrive = null;

   DcMotor leftDrive;
   DcMotor rightDrive;
   DcMotor leftArm;
   DcMotor rightArm;
   /* Servo leftServo;
   Servo rightServo; */


   // Make sure power is between -1 and 1
   double power = 0.5;
   //double servoPosition = 0.0;

   @Override
   public void runOpMode() {
       telemetry.addData("Status", "Initialized");
       telemetry.update();

       leftDrive = hardwareMap.dcMotor.get("Left_Motor");
       rightDrive = hardwareMap.dcMotor.get("Right_Motor");
       leftArm  = hardwareMap.dcMotor.get("Arm_Left_Motor");
       rightArm = hardwareMap.dcMotor.get("Arm_Right_Motor");
      /* leftServo = hardwareMap.servo.get("Arm_Left_Servo");
       rightServo = hardwareMap.servo.get("Arm_Right_Servo"); */

       leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

      /*  leftServo.setPosition(-servoPosition);
       rightServo.setPosition(servoPosition); */

       waitForStart();
       runtime.reset();

       /*
       *
       *
       *   SERVO CODE 😛
       *
       *
       */

       leftDrive.setPower(-power);
       rightDrive.setPower(-power);

       sleep(1350);

       leftDrive.setPower(power);
       rightDrive.setPower(-power);

       sleep(800);

       leftDrive.setPower(-power);
       rightDrive.setPower(-power);

       sleep(2200);

       leftDrive.setPower(power);
       rightDrive.setPower(-power);

       sleep(600);

       leftDrive.setPower(-power);
       rightDrive.setPower(-power);

       sleep(5000);

   }
}


