package com.sagar.Spring_Boot_logging.controller;

import com.sagar.Spring_Boot_logging.services.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

//    private static final Logger logger =
//            LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/greet")
    public String sayHello() {
        String useraname = "Sagar ";
        log.info("Received request for /greet : {} ",useraname);

        log.info("Received request for /greet : {}, {},{} ",useraname,"Second", "Third");

        log.trace("TRACE :: HelloContrller LOG");
        log.debug("DEBUG :: HelloContrller LOG");
        log.info("INFO :: HelloContrller LOG");
        log.warn("WARN :: HelloContrller LOG");
        log.error("ERROR :: HelloContrller LOG");
         return  helloService.sayHello();
    }
}
