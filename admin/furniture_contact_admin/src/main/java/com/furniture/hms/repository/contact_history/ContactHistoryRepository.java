package com.furniture.hms.repository.contact_history;

import com.furniture.hms.entity.ContactHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactHistoryRepository extends JpaRepository<ContactHistory,Integer> {
}
