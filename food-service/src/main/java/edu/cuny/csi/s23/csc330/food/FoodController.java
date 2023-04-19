package edu.cuny.csi.s23.csc330.food;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FoodController {
    @GetMapping
    public ResponseEntity<Void> get() {
        return ResponseEntity.ok().build();
    }
}
