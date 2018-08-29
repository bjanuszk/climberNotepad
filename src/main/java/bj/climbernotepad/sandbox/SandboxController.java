package bj.climbernotepad.sandbox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SandboxController {

    Logger logger = LoggerFactory.getLogger(SandboxController.class);

    @RequestMapping("/sandbox/log")
    public void log() {
        logger.info("info");
        logger.error("error");
    }
}
