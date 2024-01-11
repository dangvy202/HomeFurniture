package com.furniture.hms.repository.informationContactAdmin;

import com.furniture.hms.entity.InformationContactAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationContactAdminRepository extends JpaRepository<InformationContactAdmin,Integer> {
}
