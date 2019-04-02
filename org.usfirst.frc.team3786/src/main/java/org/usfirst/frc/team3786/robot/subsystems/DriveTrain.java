
package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.drive.NeoDriveCommand;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;
import org.usfirst.frc.team3786.robot.utils.Gyroscope;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

	private boolean boost;
	private boolean slowTurn;

	public DriveTrain() {
		
		leftMotor = new Jaguar(RobotConfig.getInstance().getLeftDriveMotor());
		
		rightMotor = new Jaguar(RobotConfig.getInstance().getRightDriveMotor());
		differentialDrive = new DifferentialDrive(leftMotor, rightMotor);

	}
	public void gyroStraight(double spd, double tgtHeading) {
		double currHeading = Gyroscope.getInstance().getHeadingContinuous();
		double error = tgtHeading - currHeading;
		double correction = error / 30;
		if(correction > 1.0) {
			correction = 1.0;
		}
		else if(correction < -1.0) {
			correction = -1.0;
		}
		SmartDashboard.putNumber("Gyro error", error);
		SmartDashboard.putNumber("Gyro correction", correction);
		SmartDashboard.putNumber("Desired Gyro Heading", tgtHeading);
		arcadeDrive(spd, correction);
	}
	
	public static DriveTrain getInstance() {
		if(instance == null)
			instance = new DriveTrain();
		return instance;
	}
	
	public void arcadeDrive(double speed, double turn) {
		if (!this.boost) {
			if (this.slowTurn) {
				speed *= 0.3;
				turn *= 0.3;
			}
			else {
				speed *= 0.6;
				turn *= 0.8;
			}
		}
		differentialDrive.arcadeDrive(speed, turn);

	}

	public void setBoost(boolean boost) {
		this.boost = boost;
	}

	public boolean getBoost() {
		return this.boost;
	}

	public void setSlowTurn(boolean slowTurn) {
		this.slowTurn = slowTurn;
	}

	public boolean getSlowTurn() {
		return this.slowTurn;
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

