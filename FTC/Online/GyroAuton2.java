package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import static com.qualcomm.hardware.bosch.BNO055IMU.SensorMode.IMU;

@Autonomous(name = "Gyro Auton")
public class GyroAuton extends LinearOpMode {

    RobotGyro robot = new RobotGyro();
//    Movement move = new Movement(robot,this);

    @Override
    public void runOpMode() {
        robot.init(hardwareMap,telemetry);

        waitForStart();

      while(opModeIsActive()) {
          // FIRST PART
          Orientation angles = robot.imu.getAngularOrientation();
          telemetry.addData("IMU Ouput",angles.toString());
          telemetry.update();

          // CONTINUED
          double imuZ = angles.firstAngle;
          move(0,(-imuZ)*0.02);

          // replaces above
          double heading = angles.firstAngle;
          move(0.5,(heading)*0.02);

          // replaces above
          double bearing = 60;
//          double heading = angles.firstAngle;
          move(0.5,(bearing-heading)*0.02);

          // replaces above
          moveGyro(0.5,45);

          // gyro time
          moveGT(0.5,0,3);
          moveGT(0.2,60,2);
          moveGT(0.3,-90,4);
      }
    }

    public void move(double forward, double turn) {
        robot.leftDrive.setPower(forward + turn);
        robot.rightDrive.setPower(forward - turn);
    }

    public void moveGyro(double forward, double bearing) {
        Orientation angles = robot.imu.getAngularOrientation();
        double heading = angles.firstAngle;
        move(forward,(bearing-heading)*0.02);
    }

    // gyro time
    public void moveGT(double forward, double bearing, double sec) {
        ElapsedTime timer = new ElapsedTime();
        timer.reset();
        while (opModeIsActive()) {
            if (timer.seconds() > sec) break;
            moveGyro(forward, bearing);
        }
    }
}
