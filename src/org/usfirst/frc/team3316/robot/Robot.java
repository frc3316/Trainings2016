
package org.usfirst.frc.team3316.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
	
    private Joystick Lefty,Righty;
    private double lft,ryt;
    private SpeedController lftbaka, lftfrt, rytbaka, rytfrt;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	Lefty = new Joystick(0);
    	Righty = new Joystick(1);
    	lftbaka = new VictorSP(3);
    	lftfrt = new VictorSP(14);
    	rytfrt = new VictorSP(2);
    	rytfrt = new VictorSP(15);
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        lft = Lefty.getY();
        ryt = Righty.getY();
        rytfrt.set(ryt);
        rytbaka.set(ryt);
        lftfrt.set(-1*lft);
        lftbaka.set(-1*lft);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
