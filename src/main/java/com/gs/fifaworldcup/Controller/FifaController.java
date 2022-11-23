package com.gs.fifaworldcup.Controller;

import com.gs.fifaworldcup.Model.LeaderBoardEntry;
import com.gs.fifaworldcup.Model.Prediction;
import com.gs.fifaworldcup.Service.FifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FifaController {

    @Autowired
    private FifaService fifaService;

    @PostMapping("/predict")
    public void registerPredictions(@RequestBody Prediction prediction) {
        fifaService.registerPredictions(prediction);
    }

    @GetMapping("/mypredict/{kerb}")
    public Prediction myprediction(@PathVariable String kerb) {
        return fifaService.myprediction(kerb);
    }

    @GetMapping("/leaderboard/{kerb}")
    public List<LeaderBoardEntry> getLeaderBoard(@PathVariable String kerb) {
        return fifaService.getLeaderBoard(kerb);
    }
}
