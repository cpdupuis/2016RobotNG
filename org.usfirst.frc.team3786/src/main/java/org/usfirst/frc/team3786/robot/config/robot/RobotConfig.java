package org.usfirst.frc.team3786.robot.config.robot;
/**
 * The RobotConfig is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * @author Manpreet Singh 2016
 */
public abstract class RobotConfig {
	
	private static RobotConfig instance;
	
	// Point this to the config file you want to use
	public static RobotConfig getInstance() {
		if(instance == null)
			instance = new CompetitionRobotConfig();
		return instance;
	}
	
	//***************Drive PID Values***************
	public abstract double getDRIVE_P();
	public abstract double getDRIVE_I();
	public abstract double getDRIVE_D();
	public abstract int getCODES_PER_REV();
	
	//************Shooter AIM PID Values************
	public abstract double getSHOOTER_P();
	public abstract double getSHOOTER_I();
	public abstract double getSHOOTER_D();
	
	public abstract double getSHOOTER_P_UP();
	public abstract double getSHOOTER_I_UP();
	public abstract double getSHOOTER_D_UP();
	
	public abstract double getSHOOTER_P_DOWN();
	public abstract double getSHOOTER_I_DOWN();
	public abstract double getSHOOTER_D_DOWN();
	
	//************Motor Channels and IDS************
	
	//------------Drive Motor IDs------------
	public abstract int getLeftDriveMotor();
	
	public abstract int getRightDriveMotor();
	
	
	//-------Shooter Mechanism Channels-------
	public abstract int getShooterWheels();
		
	public abstract int releaseServoLeft();
	public abstract int releaseServoRight();
	
	public abstract int ballEngagementID();
	
	//------Shooter Elevation Mechanisms------
	public abstract int ShooterAimChannel();
	
	public abstract int elevatationUpperLimitID();
	public abstract int elevatationBottomLimitID();
	
	//-------------Lift Mechanism-------------
	public abstract int getLiftOneChan();
	public abstract int getLifttwoChan();
	
}
