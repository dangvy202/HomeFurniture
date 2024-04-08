package com.furniture.hms.repository.contact_description;

import com.furniture.hms.entity.ContactDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDescriptionRepository extends JpaRepository<ContactDescription,Integer> {
}
