package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * UIConfig is where we declare abstract methods for different button
 * We then call these methods from main file and bind commands to them
 * @author Manpreet Singh 2016
 */
public abstract class UIConfig {
	private static UIConfig instance;
		
	public static UIConfig getInstance() {
		if(instance == null){
			instance = new TankDriveWithXboxControl();
		}
		return instance;
	}
	
	
	//Throttles for the Left and Right side
	public abstract double getLeftStickY();
	public abstract double getRightStickX();
	
}
