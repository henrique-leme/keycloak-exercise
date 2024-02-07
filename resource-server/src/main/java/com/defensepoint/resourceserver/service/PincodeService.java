package com.defensepoint.resourceserver.service;

import com.defensepoint.resourceserver.entity.Pincode;
import java.util.List;

public interface PincodeService {

    String createPincode(Pincode pincode);

    String updatePincode(int pincodeId, Pincode updatedPincode);

    List<Pincode> getAllPincodes();

    Long countPincodes();

    Pincode getPincode(int pincodeId);

    String deletePincode(int pincodeId);

    List<Pincode> searchPincodes(String pincode);
}
