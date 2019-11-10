package cs.mum.edu.inventoryservice.services.impl;

import cs.mum.edu.inventoryservice.entities.InventoryItem;
import cs.mum.edu.inventoryservice.repositories.InventoryItemRepository;
import cs.mum.edu.inventoryservice.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    public Optional<InventoryItem> getProductByCode(String code){
        return inventoryItemRepository.findByProductCode(code);
    }

    public InventoryItem save(InventoryItem item){
        return inventoryItemRepository.save(item);
    }

    public List<InventoryItem> getAllProductInventory(){
        return inventoryItemRepository.findAll();
    }
}
