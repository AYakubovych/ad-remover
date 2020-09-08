package a.yakubovych;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebEntryPoint {

    public static void startWeb(){
        SpringApplication.run(WebEntryPoint.class, new String[] {});
    }

}
