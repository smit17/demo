package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by Smit on 3/13/16.
 */
@RestController
public class Controller {
    @Autowired
    Manager manager;

    @Autowired
    TestInstance testInstance;

    @Autowired
    ExecutorService service;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    List<String> testHelloWorld(@RequestParam("name") String name, HttpServletResponse response) {
        System.out.println("Name:" + name);
        manager.testMethod();
        List<String> s =  new ArrayList<String>();
        s.add("abc");
        s.add("def");
        response.setStatus(HttpServletResponse.SC_OK);
        System.out.println("T: " + testInstance.getInitialized());
        for(int i=0; i<5; i++) {
            TaskRunner runner = new TaskRunner(i);
            service.submit(runner);
        }
        return s;
    }
}
