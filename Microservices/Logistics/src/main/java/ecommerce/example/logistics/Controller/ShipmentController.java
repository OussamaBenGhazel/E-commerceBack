package ecommerce.example.logistics.Controller;

import ecommerce.example.logistics.Entity.Shipment;
import ecommerce.example.logistics.Service.ShipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    // ✅ Injection par constructeur (bonne pratique)
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @GetMapping
    @Operation(summary = "Get all shipments", description = "Retrieve a list of all shipments")
    @ApiResponse(responseCode = "200", description = "Successful Operation")
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get shipment by ID", description = "Retrieve a specific shipment using its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipment found",
                    content = @Content(schema = @Schema(implementation = Shipment.class))),
            @ApiResponse(responseCode = "404", description = "Shipment not found")
    })
    public ResponseEntity<Shipment> getShipmentById(@PathVariable Long id) {
        return shipmentService.getShipmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new shipment", description = "Create a new shipment by providing shipment information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Shipment created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Shipment> createShipment(
            @RequestBody Shipment shipment) {
        Shipment createdShipment = shipmentService.createShipment(shipment);
        return ResponseEntity.status(201).body(createdShipment);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing shipment", description = "Update a shipment by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipment updated successfully"),
            @ApiResponse(responseCode = "404", description = "Shipment not found")
    })
    public ResponseEntity<Shipment> updateShipment(@PathVariable Long id,
                                                   @RequestBody Shipment shipment) {
        try {
            Shipment updatedShipment = shipmentService.updateShipment(id, shipment);
            return ResponseEntity.ok(updatedShipment);
        } catch (ResponseStatusException e) { // ✅ Gestion propre de l’exception
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a shipment", description = "Delete a shipment by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Shipment deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Shipment not found")
    })
    public ResponseEntity<Void> deleteShipment(@PathVariable Long id) {
        try {
            shipmentService.deleteShipment(id);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }
}
