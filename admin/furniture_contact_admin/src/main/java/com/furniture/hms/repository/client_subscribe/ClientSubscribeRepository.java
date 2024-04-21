package com.furniture.hms.repository.client_subscribe;

import com.furniture.hms.entity.ClientSubscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientSubscribeRepository extends JpaRepository<ClientSubscribe,Integer> {
    Optional<ClientSubscribe> findByEmailContaining(String email);
}
