package robot.programming;

import beans.Robot;
import beans.Room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import wrk.format.RoomFormat;
import wrk.format.RobotFormat;
import wrk.format.MovementRobotFormat;

import wrk.Manager.RoomManager;
import wrk.Manager.RobotManager;

import wrk.Movement.RobotMovement;

/**
 *
 * @author 5ampa
 */
public class RobotProgrammingController implements Initializable {

    @FXML
    private TextField roomLength;
    @FXML
    private TextField roomWidth;
    @FXML
    private TextField robotLength;
    @FXML
    private TextField robotWidth;
    @FXML
    private TextField movementCommands;
    @FXML
    private TextArea outputArea;

    @FXML
    private RadioButton north;
    @FXML
    private RadioButton south;
    @FXML
    private RadioButton east;
    @FXML
    private RadioButton west;

    private ToggleGroup startDirectionToggleGroup;

    RoomFormat wrkRoomFormat;
    RobotFormat wrkRobotFormat;
    MovementRobotFormat wrkMovementFormat;

    RoomManager wrkRoomManager;
    RobotManager wrkRobotManager;

    RobotMovement wrkRobotMovement;

    private Room room;
    private Robot robot;

    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    /**
     * Initializes the controller class. Initializes format checkers, managers,
     * movement simulator, and UI components. Sets up radio buttons for initial
     * direction selection.
     *
     * @param url The location used to resolve relative paths for the root
     * object, or null if the location is not known.
     * @param rb The resources used to localize the root object, or null if the
     * root object was not localized.
     */
    public void initialize(URL url, ResourceBundle rb) {
        wrkRoomFormat = new RoomFormat();
        wrkRobotFormat = new RobotFormat();
        wrkRoomManager = new RoomManager();
        wrkRobotManager = new RobotManager();
        wrkMovementFormat = new MovementRobotFormat();


        // Initialize ToggleGroup and assign to radio buttons
        startDirectionToggleGroup = new ToggleGroup();
        north.setToggleGroup(startDirectionToggleGroup);
        south.setToggleGroup(startDirectionToggleGroup);
        east.setToggleGroup(startDirectionToggleGroup);
        west.setToggleGroup(startDirectionToggleGroup);
        robot = new Robot();
        room = new Room();
        showErrorAlert("Before testing", "The rotation of a rectangle is not working properly");

    }

    @FXML
    /**
     * Handles the action when the simulate movement button is clicked. Handles
     * the format check for the room,robot and movement, and handles the errors.
     *
     * @param event The event triggered by clicking the simulate movement
     * button.
     */
    private void simulateMovement(ActionEvent event) {

        robot = new Robot();
        room = new Room();
        //get Room values and check format
        String roomFormat = roomLength.getText() + roomWidth.getText();
        boolean roomFormatOk = wrkRoomFormat.checkRoomFormat(roomFormat);

        if (roomFormatOk) {

            //create room
            room = wrkRoomManager.createRoom(roomFormat);
            wrkRoomManager.fillRoom(room);

            //get Robot values and check format
            RadioButton selectedDirection = (RadioButton) startDirectionToggleGroup.getSelectedToggle();
            if (selectedDirection != null) {

                char initialDirection = selectedDirection.getText().charAt(0);

                String robotFormatStr = robotLength.getText() + robotWidth.getText() + initialDirection;
                boolean robotFormatOk = wrkRobotFormat.checkRobotFormat(robotFormatStr, room);

                if (robotFormatOk) {
                    robot = wrkRobotManager.createRobot(robotFormatStr);

                    //get commands values and check format
                    String commands = movementCommands.getText();
                    boolean isRobotMovementCorrectFormat = wrkMovementFormat.checkMovementRobotFormat(commands);

                    if (isRobotMovementCorrectFormat) {

                        //calc movement
                                wrkRobotMovement = new RobotMovement(room,robot);
                        String pose = wrkRobotMovement.calcMovement(commands);

                        outputArea.setText(pose);

                    } else {
                        showErrorAlert("Invalid Movement Format", "The Movement format is incorrect. Please enter valid dimensions.");

                    }

                } else {
                    showErrorAlert("Invalid Robot Format", "The Robot format is incorrect. Please enter valid dimensions.");

                }

            } else {
                showErrorAlert("No Direction Selected", "Please select a starting direction for the robot.");
            }

        } else {
            showErrorAlert("Invalid Room Format", "The room format is incorrect. Please enter valid dimensions.");
        }

    }

    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    //N
    //O      E 
    //S
}
