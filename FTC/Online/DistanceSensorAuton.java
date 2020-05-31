package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "Distance Sensor")
public class DistanceSensorAuton extends LinearOpMode {
    // Hardware
    DcMotor leftDrive, rightDrive;

    // Sensors
    DistanceSensor distSensor;

    // Objects
    ElapsedTime runtime = new ElapsedTime();

    // Variables
    double power = 0.85;

    @Override
    public void runOpMode() {
        // Hardware Mapping
        leftDrive = hardwareMap.get(DcMotor.class, "left_front");
        rightDrive = hardwareMap.get(DcMotor.class, "right_front");

        distSensor = hardwareMap.get(DistanceSensor.class, "dist_sensor");

        // Set Direction
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // OPTIONAL FOR TOF + ADDITIONAL METHODS
        Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor)distSensor;

        // Wait for  Start
        telemetry.addLine("Robot Ready!");
        telemetry.update();

        waitForStart();

        double distMilli = distSensor.getDistance(DistanceUnit.MM);
        double distCenti = distSensor.getDistance(DistanceUnit.CM);
        double distInches = distSensor.getDistance(DistanceUnit.INCH);
        double distMeter = distSensor.getDistance(DistanceUnit.METER);

        // generic DistanceSensor methods.
        telemetry.addData("deviceName",distSensor.getDeviceName() );
        telemetry.addData("range", String.format("%.01f mm", distMilli));
        telemetry.addData("range", String.format("%.01f cm", distCenti));
        telemetry.addData("range", String.format("%.01f in", distInches));
        telemetry.addData("range", String.format("%.01f m", distMeter));

        // Rev2mDistanceSensor specific methods.
        telemetry.addData("ID", String.format("%x", sensorTimeOfFlight.getModelID()));
        telemetry.addData("did time out", Boolean.toString(sensorTimeOfFlight.didTimeoutOccur()));
        telemetry.update();

        while(distInches > 5) {
            leftDrive.setPower(-0.25);
            rightDrive.setPower(-0.25);
        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);

    }
}
