// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
public final class Constants {
    /* Drive Motor Controller Ports */
    public static final class DRIVE_MOTORS {
        public static final int MOTOR_PORT_FRONT_LEFT = 6;
        public static final int MOTOR_PORT_FRONT_RIGHT = 9;
        public static final int MOTOR_PORT_BACK_LEFT = 7;
        public static final int MOTOR_PORT_BACK_RIGHT = 8;
    }

    /* End Effector Motor Controller Ports */
    public static final class EE_MOTORS {
        public static final int MOTOR_PORT_ELEVATOR = 5;
        public static final int MOTOR_PORT_INTAKE = 3;
        // public static final int MOTOR_PORT_OUTTAKE = 1;
    }

    /* Elevator Limit Switch Ports */
    public static final class LIMIT_SWITCHES {
        public static final int UPPER_LIMIT_PORT = 2;
        public static final int LOWER_LIMIT_PORT = 0;
        public static final int INTAKE_LIMIT_PORT_R = 3;
        public static final int INTAKE_LIMIT_PORT_L = 1;
    }

    public static final class OPERATOR_CONSTANTS {
        public static final int XBOX_PORT = 0;
        /* Value >= 0; inversely scales effect strength of directional distance scaling on joystick inputs. */
        public static final double DIRECTION_DIST_SCALE_STRENGTH = 1.6;
    }
}


