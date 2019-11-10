package cs.mum.edu.shippingservice.controller;

import cs.mum.edu.shippingservice.model.Shipping;
import cs.mum.edu.shippingservice.model.ShippingStatus;
import cs.mum.edu.shippingservice.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {
    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public @ResponseBody
    Shipping postShipping(@RequestBody Shipping shipping){
        return shippingService.createShipping(shipping);
    }

    @RequestMapping(value = "/process/{shipping_id}", method = RequestMethod.PUT)
    public @ResponseBody Shipping processShipping(@PathVariable Long shippingId){
        return shippingService.updateShippingStatus(shippingId, ShippingStatus.SHIPPED);
    }
}
