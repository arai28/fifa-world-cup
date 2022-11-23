package com.gs.fifaworldcup.Service;

import com.gs.fifaworldcup.Model.LeaderBoardEntry;
import com.gs.fifaworldcup.Model.Prediction;
import com.gs.fifaworldcup.Repository.FifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FifaService {

    @Autowired
    private FifaRepository fifaRepository;


    public void registerPredictions(Prediction prediction) {
        fifaRepository.save(prediction);
    }



    public Prediction myprediction(String kerb) {
        return fifaRepository.findById(kerb).get();
    }

    public List<LeaderBoardEntry> getLeaderBoard() {
        return new ArrayList<LeaderBoardEntry>();
//        List<Prediction> fifaRepository.findTop10OrderByRank();
    }

}
