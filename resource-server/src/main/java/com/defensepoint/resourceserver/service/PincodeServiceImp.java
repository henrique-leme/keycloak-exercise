package com.defensepoint.resourceserver.service;

import com.defensepoint.resourceserver.entity.Pincode;
import com.defensepoint.resourceserver.repository.PincodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PincodeServiceImp implements PincodeService {

    @Autowired
    private PincodeRepository pincodeRepository;

    @Override
    public String createPincode(Pincode pincode) {
        pincodeRepository.save(pincode);
        return "Pincode created successfully";
    }

    @Override
    public String updatePincode(int pincodeId, Pincode updatedPincode) {
        if (pincodeRepository.existsById(pincodeId)) {
            updatedPincode.setId(pincodeId);
            pincodeRepository.save(updatedPincode);
            return "Pincode updated successfully";
        } else {
            return "Pincode not found";
        }
    }

    @Override
    public List<Pincode> getAllPincodes() {
        return pincodeRepository.findAll();
    }

    @Override
    public Long countPincodes() {
        return pincodeRepository.count();
    }

    @Override
    public Pincode getPincode(int pincodeId) {
        return pincodeRepository.findById(pincodeId).orElse(null);
    }

    @Override
    public String deletePincode(int pincodeId) {
        if (pincodeRepository.existsById(pincodeId)) {
            pincodeRepository.deleteById(pincodeId);
            return "Pincode deleted successfully";
        } else {
            return "Pincode not found";
        }
    }

    @Override
    public List<Pincode> searchPincodes(String pincode) {
        return pincodeRepository.findByPincodeContaining(pincode);
    }
}
