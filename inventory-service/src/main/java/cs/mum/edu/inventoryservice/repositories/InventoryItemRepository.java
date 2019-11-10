package cs.mum.edu.inventoryservice.repositories;

import cs.mum.edu.inventoryservice.entities.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    Optional<InventoryItem> findByProductCode(String productCode);
}