package com.defensepoint.resourceserver.resource;

import com.defensepoint.resourceserver.entity.Pincode;
import com.defensepoint.resourceserver.service.PincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pincodes")
public class PincodeResource {

    @Autowired
    private PincodeService pincodeService;

    // Create Pincode
    @PostMapping
    public ResponseEntity<String> createPincode(@RequestBody Pincode pincode) {
        return ResponseEntity.ok(pincodeService.createPincode(pincode));
    }

    // Update Pincode
    @PutMapping("/{pincodeId}")
    public ResponseEntity<String> updatePincode(@PathVariable int pincodeId, @RequestBody Pincode updatedPincode) {
        return ResponseEntity.ok(pincodeService.updatePincode(pincodeId, updatedPincode));
    }

    // Get All Pincodes
    @GetMapping
    public ResponseEntity<List<Pincode>> getAllPincodes() {
        return ResponseEntity.ok(pincodeService.getAllPincodes());
    }

    // Count Pincodes
    @GetMapping("/count")
    public ResponseEntity<Long> countPincodes() {
        return ResponseEntity.ok(pincodeService.countPincodes());
    }

    // Get Pincode
    @GetMapping("/{pincodeId}")
    public ResponseEntity<Pincode> getPincode(@PathVariable int pincodeId) {
        return ResponseEntity.ok(pincodeService.getPincode(pincodeId));
    }

    // Delete Pincode
    @DeleteMapping("/{pincodeId}")
    public ResponseEntity<String> deletePincode(@PathVariable int pincodeId) {
        return ResponseEntity.ok(pincodeService.deletePincode(pincodeId));
    }

    // Search Pincodes by Pincode String
    @GetMapping("/search")
    public ResponseEntity<List<Pincode>> searchPincodes(@RequestParam String pincode) {
        List<Pincode> foundPincodes = pincodeService.searchPincodes(pincode);

        if (!foundPincodes.isEmpty()) {
            return ResponseEntity.ok(foundPincodes);
        } else {
            return ResponseEntity.notFound().build();
        }    }

}