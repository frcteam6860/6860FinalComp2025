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

public class Intake extends SubsystemBase {
    private final PWMSparkMax IntakeMotor;
    private final DigitalInput IntakeLimitL;
    private final DigitalInput IntakeLimitR;
    
    /** Creates a new Intake. */
    public Intake() {
        IntakeMotor = new PWMSparkMax(EE_MOTORS.MOTOR_PORT_INTAKE);
        IntakeLimitL = new DigitalInput(LIMIT_SWITCHES.INTAKE_LIMIT_PORT_L);
        IntakeLimitR = new DigitalInput(LIMIT_SWITCHES.INTAKE_LIMIT_PORT_R);
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
    public boolean intakeNotClear() {
        // Query some boolean state, such as a digital sensor.
        System.out.println("Intake Not Clear? " + "Left: " + (!IntakeLimitL.get() + "  Right: " + !IntakeLimitR.get()));
        return !IntakeLimitL.get() || !IntakeLimitR.get();
    }

    public void intake(double speed) {
        IntakeMotor.set(0.95 * speed);
    }

    public void outtake(double speed) {
        IntakeMotor.set(-0.95 * speed);
    }

    public void outtakeAlign() {
        if(intakeNotClear()) {
            outtake(0.28);
        } else {
            stopIntakeMotor();
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void stopIntakeMotor() {
        IntakeMotor.set(0);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
