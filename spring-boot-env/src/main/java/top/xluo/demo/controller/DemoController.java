package top.xluo.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lingyi
 * @Date 2019/11/19
 * @Description TODO
 **/
@RestController
public class DemoController {

    @Value("${constant.name}")
    private String name;

    @GetMapping("/hello")
    public String hello() {
        return "hello, SpringBoot";
    }

    @GetMapping("/getName")
    public String getName() {
        return name;
    }
}
