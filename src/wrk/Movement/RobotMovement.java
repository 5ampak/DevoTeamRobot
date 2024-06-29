package wrk.Movement;

import beans.Robot;
import beans.Room;
import java.util.ArrayList;

public class RobotMovement {

    private int count;
    private Room room;
    private Robot robot;

    public RobotMovement(Room room, Robot robot) {
        this.room = room;
        this.robot = robot;
    }

    public String calcMovement(String robotMovementStr) {
        System.out.println("Move the robot :" + robot.toString());
        System.out.println("Into the room :" + room.toString());
        System.out.println("With these next moves :" + robotMovementStr);

        // Initialisation de la position finale
        String finalPosition = "";

        for (char move : robotMovementStr.toCharArray()) {
            oneMove(move);
            printRobotPosition();
            room.printTab();

            // Mettre à jour la position finale après chaque mouvement
            finalPosition = getCurrentRobotPosition();
        }

        // Retourner la position finale après tous les mouvements
        return finalPosition;
    }

    private String getCurrentRobotPosition() {
        String topLeft = robot.gettopLeft();
        String bottomRight = robot.getbottomRight();
        return "Current position: Top-left = " + topLeft + ", Bottom-right = " + bottomRight;
    }

    void oneMove(char move) {
        switch (move) {
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'F':
                moveForward();
                break;
            default:
                System.out.println("Invalid move");
                break;
        }
    }

    void turnLeft() {
        System.out.println("Turn left");
        char actualFacing = robot.getFacing();
        ArrayList<Character> facingArray = getFacingArray();
        int poseFacingArray = facingArray.indexOf(actualFacing);
        int newFacingInt = (poseFacingArray == 0) ? facingArray.size() - 1 : poseFacingArray - 1;
        char newFacingChar = facingArray.get(newFacingInt);
        robot.setFacing(newFacingChar);
        System.out.println("New facing after turning left: " + newFacingChar);
    }

    void turnRight() {
        System.out.println("Turn right");
        char actualFacing = robot.getFacing();
        ArrayList<Character> facingArray = getFacingArray();
        int poseFacingArray = facingArray.indexOf(actualFacing);
        int newFacingInt = (poseFacingArray == facingArray.size() - 1) ? 0 : poseFacingArray + 1;
        char newFacingChar = facingArray.get(newFacingInt);
        robot.setFacing(newFacingChar);
        System.out.println("New facing after turning right: " + newFacingChar);
    }

    void moveForward() {
        int robotLength = robot.getLenght();
        int robotWidth = robot.getWidth();
        System.out.println("robotLength :" + robotLength);
        System.out.println("robotWidth :" + robotWidth);

        if (count == 0) {
            room.setRobot(robotLength, robotWidth);
            robot.settopLeft("0,0");
            robot.setbottomRight((robotWidth - 1) + "," + (robotLength - 1));
            count++;
        }

        String TopLeft = robot.gettopLeft();
        String BottomRight = robot.getbottomRight();
        System.out.println("TopLeft :" + TopLeft);
        System.out.println("BottomRight :" + BottomRight);

        String[] xParts = TopLeft.split(",");
        String[] yParts = BottomRight.split(",");

        int TopLeftxInt = Integer.parseInt(xParts[0]);
        int TopLeftyInt = Integer.parseInt(xParts[1]);
        int BottomRightxInt = Integer.parseInt(yParts[0]);
        int BottomRightyInt = Integer.parseInt(yParts[1]);
        System.out.println("TopLeftxInt :" + TopLeftxInt);
        System.out.println("TopLeftyInt :" + TopLeftyInt);
        System.out.println("BottomRightxInt :" + BottomRightxInt);
        System.out.println("BottomRightyInt :" + BottomRightyInt);
        char facing = robot.getFacing();

        switch (facing) {
            case 'N':
                moveNorth(TopLeftxInt, TopLeftyInt, BottomRightxInt, BottomRightyInt, robotLength, robotWidth);
                break;
            case 'S':
                moveSouth(TopLeftxInt, TopLeftyInt, BottomRightxInt, BottomRightyInt, robotLength, robotWidth);
                break;
            case 'E':
                moveEast(TopLeftxInt, TopLeftyInt, BottomRightxInt, BottomRightyInt, robotLength, robotWidth);
                break;
            case 'W':
                moveWest(TopLeftxInt, TopLeftyInt, BottomRightxInt, BottomRightyInt, robotLength, robotWidth);
                break;
            default:
                System.out.println("Invalid facing direction");
                break;
        }

        room.printTab();
    }

    void moveNorth(int TopLeftxInt, int TopLeftyInt, int BottomRightxInt, int BottomRightyInt, int robotLength, int robotWidth) {
        if (TopLeftxInt - 1 < 0) {
            System.out.println("Can't move up");
        } else {
            String newTopLeftValue = (TopLeftxInt - 1) + "," + TopLeftyInt;
            String newBottomRightValue = (BottomRightxInt - 1) + "," + BottomRightyInt;
            robot.settopLeft(newTopLeftValue);
            robot.setbottomRight(newBottomRightValue);
            room.resetTab();
            room.setRobotNewPose(newTopLeftValue, newBottomRightValue);
        }
    }

    void moveSouth(int TopLeftxInt, int TopLeftyInt, int BottomRightxInt, int BottomRightyInt, int robotLength, int robotWidth) {
        if (BottomRightxInt + 1 >= room.getLength()) {
            System.out.println("Can't move down");
        } else {
            String newTopLeftValue = (TopLeftxInt + 1) + "," + TopLeftyInt;
            String newBottomRightValue = (BottomRightxInt + 1) + "," + BottomRightyInt;
            robot.settopLeft(newTopLeftValue);
            robot.setbottomRight(newBottomRightValue);
            room.resetTab();
            room.setRobotNewPose(newTopLeftValue, newBottomRightValue);
        }
    }

    void moveEast(int TopLeftxInt, int TopLeftyInt, int BottomRightxInt, int BottomRightyInt, int robotLength, int robotWidth) {
        if (BottomRightyInt + 1 >= room.getWidth()) {
            System.out.println("Can't move right");
        } else {
            String newTopLeftValue = TopLeftxInt + "," + (TopLeftyInt + 1);
            String newBottomRightValue = BottomRightxInt + "," + (BottomRightyInt + 1);
            robot.settopLeft(newTopLeftValue);
            robot.setbottomRight(newBottomRightValue);
            room.resetTab();
            room.setRobotNewPose(newTopLeftValue, newBottomRightValue);
        }
    }

    void moveWest(int TopLeftxInt, int TopLeftyInt, int BottomRightxInt, int BottomRightyInt, int robotLength, int robotWidth) {
        if (TopLeftyInt - 1 < 0) {
            System.out.println("Can't move left");
        } else {
            String newTopLeftValue = TopLeftxInt + "," + (TopLeftyInt - 1);
            String newBottomRightValue = BottomRightxInt + "," + (BottomRightyInt - 1);
            robot.settopLeft(newTopLeftValue);
            robot.setbottomRight(newBottomRightValue);
            room.resetTab();
            room.setRobotNewPose(newTopLeftValue, newBottomRightValue);
        }
    }

    ArrayList<Character> getFacingArray() {
        ArrayList<Character> facingArray = new ArrayList<>();
        facingArray.add('N'); // 0
        facingArray.add('E'); // 1
        facingArray.add('S'); // 2
        facingArray.add('W'); // 3
        return facingArray;
    }

    void printRobotPosition() {
        String topLeft = robot.gettopLeft();
        String bottomRight = robot.getbottomRight();
        char facing = robot.getFacing();
        System.out.println("Current position: Top-left = " + topLeft + ", Bottom-right = " + bottomRight + " Facing : " + facing);
    }
}
