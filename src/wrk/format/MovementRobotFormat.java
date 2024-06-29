/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wrk.format;

/**
 *
 * @author 5ampa
 */
public class MovementRobotFormat {

    /**
     * Checks if a given sequence of movement commands adheres to the expected format.
     * Valid commands include 'L', 'R', and 'F'.
     * 
     * @param commands The string containing the movement commands to be validated.
     * @return true if all characters in the command string are 'L', 'R', or 'F'; false otherwise.
     */
    public boolean checkMovementRobotFormat(String commands) {
        int movementSize = commands.length();

        for (int i = 0; i < movementSize; i++) {
            char move = commands.charAt(i);

            // Check if move is not 'L', 'R', or 'F'
            if (!(move == 'L' || move == 'R' || move == 'F')) {
                return false; //instant
            }
        }

        return true;
    }

}
