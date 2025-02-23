package ecommerce.example.logistics.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity

public class Shipment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tracking number cannot be blank")
    @Column(nullable = false, unique = true, length = 64)
    private String trackingNumber;

    @NotBlank(message = "Carrier cannot be blank")
    @Column(nullable = false, length = 50)
    private String carrier;

    @NotBlank(message = "Status cannot be blank")
    @Column(nullable = false, length = 30)
    private String status;

    @NotBlank(message = "Destination cannot be blank")
    @Column(nullable = false, length = 255)
    private String destination;

    @NotNull(message = "Shipment date cannot be null")
    @Column(nullable = false)
    private LocalDateTime shipmentDate;

    @FutureOrPresent(message = "Estimated delivery date must be in the present or future")
    private LocalDateTime estimatedDeliveryDate;

    public Shipment() {
        this.shipmentDate = LocalDateTime.now();
    }


    public Shipment(String trackingNumber, String carrier, String status, String destination, LocalDateTime estimatedDeliveryDate) {
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
        this.status = status;
        this.destination = destination;
        this.shipmentDate = LocalDateTime.now();
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", carrier='" + carrier + '\'' +
                ", status='" + status + '\'' +
                ", destination='" + destination + '\'' +
                ", shipmentDate=" + shipmentDate +
                ", estimatedDeliveryDate=" + estimatedDeliveryDate +
                '}';
    }
}