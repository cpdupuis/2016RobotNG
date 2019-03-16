
package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.drive.NeoDriveCommand;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;
import org.usfirst.frc.team3786.robot.utils.Gyroscope;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This Class holds methods to control the drive train
 * @author Manpreet Singh 2016
 */
public class DriveTrain extends Subsystem {
    	
	private static DriveTrain instance;
	
	private Jaguar leftMotor, rightMotor;
	private DifferentialDrive differentialDrive;

	public DriveTrain() {
		
		leftMotor = new Jaguar(RobotConfig.getInstance().getLeftDriveMotor());
		
		rightMotor = new Jaguar(RobotConfig.getInstance().getRightDriveMotor());
		differentialDrive = new DifferentialDrive(leftMotor, rightMotor);

	}
	public void gyroStraight(double spd, double tgtHeading) {
		double currHeading = Gyroscope.getInstance().getHeadingContinuous();
		double error = tgtHeading - currHeading;
		double correction = error / 90;
		arcadeDrive(spd, correction);
	}
	
	public static DriveTrain getInstance() {
		if(instance == null)
			instance = new DriveTrain();
		return instance;
	}
	
	public void arcadeDrive(double speed, double turn) {
		differentialDrive.arcadeDrive(speed, turn);

	}
		
	/**
	 * Stop the robot
	 */
	public void STOP() {
		leftMotor.set(0);
		rightMotor.set(0);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(NeoDriveCommand.getInstance());
    }
}

