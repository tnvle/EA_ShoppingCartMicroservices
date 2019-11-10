package cs.mum.edu.inventoryservice.services;

import cs.mum.edu.inventoryservice.entities.InventoryItem;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    Optional<InventoryItem> getProductByCode(String code);
    InventoryItem save(InventoryItem item);
    List<InventoryItem> getAllProductInventory();
}
