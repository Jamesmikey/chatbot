package tz.ac.udsm.chatBot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.chatBot.dto.AddressDto;
import tz.ac.udsm.chatBot.models.Address;
import tz.ac.udsm.chatBot.services.AddressService;

import javax.naming.OperationNotSupportedException;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {


    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAll(){
        return addressService.getAll();
    }


    @PostMapping
    public String add(@RequestBody Address address){

        addressService.add(address);

        return "Address added successfully";
    }

    @PutMapping("/{id}")
    public String edit( @PathVariable Long id,@RequestBody Address newAddress) throws OperationNotSupportedException {

        addressService.edit(id,newAddress);

        return "Address with ID "+id+" edited";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Long id) throws OperationNotSupportedException {

        addressService.deleteById(id);

        return id+" Address deleted ";
    }
}
