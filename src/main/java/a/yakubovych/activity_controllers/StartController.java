package a.yakubovych.activity_controllers;

import java.awt.*;
import java.io.IOException;

import a.yakubovych.web_controllers.ClickController;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartController{

    private static Logger logger = LoggerFactory.getLogger(StartController.class);
    /**
     * clickPoint is position of pointer
     * */
    private Point clickPoint;

    private final Stage thisStage;

    @FXML
    private Button button;
    @FXML
    private Button nextButton;
    @FXML
    private Label locationLabel;

    public StartController(){
        logger.info("StartController constructor");
        thisStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Start.fxml"));
            loader.setController(this);

            thisStage.setScene(new Scene(loader.load()));
            thisStage.setResizable(false);
            thisStage.setTitle("AdRemover");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        logger.info("showStage");
        thisStage.show();
    }

    @FXML
    private void initialize() {
        button.setOnAction(event -> setLocationLabel());
        nextButton.setOnAction(event -> openSecondController());
    }

    private void setLocationLabel(){
        logger.info("You clicked me!");

        setClickPointByPointerLocation(MouseInfo.getPointerInfo().getLocation());
        locationLabel.setText((int) clickPoint.getX() + " " + (int) clickPoint.getY());
    }

    public void setClickPointByPointerLocation(Point point) {
        clickPoint = point;
        logger.info(clickPoint.getX() + " " + clickPoint.getY());
    }

    private void openSecondController() {
        logger.info("openSecondController");

        SecondController secondController = new SecondController(this);

        thisStage.hide();
        secondController.showStage();
    }

    public Point getClickPoint(){
        return clickPoint;
    }

}
