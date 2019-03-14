
package org.usfirst.frc.team3786.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3786.robot.config.ui.UIConfig;
import org.usfirst.frc.team3786.robot.subsystems.DriveTrain;

/**
 * Class/Command to Control the drive train of the robot
 * @author Manpreet Singh 2016
 */
public class Drive extends Command {

    public Drive() {
        // Use requires() here to declare subsystem dependencies
        requires(DriveTrain.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriveTrain.getInstance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriveTrain.getInstance().drive(UIConfig.getInstance().getLeftStickY(), UIConfig.getInstance().getRightStickX());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	DriveTrain.getInstance().STOP();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
