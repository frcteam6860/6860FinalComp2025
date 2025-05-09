// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.AutoTimer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
    /** Example static factory for an autonomous command. */
    public static Command exampleAuto(ExampleSubsystem subsystem) {
        return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
    }

    public static Command driveForwardAuto(Drivetrain drivetrain, AutoTimer timer, Intake intake) {
        return Commands.sequence(new DriveForwardAuto(drivetrain, timer));
    }  
    
    public static Command IntakeScoreAuto(Drivetrain drivetrain, AutoTimer timer, Intake intake) {
        return Commands.sequence(new IntakeScoreAuto(drivetrain, timer, intake));
}

    private Autos() {
        throw new UnsupportedOperationException("This is a utility class!");
    }
}
