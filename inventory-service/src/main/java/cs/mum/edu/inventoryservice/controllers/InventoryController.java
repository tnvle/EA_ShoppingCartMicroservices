package cs.mum.edu.inventoryservice.controllers;

import cs.mum.edu.inventoryservice.entities.InventoryItem;
import cs.mum.edu.inventoryservice.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("")
    @ResponseBody
    public List<InventoryItem> getAllProductInventory() {
        return inventoryService.getAllProductInventory();
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<InventoryItem> findInventoryByProductCode(@PathVariable("productCode") String productCode) {
        Optional<InventoryItem> inventoryItem = inventoryService.getProductByCode(productCode);
        if(inventoryItem.isPresent()) {
            return new ResponseEntity(inventoryItem, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sell/{productCode}/{units}")
    public ResponseEntity<InventoryItem> sellByProductCode(@PathVariable("productCode") String productCode, @PathVariable("units") Integer units) {
        Optional<InventoryItem> inventoryItem = inventoryService.getProductByCode(productCode);
        if(inventoryItem.isPresent()) {
            InventoryItem item = inventoryItem.get();
            item.setAvailableQuantity(item.getAvailableQuantity() - units);
            inventoryService.save(item);
            return new ResponseEntity(item, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/add/{productCode}/{units}")
    public ResponseEntity<InventoryItem> addToStockByProductCode(@PathVariable("productCode") String productCode, @PathVariable("units") Integer units) {
        Optional<InventoryItem> inventoryItem = inventoryService.getProductByCode(productCode);
        if(inventoryItem.isPresent()) {
            InventoryItem item = inventoryItem.get();
            item.setAvailableQuantity(item.getAvailableQuantity() + units);
            inventoryService.save(item);
            return new ResponseEntity(item, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
