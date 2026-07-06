package com.sagar.Spring_Boot_logging.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {

    public String sayHello() {
        log.trace("TRACE :: HelloService LOG");
        log.debug("DEBUG :: HelloService LOG");
        log.info("INFO :: HelloService LOG");
        log.warn("WARN :: HelloService LOG");
        log.error("ERROR :: HelloService LOG");
        int i = 10 / 0;
        return "Hello";
    }
}
