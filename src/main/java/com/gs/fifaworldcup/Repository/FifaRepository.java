package com.gs.fifaworldcup.Repository;


import com.gs.fifaworldcup.Model.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface FifaRepository extends JpaRepository<Prediction,String> {
    List<Prediction> findTop10ByOrderByScore();


    Optional<Prediction> findByKerb(String kerb);
}
