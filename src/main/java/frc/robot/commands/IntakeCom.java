// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.OI.XBController;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class IntakeCom extends Command {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final Intake intake;
    private final XBController controller;

    /**
     * Creates a new Intake Command.
     *
     * @param subsystem The subsystem used by this command.
     */
    public IntakeCom(Intake intake, XBController controller) {
        this.intake = intake;
        this.controller = controller;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(this.intake);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (controller.getDPadAngle() == 0) {
            intake.outtakeAlign();
        } else if (controller.getLeftTriggerAxis() > 0.1) {
            intake.intake(Math.pow(controller.getLeftTriggerAxis(), 2));
        } else if(controller.getRightTriggerAxis() > 0.1) {
            intake.outtake(Math.pow(controller.getRightTriggerAxis(), 2));
        } else { 
            intake.stopIntakeMotor();
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
