package pl.polsl.telinf.s3.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
class HelloController {

    @GetMapping
    String helloWorld(){
        return "Hello World";
    }
}
