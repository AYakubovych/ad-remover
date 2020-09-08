package a.yakubovych;

import a.yakubovych.activity_controllers.StartController;
import javafx.application.Application;
import javafx.stage.Stage;

public class ActivityEntryPoint extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StartController startController = new StartController();
        startController.showStage();
    }

}
