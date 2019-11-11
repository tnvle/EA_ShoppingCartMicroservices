package cs.mum.edu.shippingservice.service;

import cs.mum.edu.shippingservice.model.Shipping;
import cs.mum.edu.shippingservice.model.ShippingStatus;

public interface ShippingService {
    public Shipping save(Shipping shipping);

    public Shipping updateShippingStatus(Long shippingId, ShippingStatus status);
}
