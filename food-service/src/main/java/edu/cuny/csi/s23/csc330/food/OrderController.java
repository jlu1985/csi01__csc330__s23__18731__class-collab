package edu.cuny.csi.s23.csc330.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("order")
public class OrderController {
    private final Drivers drivers;
    private final AtomicInteger id = new AtomicInteger();
    private final ConcurrentHashMap<String, String> memoryOrderMap;

    public OrderController(
            @Qualifier("memoryOrderMap") ConcurrentHashMap<String, String> memoryOrderMap,
            @Autowired Drivers drivers) {
        this.memoryOrderMap = memoryOrderMap;
        this.drivers = drivers;
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id") String id) {
        String s = memoryOrderMap.get(id);
        if (s == null) {
            return "not found";
        } else {
            return s;
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<String> acceptOrder(@PathVariable("id") String id) {
        String order = memoryOrderMap.get(id);
        if (order == null) {
            return ResponseEntity.status(404).body("not found");
        }
        drivers.notifyAll(order);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public String post(@RequestParam("storeId") String storeId, @RequestBody String body) {
        System.out.println("post" + body);
        int andIncrement = id.getAndIncrement();
        memoryOrderMap.put(String.valueOf(andIncrement), body);
        return dataAndId(String.valueOf(andIncrement), body);
    }

    private String dataAndId(String andIncrement, String body) {
        return """
                {"id":"%s", "data":"%s"}
                               """
                .formatted(andIncrement, body);
    }

    @PutMapping
    public String put(@RequestParam("storeId") String storeId, @RequestBody String body) {

        Map.Entry<String, String> stringStringEntry =
                memoryOrderMap.entrySet().stream()
                        .filter(e -> e.getValue().equalsIgnoreCase(body))
                        .findFirst()
                        .get();

        if (stringStringEntry != null) {
            return dataAndId(stringStringEntry.getKey(), body);
        } else {
            return post(storeId, body);
        }
    }
}
