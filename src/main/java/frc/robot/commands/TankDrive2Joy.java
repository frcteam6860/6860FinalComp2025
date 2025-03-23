// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.OI.XBController;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class TankDrive2Joy extends Command {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final Drivetrain drivetrain;
    private final XBController controller;

    /**
     * Creates the new TankDrive2Joy.
     * 
     * @param drivetrain The drivetrain of the robot.
     * @param controller The Xbox controller used to operate the robot.
     */
    public TankDrive2Joy(Drivetrain drivetrain, XBController controller) {
        this.drivetrain = drivetrain;
        this.controller = controller;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(this.drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        /* Initialize left side speed based on left joystick Y axis (normalized with scaled X axis) with deadband 0.1 */
        double leftSpeed = controller.getLeftJoyYScaled();
        if (Math.abs(leftSpeed) < 0.1)
            leftSpeed = 0;

        /* Initialize right side speed based on right joystick Y axis (normalized with scaled X axis) with deadband 0.1 */
        double rightSpeed = controller.getRightJoyYScaled();
        if (Math.abs(rightSpeed) < 0.1)
            rightSpeed = 0;


        /* Execute tank drive based on above read input values, unless within deadband (at which point, stop moving) */
        if (Math.abs(leftSpeed) > 0.1 || Math.abs(rightSpeed) > 0.1) {
            drivetrain.tankDrive(leftSpeed, rightSpeed);
        } else {
            drivetrain.stop();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
