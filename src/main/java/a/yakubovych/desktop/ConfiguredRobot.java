package a.yakubovych.desktop;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * This class get data from data.Properties and emulate clicks
 * */
@Service
public class ConfiguredRobot {

    private Robot robot;

    public ConfiguredRobot() throws AWTException {
        robot = new Robot();
    }

    public void tripleClick(int x, int y) throws InterruptedException {

        robot.mouseMove(x, y);

        for (int i = 3; i > 0; i--) {

            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            Thread.sleep(135);
        }
    }

    public void oneClick(int x, int y) throws InterruptedException {
        robot.mouseMove(x, y);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
