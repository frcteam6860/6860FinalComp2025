// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.EE_MOTORS;
import frc.robot.Constants.LIMIT_SWITCHES;

public class Elevator extends SubsystemBase {
    private final PWMSparkMax ElevatorMotor;
    private final DigitalInput UpperLimit;
    private final DigitalInput LowerLimit;
    private final Intake Intake;

    /** Creates a new Elevator. */
    public Elevator(Intake Intake) {
       ElevatorMotor = new PWMSparkMax(EE_MOTORS.MOTOR_PORT_ELEVATOR);
       UpperLimit = new DigitalInput(LIMIT_SWITCHES.UPPER_LIMIT_PORT);
       LowerLimit = new DigitalInput(LIMIT_SWITCHES.LOWER_LIMIT_PORT);
       this.Intake = Intake;
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
    public boolean atUpperLimit() {
        return !UpperLimit.get();
    }

    /**
     * An example method querying a boolean state of the subsystem (for example, a
     * digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
    public boolean atLowerLimit() {
        return !LowerLimit.get();
    }

    public void goUp() {
        if (atUpperLimit() || Intake.intakeNotClear()) {
            stopElevator();
        } else {
            ElevatorMotor.set(0.5);
        }
    }

    public void goDown() {
        if (atLowerLimit() || Intake.intakeNotClear()) {
            stopElevator();
        } else {
            ElevatorMotor.set(-0.5);
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void stopElevator() {
        ElevatorMotor.set(0);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
