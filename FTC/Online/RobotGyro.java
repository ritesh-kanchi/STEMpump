package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotGyro {

    public static final double power = 0.85;
    public static final double servoPosition = 0.45;
    public DcMotor leftDrive, rightDrive, armMotor;
    public DigitalChannel touchSensorF, touchSensorB;
    public Servo clawServo;
    public ElapsedTime runtime = new ElapsedTime();

    // GYRO STUFF

    public BNO055IMU imu;

    public RobotGyro() {}

    public void init(HardwareMap hwMap, Telemetry telemetry) {
        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        armMotor = hwMap.get(DcMotor.class, "arm_motor");

        clawServo = hwMap.get(Servo.class, "claw_servo");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        touchSensorF.setMode(DigitalChannel.Mode.INPUT);
        touchSensorB.setMode(DigitalChannel.Mode.INPUT);

        // GYRO STUFF

        BNO055IMU.Parameters params = new BNO055IMU.Parameters();
        params.mode = BNO055IMU.SensorMode.IMU;
        params.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        params.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        params.loggingEnabled = false;

        imu = hwMap.get(BNO055IMU.class, "imu");

        imu.initialize(params);


        telemetry.addLine("Robot Ready");
        telemetry.update();
    }

    public boolean isTouched(DigitalChannel touchSensor) {
        if (touchSensor.getState()) {
            return true;
        } else {
            return false;
        }
    }

    public double modPower(double inPow) {
        double modPower = inPow*0.85;
        return modPower;

        // return power*0.85;
    }

    public void setEncoders() {
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
