// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.OI.XBController;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ElevatorCom extends Command {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final Elevator elevator;
    private final XBController controller;

    /**
     * Creates a new Elevator Commands.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ElevatorCom(Elevator elevator, XBController controller) {
        this.elevator = elevator;
        this.controller = controller;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(this.elevator);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (controller.getRightBumper())  {
            //System.out.println("Going Up!");
            elevator.goUp();
        } else if (controller.getLeftBumper()) {
            //System.out.println("Back Down!");
            elevator.goDown();
        } else {
            //System.out.println("Elevator Stop");
            elevator.stopElevator();
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
