package com.youruber.youruber.respositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youruber.youruber.entities.Passageiro;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

	
}
