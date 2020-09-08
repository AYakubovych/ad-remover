package a.yakubovych.web_controllers;

import a.yakubovych.data.Properties;
import a.yakubovych.desktop.ConfiguredRobot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class receive requests and use desktop.ConfiguredRobot to emulate clicks
 * */
@RestController
public class ClickController{

    private ConfiguredRobot robot;

    private static Logger logger = LoggerFactory.getLogger(ClickController.class);

    @GetMapping("/click")
    public void oneClick() throws InterruptedException {
        logger.info("oneClick");

        robot.oneClick((int) Properties.point.getX(), (int) Properties.point.getY());
    }

    @Autowired
    public void setRobot(ConfiguredRobot robot) {
        this.robot = robot;
    }
}
