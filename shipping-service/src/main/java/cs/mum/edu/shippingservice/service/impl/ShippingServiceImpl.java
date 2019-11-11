package cs.mum.edu.shippingservice.service.impl;

import cs.mum.edu.shippingservice.model.Shipping;
import cs.mum.edu.shippingservice.model.ShippingStatus;
import cs.mum.edu.shippingservice.repository.ShippingRepository;
import cs.mum.edu.shippingservice.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingServiceImpl implements ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;

    @Override
    public Shipping save(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    @Override
    public Shipping updateShippingStatus(Long shippingId, ShippingStatus status) {
        Shipping shipping = shippingRepository.findById(shippingId).orElse(null);
        if(shipping != null){
            shipping.setStatus(status);
        }
        return shippingRepository.save(shipping);
    }
}
