/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wrk.Manager;

import beans.Robot;

/**
 *
 * @author 5ampa
 */
public class RobotManager {

    /**
     * Creates a new Robot object based on a string representation. The string
     * format should be "[length,width,facing]", e.g., "23N".
     *
     * @param robotStr the string representation of the Robot.
     * @return a new Robot object initialized with the provided parameters
     */
    
    // 21S, 11N
    public Robot createRobot(String robotStr) {
        Robot robot = new Robot();
        
        int width = Integer.parseInt(robotStr.substring(1, 2));
        int length = Integer.parseInt(robotStr.substring(0, 1));
        char facing = robotStr.charAt(2);

        robot.setLenght(length);
        robot.setWidth(width);
        robot.setFacing(facing);
        
        return robot;
    }

}
