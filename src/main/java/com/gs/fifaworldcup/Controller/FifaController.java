package com.gs.fifaworldcup.Controller;

import com.gs.fifaworldcup.Model.Prediction;
import com.gs.fifaworldcup.Service.FifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FifaController {

    @Autowired
    private FifaService fifaService;

    @PostMapping("/predict")
    public void registerPredictions(@RequestBody Prediction prediction) {
        fifaService.registerPredictions(prediction);
    }
}
