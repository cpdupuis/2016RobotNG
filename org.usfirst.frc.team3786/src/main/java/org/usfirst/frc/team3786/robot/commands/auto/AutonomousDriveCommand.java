package org.usfirst.frc.team3786.robot.commands.auto;

import org.usfirst.frc.team3786.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Class/Command to control the Drive Train during autonomous
 * @author Manpreet Singh 2016
 */
public class AutonomousDriveCommand extends Command{
	
	private static final double DEFAULT_DRIVE_SPEED = 0.75;
	private static final double DEFAULT_TURN_SPEED = 0.2;
	
	private double leftTurnSpeed;
	private double rightTurnSpeed;
	
	private double leftDriveSpeed;
	private double rightDriveSpeed;
		
	public enum Direction { Forwards, Backwards , Left, Right}
	
	private Direction desiredDirection;
	
	public AutonomousDriveCommand(Direction direction) {
		 this.desiredDirection = direction;
		 
		 this.leftDriveSpeed = DEFAULT_DRIVE_SPEED;
		 this.rightDriveSpeed = -DEFAULT_DRIVE_SPEED;
		 
		 this.leftTurnSpeed = DEFAULT_TURN_SPEED;
		 this.rightTurnSpeed = -DEFAULT_TURN_SPEED;
		 
		 requires(DriveTrain.getInstance());
	}
	
	public AutonomousDriveCommand(Direction direction, double driveSpeed) {
		this.desiredDirection = direction;
		
		this.leftDriveSpeed = driveSpeed;
		this.rightDriveSpeed = -driveSpeed;
		
		this.leftTurnSpeed = DEFAULT_TURN_SPEED;
		this.rightTurnSpeed = -DEFAULT_TURN_SPEED;
		
		requires(DriveTrain.getInstance());
	}
	
	public AutonomousDriveCommand(Direction direction, double driveSpeed, double turnSpeed) {
		this.desiredDirection = direction;
		
		this.leftDriveSpeed = driveSpeed;
		this.rightDriveSpeed = -driveSpeed;
		
		this.leftTurnSpeed = turnSpeed;
		this.rightTurnSpeed = -turnSpeed;
		
		requires(DriveTrain.getInstance());
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		switch(desiredDirection) {
		case Forwards:
			DriveTrain.getInstance().drive(leftDriveSpeed, rightDriveSpeed);
			break;
		case Backwards:
			DriveTrain.getInstance().drive(-leftDriveSpeed, -rightDriveSpeed);
			break;
		case Left:
			DriveTrain.getInstance().drive(-leftTurnSpeed, rightTurnSpeed);
			break;
		case Right:
			DriveTrain.getInstance().drive(leftTurnSpeed, -rightTurnSpeed);
			break;
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		DriveTrain.getInstance().STOP();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
}
