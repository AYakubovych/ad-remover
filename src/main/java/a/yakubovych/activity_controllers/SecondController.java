package a.yakubovych.activity_controllers;

import a.yakubovych.data.Properties;
import a.yakubovych.WebEntryPoint;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;

public class SecondController{

    private Logger logger = LoggerFactory.getLogger(SecondController.class);

    private StartController startController;

    private Stage thisStage;

    @FXML
    private Button backButton;
    @FXML
    private Button saveButton;
    @FXML
    private Label locationLabel;

    public SecondController(StartController startController){
        logger.info("SecondController constructor");
        this.startController = startController;

        thisStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Second.fxml"));
            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));
            thisStage.setResizable(false);
            thisStage.setTitle("AdRemover");

            locationLabel.setText(startController.getClickPoint().getX() + " " + startController.getClickPoint().getY());
           // locationLabel.setText(location.getX() + " " + location.getY());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.showAndWait();
    }

    @FXML
    private void initialize() {

        backButton.setOnAction(event -> openStartController());

        saveButton.setOnAction(event -> openSecondController());
   }

    private void openStartController() {
        logger.info("openStartController");

        StartController startController = new StartController();

        thisStage.close();
        startController.showStage();
    }

    private void openSecondController() {
        Properties.point = startController.getClickPoint();

        WebEntryPoint.startWeb();
        thisStage.close();

        //SecondController secondController = new SecondController(this);
        //secondController.showStage();

    }



}
