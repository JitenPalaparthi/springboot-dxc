package io.akalabs.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;


@RestController // Class level annotation
public class GreetingController {

    private final AtomicLong counter= new AtomicLong(0);
 
    @GetMapping("/greet") // Method level annotation
    //@RequestMapping(method = RequestMethod.GET)
    public String greet(@RequestParam(value="name",defaultValue = "World") String name){ // parameter based annotation
        return "Hello ".concat(name);
    }

    @GetMapping("/greetBy/{grt}/{name}")
    public String greetby(@PathVariable("grt") String grt,@PathVariable("name") String name){
        return grt.concat(name);
    }
    @GetMapping("/getPerson/{name}")
    public Person getPerson(@PathVariable("name") String name, @RequestParam(value="email",defaultValue = "info@gmail.com") String email){
        return new Person(1,name, email);
    }

    @PostMapping(value="/addPerson",consumes = "application/json",produces = "application/json")
    public Person addPerson(@RequestBody Person person){
        // public Person addPerson(String name, String email)
         return new Person(counter.incrementAndGet(),person.name(),person.email());
    }

}

// http://example.com:8089/learn/books/{id}?name="demo"
// scheme: http
// host: example.com
// port: 8089
// path: /learn/books/1
// Methods: GET, POST, PUT, DELETE, PATCH, TRACE,HEAD,OPTIONS
// Query Parameter: name
// Path Parameter: id ;when calling replace with a value as below 10
        // http://example.com:8089/learn/books/10?name="demo"

// curl --location 'localhost:8089/addPerson' --header 'Content-Type: application/json' --data-raw '{"name":"dxc","email":"dxc@dxc.com"}'