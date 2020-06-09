package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

@Autonomous(name = "Skystone Vision", group = "Concept")
// @Disabled
public class SkystoneVision extends LinearOpMode {
  private static final String TFOD_MODEL_ASSET = "Skystone.tflite";
  private static final String LABEL_FIRST_ELEMENT = "Stone";
  private static final String LABEL_SECOND_ELEMENT = "Skystone";

  private static final String VUFORIA_KEY =
      "AfFV3C7/////AAABmU+vc9XL0ksdrJVC+SlEGPCGkBk5vOECLDAqbiTuVKKbsy3O7V5LkM/+Gw9kWABE8P09LTB03kb3JliSEvYspOf8Y+k8Q+nR6mJGy8zJPq10TKdUcNKogeNyPOXoCycqAFXGOWsJ6uCopfAkVKi6pdvuVSiJZVPRsTn85cd1kiag9jKv0TrgLvOz6z7jm2Kkk0vXxzIKa+bLDlUYZ3d9Vxg/fSVJA3XMcOydFWDl29SmpqYGVhiuucntkVnzvjhzOu9Tsk94bm2evB4m3CU/O+38eXXysZKi7TXXq3hIQyaLIlcjG65DJ7/pfngAG1zRR2B6Y/tG/6hPJKwYEkd5LEhc5BEOdEThhoXS15dBMQWR";

  // CREATE STRING POSITION
  String position = "Not found";

  // Create instance of Vuforia Localizer
  private VuforiaLocalizer vuforia;

  // Create instance of TF Object Detection
  private TFObjectDetector tfod;

  @Override
  public void runOpMode() {
    // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
    // first.
    initVuforia();

    if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
      initTfod();
    } else {
      telemetry.addData("Sorry!", "This device is not compatible with TFOD");
    }

    // Activate TF and Vuforia before start
    if (tfod != null) {
      tfod.activate();
    }

    // Game Start
    telemetry.addData(">", "Press Play to start op mode");
    telemetry.update();
    waitForStart();

    if (opModeIsActive()) {
      while (opModeIsActive()) {
        if (tfod != null) {
          // getUpdatedRecognitions() will return null if no new information is available since
          // the last time that call was made.
          List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
          if (updatedRecognitions != null) {
            telemetry.addData("# Object Detected", updatedRecognitions.size());
            // step through the list of recognitions and display boundary info.
            int i = 0;
            for (Recognition recognition : updatedRecognitions) {
              telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
              telemetry.addData(
                  String.format("  left,top (%d)", i),
                  "%.03f , %.03f",
                  recognition.getLeft(),
                  recognition.getTop());
              telemetry.addData(
                  String.format("  right,bottom (%d)", i),
                  "%.03f , %.03f",
                  recognition.getRight(),
                  recognition.getBottom());
              i++;
              if (recognition.getLabel() == LABEL_SECOND_ELEMENT) {
                double midH = (recognition.getLeft() + recognition.getRight()) / 2;

                // You can calculate this in, if you are certain your camera isn't prone to slight
                // vertical movements.
                double midV = (recognition.getTop() + recognition.getBottom()) / 2;

                if (midH <= 225) {
                  position = "Left";
                } else if (225 <= midH && midH < 425) {
                  position = "Center";
                } else if (425 <= midH) {
                  position = "Right";
                }
              }
              telemetry.addData("Skystone Position", position);
            }
            telemetry.update();
          }
        }
      }
    }

    if (tfod != null) {
      tfod.shutdown();
    }
  }

  //    Initalize Vuforia
  private void initVuforia() {
    /*
     * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
     */
    VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

    parameters.vuforiaLicenseKey = VUFORIA_KEY;
    parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

    //  Instantiate the Vuforia engine
    vuforia = ClassFactory.getInstance().createVuforia(parameters);

    // Loading trackables is not necessary for the TensorFlow Object Detection engine.
  }

  // Initalize TF
  private void initTfod() {
    int tfodMonitorViewId =
        hardwareMap
            .appContext
            .getResources()
            .getIdentifier("tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
    TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
    // CONFIDENCE LEVEL
    tfodParameters.minimumConfidence = 0.8;
    tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
    tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
  }
}
