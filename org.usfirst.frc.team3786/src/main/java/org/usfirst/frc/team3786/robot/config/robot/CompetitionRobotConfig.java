package org.usfirst.frc.team3786.robot.config.robot;

/**
 * This Class inherits the abstract method from RobotConfig and provides
 * implementations.
 * NOTE: Multiple version of the robot can be created this way.
 * Just point the instance of RobotConfig to the file you want to use for robot config
 * @author Manpreet Singh 2016
 */
public class CompetitionRobotConfig extends RobotConfig{
	//***************START***************
	
	//Drive Motors - PWM Channels
	private static final int LEFT_DRIVE_MOTOR = 0;
	private static final int RIGHT_DRIVE_MOTOR = 1;
	
	//Drive PID
	private static final double DRIVE_P = 0;
	private static final double DRIVE_I = 0;
	private static final double DRIVE_D = 0;
	private static final int ENCODER_CODES_PER_REVOLUTION = 180;
	
	//Shooter Mechanisms
	private static final int SHOOTER_FLY_WHEEL = 2;
	
	private static final int RELEASE_MECH_LEFT = 3;
	private static final int RELEASE_MECH_RIGHT = 4;
	
	private static final int BALL_ENGAGEMENT = 0;
	
	private static final int ELEVATION_MOTOR = 18;
	
	private static final int ELEVATION_LIMIT_TOP = 0;
	private static final int ELEVATION_LIMIT_BOTTOM = 0;
	
	//Shooter PID
	private static final double SHOOTER_P_DEF = 400;
	private static final double SHOOTER_I_DEF = 0;
	private static final double SHOOTER_D_DEF = 150;
	
	private static final double SHOOTER_P_UP = 700;
	private static final double SHOOTER_P_DOWN = 500;
	
	private static final double SHOOTER_I_UP = 0;
	private static final double SHOOTER_I_DOWN = 0;
	
	private static final double SHOOTER_D_UP = SHOOTER_P_UP/4;
	private static final double SHOOTER_D_DOWN = SHOOTER_P_DOWN/2;
	
	//Lifter Mechanisms
	private static final int LIFT_ONE = 0;
	private static final int LIFT_TWO = 0;
	
	//****************END****************
	
	@Override
	public double getDRIVE_P() {
		return DRIVE_P;
	}
	
	@Override
	public double getDRIVE_I() {
		return DRIVE_I;
	}
	
	@Override
	public double getDRIVE_D() {
		return DRIVE_D;
	}
	
	@Override
	public double getSHOOTER_P() {
		return SHOOTER_P_DEF;
	}
	
	@Override
	public double getSHOOTER_I() {
		return SHOOTER_I_DEF;
	}
	
	@Override
	public double getSHOOTER_D() {
		return SHOOTER_D_DEF;
	}
	
	@Override
	public int getCODES_PER_REV() {
		return ENCODER_CODES_PER_REVOLUTION;
	}
		
	@Override
	public int getLeftDriveMotor() {
		return LEFT_DRIVE_MOTOR;
	}

	@Override
	public int getRightDriveMotor() {
		return RIGHT_DRIVE_MOTOR;
	}

	@Override
	public int getShooterWheels() {
		return SHOOTER_FLY_WHEEL;
	}

	@Override
	public int releaseServoLeft() {
		return RELEASE_MECH_LEFT;
	}

	@Override
	public int releaseServoRight() {
		return RELEASE_MECH_RIGHT;
	}

	@Override
	public int ballEngagementID() {
		return BALL_ENGAGEMENT;
	}

	@Override
	public int ShooterAimChannel() {
		return ELEVATION_MOTOR;
	}

	@Override
	public int elevatationUpperLimitID() {
		return ELEVATION_LIMIT_TOP;
	}

	@Override
	public int elevatationBottomLimitID() {
		return ELEVATION_LIMIT_BOTTOM;
	}

	@Override
	public int getLiftOneChan() {
		return LIFT_ONE;
	}

	@Override
	public int getLifttwoChan() {
		return LIFT_TWO;
	}

	@Override
	public double getSHOOTER_P_UP() {
		return SHOOTER_P_UP;
	}

	@Override
	public double getSHOOTER_I_UP() {
		return SHOOTER_I_UP;
	}

	@Override
	public double getSHOOTER_D_UP() {
		return SHOOTER_D_UP;
	}

	@Override
	public double getSHOOTER_P_DOWN() {
		return SHOOTER_P_DOWN;
	}

	@Override
	public double getSHOOTER_I_DOWN() {
		return SHOOTER_I_DOWN;
	}

	@Override
	public double getSHOOTER_D_DOWN() {
		return SHOOTER_D_DOWN;
	}	
}
