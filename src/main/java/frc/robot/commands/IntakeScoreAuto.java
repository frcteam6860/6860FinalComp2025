// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.commands;


import frc.robot.subsystems.AutoTimer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;


/** An example command that uses an example subsystem. */


public class IntakeScoreAuto extends Command {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final Drivetrain drivetrain;
    private final AutoTimer timer;
    private final Intake intake;


    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public IntakeScoreAuto(Drivetrain drivetrain, AutoTimer timer, Intake intake) {
        this.drivetrain = drivetrain;
        this.timer = timer;
        this.intake = intake;


        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(this.intake);
        addRequirements(this.drivetrain);
    }


    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (timer.getTime() < 4) {
            drivetrain.driveForward();
        }
          else if (timer.getTime() < 7 && timer.getTime() > 4){
            intake.outtake(.75);
            drivetrain.stop();
        } else {
            timer.stop();
            intake.intake(0);
            end(false);
        }
        drivetrain.getReadings();

    }


    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
        timer.stop();
    }


    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
