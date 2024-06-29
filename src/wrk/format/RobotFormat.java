package wrk.format;

import beans.Room;

public class RobotFormat {

    /**
     * Checks if the given robot configuration string conforms to the expected
     * format.
     *
     * @param robotSizeStr The string representing the robot's initial
     * configuration (length, width, and orientation).
     * @param room The room object used to validate the robot's dimensions
     * against the room's dimensions.
     * @return true if the robot configuration string is in the correct format
     * and dimensions are valid; false otherwise.
     */
    public boolean checkRobotFormat(String robotSizeStr, Room room) {
        boolean result = false;

        if (checkRoom2digitAndNumber(robotSizeStr, room)) {
            result = true;
        }

        return result;
    }

    /**
     * Private helper method to check if the robot configuration string consists
     * of two digits for dimensions and a valid orientation character ('N', 'S',
     * 'E', 'W').
     *
     * @param robotSizeStr The robot configuration string to be validated.
     * @param room The room object used to validate the robot's dimensions
     * against the room's dimensions.
     * @return true if the robot configuration string is in the correct format
     * and dimensions are valid; false otherwise.
     */
    private static boolean checkRoom2digitAndNumber(String robotSizeStr, Room room) {
        boolean result = false;
        if (robotSizeStr.length() == 3) {
            try {
                //34N

                int width = Integer.parseInt(robotSizeStr.substring(0, 1));
                int length = Integer.parseInt(robotSizeStr.substring(1, 2));

                char orientation = robotSizeStr.charAt(2);

                if (length >= 0 && length <= room.getLength()&& width >= 0 && width <= room.getWidth()) {
                    if (orientation == 'N' || orientation == 'S' || orientation == 'E' || orientation == 'W') {
                        result = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("error :" + e.getMessage());
            }
        }

        return result;
    }
}
