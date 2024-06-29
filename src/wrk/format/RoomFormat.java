/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wrk.format;

/**
 *
 * @author PaccaudS
 */
public class RoomFormat {

/**
 * This method checks if the room size string is in a valid format.
 * The valid format requires the room size string to be a two-digit integer.
 * @param roomSizeStr the string representing the room size.
 * @return true if the room size string is a two-digit integer, false otherwise.
 */
    public boolean checkRoomFormat(String roomSizeStr) {
        boolean result = false;

        if (checkRoomSize(roomSizeStr) && checkRoomInteger(roomSizeStr)) {
            result = true;
        }

        return result;
    }

    /**
     * This methode check if the room size is 2 digit.
     *
     * @param roomSizeStr the value of the room.
     * @return true if the room size is 2 digit,  false otherwise.
     */
    private boolean checkRoomSize(String roomSizeStr) {
        boolean result = false;
        if (roomSizeStr.length() == 2) {
            return true;
        }
        return result;
    }

    /**
     * Check if the room is a Integer
     * @param roomSizeStr the value of the room.
     * @return true if the room is a integer,  false otherwise.
     */
    private boolean checkRoomInteger(String roomSizeStr) {
        boolean result = false;

        try {
            int roomSize = Integer.parseInt(roomSizeStr);
            result = true;
        } catch (Exception e) {
            System.out.println("Probleme with the format of the room : " + e.getMessage());
        }
        return result;
    }
}