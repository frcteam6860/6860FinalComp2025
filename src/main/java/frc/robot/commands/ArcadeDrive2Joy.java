// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.OI.XBController;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ArcadeDrive2Joy extends Command {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final Drivetrain drivetrain;
    private final XBController controller;

    /**
     * Creates the new ArcadeDrive2Joy.
     * 
     * @param drivetrain The drivetrain of the robot.
     * @param controller The Xbox controller used to operate the robot.
     */
    public ArcadeDrive2Joy(Drivetrain drivetrain, XBController controller) {
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
        /* Initialize forward/back movement speed based on left joystick Y axis (normalized with scaled X axis) with deadband 0.1 */
        double moveSpeed = controller.getLeftJoyYScaled();
        if (Math.abs(moveSpeed) < 0.1)
            moveSpeed = 0;

        /* Initialize rotation speed based on right joystick X axis (normalized with scaled Y axis) with deadband 0.1 */
        double rotSpeed = controller.getRightJoyXScaled();
        if (Math.abs(rotSpeed) < 0.1)
            rotSpeed = 0;


        /* Execute arcade drive based on above read input values, unless within deadband (at which point, stop moving) */
        if (Math.abs(moveSpeed) > 0.1 || Math.abs(rotSpeed) > 0.1) {
            drivetrain.arcadeDrive(moveSpeed, rotSpeed);
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
