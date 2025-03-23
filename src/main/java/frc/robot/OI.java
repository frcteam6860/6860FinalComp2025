// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OPERATOR_CONSTANTS;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class OI {
    // look how xbox controller is init. in old code
    // private final XboxController controller;

    public OI() {}

    public static final class XBController {
        private final XboxController controller;

        public XBController(int port) {
            controller = new XboxController(port);
        }

        public double getLeftTriggerAxis() {
            return controller.getLeftTriggerAxis();
        }

        public double getRightTriggerAxis() {
            return controller.getRightTriggerAxis();
        }

        public boolean getA() {
            return controller.getAButton();
        }

        public boolean getB() {
            return controller.getBButton();
        }

        public boolean getX() {
            return controller.getXButton();
        }

        public boolean getY() {
            return controller.getYButton();
        }

        public boolean getLeftBumper() {
            return controller.getLeftBumper();
        }

        public boolean getRightBumper() {
            return controller.getRightBumper();
        }

        public double getLeftJoyY() {
            return -controller.getLeftY();
        }

        public double getLeftJoyYScaled() {
            return (-controller.getLeftY() / Math.abs(-controller.getLeftY()))
                     * Math.sqrt((Math.abs(Math.pow(-controller.getLeftY(), OPERATOR_CONSTANTS.DIRECTION_DIST_SCALE_STRENGTH)) * Math.pow(controller.getLeftX(), 2)
                     + Math.pow(-controller.getLeftY(), 2)));
        }

        public double getLeftJoyX() {
            return controller.getLeftX();
        }

        public double getLeftJoyXScaled() {
            return (controller.getLeftX() / Math.abs(controller.getLeftX()))
                     * Math.sqrt((Math.abs(Math.pow(controller.getLeftX(), OPERATOR_CONSTANTS.DIRECTION_DIST_SCALE_STRENGTH)) * Math.pow(-controller.getLeftY(), 2)
                     + Math.pow(controller.getLeftX(), 2)));
        }

        public double getRightJoyY() {
            return controller.getRightY();
        }

        public double getRightJoyYScaled() {
            return (controller.getRightY() / Math.abs(controller.getRightY()))
                     * Math.sqrt((Math.abs(Math.pow(controller.getRightY(), OPERATOR_CONSTANTS.DIRECTION_DIST_SCALE_STRENGTH)) * Math.pow(controller.getRightX(), 2)
                     + Math.pow(controller.getRightY(), 2)));
        }

        public double getRightJoyX() {
            return controller.getRightX();
        }

        public double getRightJoyXScaled() {
            return (controller.getRightX() / Math.abs(controller.getRightX()))
                     * Math.sqrt((Math.abs(Math.pow(controller.getRightX(), OPERATOR_CONSTANTS.DIRECTION_DIST_SCALE_STRENGTH)) * Math.pow(controller.getRightY(), 2)
                     + Math.pow(controller.getRightX(), 2)));
        }

        public int getDPadAngle() {
            return controller.getPOV();
        }

        public boolean getStartButton() {
            return controller.getStartButton();
        }

        public boolean getBackButton() {
            return controller.getBackButton();
        }
    }
}
