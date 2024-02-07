package com.defensepoint.resourceserver.repository;

import com.defensepoint.resourceserver.entity.Pincode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PincodeRepository extends JpaRepository<Pincode, Integer> {

    List<Pincode> findByPincodeContaining(String pincode);
}
