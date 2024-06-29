package beans;

/**
 *
 * @author PaccaudS
 */
public class Room {

    private int length;
    private int width;
    private String[][] tab;

    public Room() {
        // Initialisation par défaut
        this.length = 0;
        this.width = 0;
        this.tab = new String[0][0];
    }

    public int getLength() {
        return length;
    }

    public void setLenght(int lenght) {
        this.length = lenght;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String[][] getTab() {
        return tab;
    }

    public void setTab(String[][] tab) {
        this.tab = tab;
    }

    public void setRobot(int robotLength, int robotWidth) {
        System.out.println("-----------");
        System.out.println("Put the robot into the room (" + robotLength + "," + robotWidth + ")");

        int roomLength = tab[0].length;    // Assuming 'tab' represents the room grid
        int roomWidth = tab.length;        // Assuming 'tab' represents the room grid

        System.out.println("Room size (" + roomLength + "," + roomWidth + ")");

        // Add 'AA' to the grid where the robot can be placed
        for (int i = 0; i < roomWidth; i++) {
            for (int j = 0; j < roomLength; j++) {
                if (i < robotWidth && j < robotLength) {
                    tab[i][j] = "AA";
                }
            }
        }
    }

    public void setRobotNewPose(String newTopLeft, String newBottomRight) {
        // Découper les nouvelles coordonnées
        String[] topLeftParts = newTopLeft.split(",");
        String[] bottomRightParts = newBottomRight.split(",");

        int topLeftX = Integer.parseInt(topLeftParts[0]);
        int topLeftY = Integer.parseInt(topLeftParts[1]);
        int bottomRightX = Integer.parseInt(bottomRightParts[0]);
        int bottomRightY = Integer.parseInt(bottomRightParts[1]);

        // Placer le robot aux nouvelles positions
        for (int i = topLeftX; i <= bottomRightX; i++) {
            for (int j = topLeftY; j <= bottomRightY; j++) {
                tab[i][j] = "AA";
            }
        }
    }
        

    public void printTab() {
        System.out.println("---SHOW TABLE----");
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                System.out.print(tab[x][y] + " ");
            }
            System.out.println();
        }
    }

    public void resetTab() {
        // Reset tab with default dimensions
         System.out.println("---RESET TABLE----");
        this.tab = new String[length][width];
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < width; y++) {
                tab[x][y] = x + "," + y;
            }
        }
        printTab();
    }

    @Override
    public String toString() {
        return "Room{" + "lenght=" + length + ", width=" + width + '}';
    }
}
