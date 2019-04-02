package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3786.robot.commands.drive.NeoBoostCommand;
import org.usfirst.frc.team3786.robot.commands.drive.NeoBrakeCommand;
import org.usfirst.frc.team3786.robot.commands.drive.NeoSlowTurnCommand;

/**
 *  Tank Drive with an Xbox Controller for Shooter Control
 * @author Manpreet Singh 2016
 */
public class TankDriveWithXboxControl extends UIConfig{
	
	//private static final double reductionFactor = 0.85;
	private static XboxController primaryController = null;;
	private static XboxController secondaryController = null;
	
	public static XboxController getPrimaryController() {
		if (primaryController == null) {
			primaryController = new XboxController(0);
			primaryController.buttonBumperRight.whileHeld(new NeoBoostCommand());
			primaryController.buttonBumperLeft.whileHeld(new NeoSlowTurnCommand());
			//primaryController.buttonX.whileHeld(new NeoBrakeCommand());
		}
		return primaryController;
	}

	public static XboxController getSecondaryController() {
		if (secondaryController == null)
			secondaryController = new XboxController(1);
		return secondaryController;
	}

	public TankDriveWithXboxControl() {		
	}
	
	@Override
	public double getLeftStickY() {
		double drive = getPrimaryController().getLeftStickY();
		return -drive;
	}

	@Override
	public double getRightStickX() {
		double drive = getPrimaryController().getRightStickX();
		return drive;
	}
	
}
