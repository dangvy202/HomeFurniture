package com.furniture.hms.repository.information_contact_client;

import com.furniture.hms.entity.InformationContactClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationContactClientRepository extends JpaRepository<InformationContactClient,Integer> {
}
