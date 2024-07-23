package org.example.hhjava243springweb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping
    public String helloWord() {
        System.out.println("The GET Method: Hello World!");
        return "Hello World!";
    }

    @GetMapping("/bye")
    public String byeWorld() {
        System.out.println("The GET Method: Bye World!");
        return "Bye World!";
    }

    @PostMapping
    public String text(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return requestBody;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id) {
        System.out.println(id);
        return id;
    }
}
