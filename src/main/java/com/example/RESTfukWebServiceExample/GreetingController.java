package com.example.RESTfukWebServiceExample;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {



    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();



    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /*- Petición POST: mandando un objeto JSON en el body y recibiendo ese mismo objeto JSON en la respuesta (en el body).

     */

    @PostMapping("/greeting")
    public Greeting peticionPost(@RequestBody Greeting greets){
        return greets;

    }



    /*

     - Petición GET: mandando parámetros en el path (http://localhost:8080/user/{id})
     */


    @GetMapping("/user/{id}")
    public Greeting peticionGet(@RequestParam (value="id") long id){
        return new Greeting (id, String.format(template, "World"));

    }
    /*

     - Petición PUT: mandando Request Params (http://localhost:8080/post?var1=1&var2=2)*/

    @PutMapping("/put")
    public Greeting peticionPut(@RequestParam(value="id", defaultValue = "2") long id, @RequestParam(value="name", defaultValue="2") String name){
        return new Greeting(id, String.format(template, name));
    }
}