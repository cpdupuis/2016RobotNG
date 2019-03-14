package org.usfirst.frc.team3786.robot.subsystems;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Made up never used subsystem to control the entire shooter
 * This might've been a better way to code the shooter
 * @author Nate Chapman and Manpreet Singh 2016
 */
public class NewShooter extends Subsystem {
		
	/* These are our sensors and actuators */
	private Talon flywheels;
	private Servo[] releaseServo = new Servo[2];
	private DigitalInput haveBall;
	
	//This is our "constructor"
	private static NewShooter globalInstance;
	public static NewShooter getInstance() {
		if(globalInstance == null)
			globalInstance = new NewShooter();
		return globalInstance;
	}
	
	public NewShooter() {
		flywheels = new Talon(RobotConfig.getInstance().getShooterWheels());
		releaseServo[0] = new Servo(RobotConfig.getInstance().releaseServoLeft());
		releaseServo[1] = new Servo(RobotConfig.getInstance().releaseServoRight());
		haveBall = new DigitalInput(RobotConfig.getInstance().ballEngagementID());
		triggerButton = new TriggerButtonCmd();
		loadButton = new LoadButtonCmd();
	}
	
	//These are our internal constants and enums
	private static final double SHOOT_SPEED = -0.75;
	private static final double INTAKE_SPEED = 0.15;
	
	protected enum _States {
		IDLE, LOADING, LOADED, SPINUP, FIRE
	}
	private _States _state;
	
	//these are our command objects
	public Command triggerButton;
	public Command loadButton;
	
	//This class gives us a command object to handle our load/spinup button
	private class LoadButtonCmd extends Command{
		private boolean isPressed;
		public LoadButtonCmd() {
			requires(NewShooter.getInstance());
			this.isPressed = false;
		}

		//Button is pressed
		protected void initialize() {
			if (_state == _States.IDLE) {
				//set motors to loading
				flywheels.set(INTAKE_SPEED);
				_state = _States.LOADING;
			} else if (_state == _States.LOADED) {
				//spin up motors for Low Goal
				flywheels.set(-INTAKE_SPEED);
				extend();
				_state = _States.IDLE;
			}
			isPressed = true;
		}

		//Button is released
		protected void interrupted() { end(); }
		protected void end() {
			if (_state == _States.LOADING) {
				_state = _States.IDLE;
			}
			flywheels.set(0); //set motors to off
			retract();
			isPressed = false;
		}

		/* Overrided methods */
		protected void execute() {
			if(_state == _States.LOADING) {
				if(!haveBall.get()){ //ball is detected
					_state = _States.LOADED;
					end();
				}
			}
		}
		protected boolean isFinished() { return isPressed; }

	}
	
	//This class gives us a command object to handle our fire button
	private class TriggerButtonCmd extends Command{
		
		public TriggerButtonCmd() {
			requires(NewShooter.getInstance());
		}
		
		//button is pressed
		protected void initialize() {
			if(_state == _States.LOADED) {
				_state = _States.SPINUP;
				flywheels.set(SHOOT_SPEED);
			}
		}
		
		//button is released
		protected void interrupted() { end(); }
		protected void end() {
			retract();
			if(_state == _States.FIRE) {
				retract();
				_state = _States.IDLE;
			} else if (_state == _States.SPINUP) { //did not shoot, abort!
				_state = _States.LOADED;
				flywheels.set(0);
			}
		}

		protected void execute() {
			if(_state == _States.SPINUP){
				Timer.delay(1);
				extend();
				_state = _States.FIRE;
			}	
		}
		
		//unused overrides
		protected boolean isFinished() { return false; }
		
	}
	
	private class StopCmd extends Command {
		public StopCmd() {
			requires(NewShooter.getInstance());
		}
		
		protected void initialize() {
			flywheels.set(0);
			retract();
		}

		protected void execute() {}
		protected void end() {}
		protected void interrupted() {}
		protected boolean isFinished() {
			return false;
		}
	}
	
	
	/**
	 * Retract the release mechanism
	 */
	private void retract() {
		releaseServo[0].set(0);
		releaseServo[1].set(180);
	}
	
	/**
	 * Extend the release mechanism
	 */
	private void extend() {
		releaseServo[0].set(20);
		releaseServo[1].set(0);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new StopCmd());
	}

}
