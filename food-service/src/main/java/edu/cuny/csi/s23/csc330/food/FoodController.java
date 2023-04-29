package edu.cuny.csi.s23.csc330.food;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("food")
public class FoodController {
    private final AtomicInteger id = new AtomicInteger();
    private final Map<String, String> data = new HashMap<>();

    @GetMapping("{id}")
    public String get(@PathVariable("id") String id) {
        String s = data.get(id);
        if (s == null) {
            return "not found";
        } else {
            return s;
        }
    }

    @PostMapping()
    public String post(@RequestBody String body) {
        System.out.println("post" + body);
        int andIncrement = id.getAndIncrement();
        data.put(String.valueOf(andIncrement), body);
        return dataAndId(String.valueOf(andIncrement), body);
    }

    private String dataAndId(String andIncrement, String body) {
        return """
                {"id":"%s", "data":"%s"}
                               """
                .formatted(andIncrement, body);
    }

    @PutMapping
    public String put(@RequestBody String body) {

        Map.Entry<String, String> stringStringEntry =
                data.entrySet().stream()
                        .filter(e -> e.getValue().equalsIgnoreCase(body))
                        .findFirst()
                        .get();

        if (stringStringEntry != null) {
            return dataAndId(stringStringEntry.getKey(), body);
        } else {
            return post(body);
        }
    }
}
