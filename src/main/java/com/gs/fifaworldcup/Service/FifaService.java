package com.gs.fifaworldcup.Service;

import com.gs.fifaworldcup.Model.Prediction;
import com.gs.fifaworldcup.Repository.FifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FifaService {

    @Autowired
    private FifaRepository fifaRepository;


    public void registerPredictions(Prediction prediction) {
        fifaRepository.save(prediction);
    }

}
