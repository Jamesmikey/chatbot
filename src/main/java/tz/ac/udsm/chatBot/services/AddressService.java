package tz.ac.udsm.chatBot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tz.ac.udsm.chatBot.dto.AddressDto;
import tz.ac.udsm.chatBot.models.Address;
import tz.ac.udsm.chatBot.repository.AddressRepository;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {


    @Autowired
    private AddressRepository addressRepository;


    public List<Address> getAll(){


        List<Address> addresses=addressRepository.findAll();

//        for(Address address:addresses){
//         address.getUser().setAddress(null);
//        }

        return addresses;
    }


    public void add(Address newAddress){

        addressRepository.save(newAddress);
    }


    public void edit(Long id,Address newAddress) throws OperationNotSupportedException {

            Address existAddress= addressRepository.findById(id).orElseThrow(() -> new OperationNotSupportedException("Address not exist"));

            existAddress.setStreet(newAddress.getStreet());

            existAddress.setPostalBox(newAddress.getPostalBox());

            addressRepository.save(existAddress);



//        for(Address address:addresss){
//            if(address.getId().equals(id)){
//                address.setName(newAddress.getName());
//                address.setEmail(newAddress.getEmail());
//                break;
//            }
//        }

    }

    public void deleteById(Long id) throws OperationNotSupportedException {

        Address existAddress= addressRepository.findById(id).orElseThrow(() -> new OperationNotSupportedException("Address not exist"));

//        addressRepository.deleteById(id);
        addressRepository.delete(existAddress);



//        for(Address address:addresss){
//            if(address.getId().equals(id)){
//                addresss.remove(address);
//                break;
//            }
//        }
    }

}
