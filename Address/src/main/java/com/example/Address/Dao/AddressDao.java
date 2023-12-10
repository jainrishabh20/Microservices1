package com.example.Address.Dao;

import com.example.Address.Model.Address;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.annotations.AnyDiscriminator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {
}
