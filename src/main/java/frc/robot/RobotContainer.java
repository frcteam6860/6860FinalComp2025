// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OPERATOR_CONSTANTS;
import frc.robot.OI.XBController;
import frc.robot.commands.ArcadeDrive1Joy;
import frc.robot.commands.Autos;
import frc.robot.commands.ElevatorCom;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCom;
import frc.robot.subsystems.AutoTimer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
    private final Drivetrain Drivetrain = new Drivetrain();
    private final Intake intake = new Intake();
    private final Elevator elevator = new Elevator(intake);
    private final AutoTimer timer = new AutoTimer();

    // Replace with CommandPS4Controller or CommandJoystick if needed
    private final XBController XBoxController = new XBController(OPERATOR_CONSTANTS.XBOX_PORT);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the trigger bindings
        configureBindings();
        Drivetrain.setDefaultCommand(new ArcadeDrive1Joy(Drivetrain, XBoxController));
        elevator.setDefaultCommand(new ElevatorCom(elevator, XBoxController));
        intake.setDefaultCommand(new IntakeCom(intake, XBoxController));
    }



    /**
     * Use this method to define your trigger->command mappings. Triggers can be
     * created via the
     * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
     * an arbitrary
     * predicate, or via the named factories in {@link
     * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
     * {@link
     * CommandXboxController
     * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} controllers or
     * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureBindings() {
        // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
        new Trigger(m_exampleSubsystem::exampleCondition)
                .onTrue(new ExampleCommand(m_exampleSubsystem));


        // Schedule `exampleMethodCommand` when the Xbox controller's B button is
        // pressed,
        // cancelling on release.
       
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An example command will be run in autonomous
        //return Autos.driveForwardAuto(Drivetrain, timer, intake);
        return Autos.IntakeScoreAuto(Drivetrain, timer, intake);
    }
    
}
