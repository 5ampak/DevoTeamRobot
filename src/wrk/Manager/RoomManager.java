package wrk.Manager;

import beans.Room;

public class RoomManager {

    /**
     * Creates a new Room object based on the given room size string.
     *
     * @param roomSizeStr A string representing the dimensions of the room
     * (e.g., "34" for 3x4).
     * @return A Room object initialized with the specified dimensions.
     */
    public Room createRoom(String roomSizeStr) {
        Room room = new Room();

        try {
            //34

            //0,0 0,1 0,2 
            //1,0 1,1 1,2 
            //2,0 2,1 2,2 
            //3,0 3,1 3,2 
            int width = Integer.parseInt(roomSizeStr.substring(0, 1));
            int length = Integer.parseInt(roomSizeStr.substring(1, 2));
            String[][] tab = new String[length][width];

            room.setLenght(length);
            room.setWidth(width);
            room.setTab(tab);

        } catch (NumberFormatException e) {
            System.out.println("Invalid room size format: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid room size or dimensions: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Problem with creating the room: " + e.getMessage());
        }
        return room;
    }

    /**
     * Fills the given room object with coordinate strings. Each element in the
     * room's 2D array is set to a string representing its coordinates.
     *
     * @param room The Room object to be filled with coordinates.
     * @return The 2D array representing the room after filling.
     */
    public String[][] fillRoom(Room room) {
        for (int x = 0; x < room.getTab().length; x++) {
            for (int y = 0; y < room.getTab()[x].length; y++) {
                room.getTab()[x][y] = x + "," + y;
            }
        }
        return room.getTab();
    }

    /**
     * Prints the contents of the room. Outputs each element of the room's 2D
     * array to the console, displaying the coordinates of each position in the
     * room.
     *
     * @param room The Room object whose contents are to be printed.
     */
    public void printRoom(Room room) {
        for (int x = 0; x < room.getTab().length; x++) {
            for (int y = 0; y < room.getTab()[x].length; y++) {
                System.out.print(room.getTab()[x][y] + " ");
            }
            System.out.println();
        }
    }
}
