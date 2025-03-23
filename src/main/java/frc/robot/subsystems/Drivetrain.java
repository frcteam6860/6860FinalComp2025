// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DRIVE_MOTORS;

public class Drivetrain extends SubsystemBase {
    private final PWMSparkMax FrontLeftMotor;
    private final PWMSparkMax FrontRightMotor;
    private final PWMSparkMax BackLeftMotor;
    private final PWMSparkMax BackRightMotor;
    private final DifferentialDrive driveTrain;

    /** Creates a new Drivetrain. */
    public Drivetrain() {
        FrontLeftMotor = new PWMSparkMax(DRIVE_MOTORS.MOTOR_PORT_FRONT_LEFT);
        FrontRightMotor = new PWMSparkMax(DRIVE_MOTORS.MOTOR_PORT_FRONT_RIGHT);
        BackLeftMotor = new PWMSparkMax(DRIVE_MOTORS.MOTOR_PORT_BACK_LEFT);
        BackRightMotor = new PWMSparkMax(DRIVE_MOTORS.MOTOR_PORT_BACK_RIGHT);

        /* Pairs commands sent to front and back motors on each side */
        FrontLeftMotor.addFollower(BackLeftMotor);
        FrontRightMotor.addFollower(BackRightMotor);

        driveTrain = new DifferentialDrive(FrontLeftMotor, FrontRightMotor);
    }

    public void driveForward () {
        driveTrain.arcadeDrive(0, 0.6);
    }

    public void tankDrive(double speedL, double speedR) {
        driveTrain.tankDrive(-speedL, speedR);
    }

    public double getFrontLeftMotor(){
        return FrontLeftMotor.get();
    }

    public double getFrontRightMotor(){
        return FrontRightMotor.get();
    }
    public double getBackLeftMotor(){
        return BackLeftMotor.get();
    }
    public double getBackRightMotor(){
        return BackRightMotor.get();
    }

    public void getReadings(){
        
        SmartDashboard.putString("DB/String 1", "Front Left Motor Value: " + String.valueOf(getFrontLeftMotor()));
        SmartDashboard.putString("DB/String 2", "Front Right Motor Value: " + String.valueOf(getFrontRightMotor()));
        SmartDashboard.putString("DB/String 3", "Back Left Motor Value: " + String.valueOf(getBackLeftMotor()));
        SmartDashboard.putString("DB/String 4", "Back Right Motor Value: " + String.valueOf(getBackRightMotor()));

    }

    /**
     * Yes rotational speed and movement speed are swapped and rotSpeed is then negated.
     * No we don't know why this is the only way it works.
     * But if we don't do this everything breaks.
     * Blame Jimmy for backwards wiring I guess???????
     */
    public void arcadeDrive(double moveSpeed, double rotSpeed) {
        driveTrain.arcadeDrive(-rotSpeed, moveSpeed);
    }

    public void stop() {
        driveTrain.stopMotor();
    }

    /**
     * Example command factory method.
     *
     * @return a command
     */
    public Command exampleMethodCommand() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
                () -> {
                    /* one-time action goes here */
                });
    }

    /**
     * An example method querying a boolean state of the subsystem (for example, a
     * digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
    public boolean exampleCondition() {
        // Query some boolean state, such as a digital sensor.
        return false;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
