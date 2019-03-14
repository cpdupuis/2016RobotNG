package org.usfirst.frc.team3786.robot.commands.shooting;

import org.usfirst.frc.team3786.robot.subsystems.ReleaseMechanism;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Class/Command to release the ball from the shooter
 * @author Manpreet Singh 2016
 */
public class ReleaseBall extends Command{
	
	public ReleaseBall() {
		requires(ReleaseMechanism.getInstance());
		System.out.println("Release Ball Initialized");
	}
	
	@Override
	protected void initialize() {
		ReleaseMechanism.getInstance().extend();
		System.out.println("Shooting Ball");
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		ReleaseMechanism.getInstance().retract();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
