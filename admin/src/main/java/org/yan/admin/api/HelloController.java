package org.yan.admin.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private int count = 0;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int hello() {
        count++;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }
}
