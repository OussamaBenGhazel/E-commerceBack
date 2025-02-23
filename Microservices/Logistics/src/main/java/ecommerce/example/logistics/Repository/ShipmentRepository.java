package ecommerce.example.logistics.Repository;

import ecommerce.example.logistics.Entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}

