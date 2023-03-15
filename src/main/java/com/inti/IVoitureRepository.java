package com.inti;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Voiture;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface IVoitureRepository extends JpaRepository<Voiture, Integer> {

}
