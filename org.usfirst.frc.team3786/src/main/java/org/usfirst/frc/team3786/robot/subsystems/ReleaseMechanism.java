package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Class holds methods to extend and retract the release mechanism
 * @author Manpreet Singh 2016
 */
public class ReleaseMechanism extends Subsystem{
	
	private static boolean isExtended;
	
	private Servo[] releaseServo = new Servo[2];
	private static ReleaseMechanism instance;
		
	public ReleaseMechanism() {
		releaseServo[0] = new Servo(RobotConfig.getInstance().releaseServoLeft());
		releaseServo[1] = new Servo(RobotConfig.getInstance().releaseServoRight());
		
		retract();
	}
	
	public static ReleaseMechanism getInstance() {
		if(instance == null)
			instance = new ReleaseMechanism();
		return instance;
	}
	
	/**
	 * Retract the release mechanism
	 */
	public void retract() {
		releaseServo[0].set(0);
		releaseServo[1].set(1);
		isExtended = false;
	}
	
	/**
	 * Extend the release mechanism
	 */
	public void extend() {
		releaseServo[0].set(.5);
		releaseServo[1].set(.5);
		isExtended = true;
	}
	
	/**
	 * @return True if extended, false if retracted
	 */
	public boolean isExtended() {
		return isExtended;
	}
	
	@Override
	protected void initDefaultCommand() {
	}
}
