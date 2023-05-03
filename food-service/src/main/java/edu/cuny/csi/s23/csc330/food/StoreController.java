package edu.cuny.csi.s23.csc330.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("store")
public class StoreController {
    public StoreController(@Autowired Stores stores) {
        this.stores = stores;
    }

    private final Stores stores;



    @GetMapping("menus")
    public Map<String,String> menus(){
        return stores.getMenus();
    }
}
