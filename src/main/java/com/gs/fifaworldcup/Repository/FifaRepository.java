package com.gs.fifaworldcup.Repository;


import com.gs.fifaworldcup.Model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FifaRepository extends JpaRepository<Prediction,String> {
}
