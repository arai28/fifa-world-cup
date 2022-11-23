package com.gs.fifaworldcup.Service;

import antlr.StringUtils;
import com.gs.fifaworldcup.Model.LeaderBoardEntry;
import com.gs.fifaworldcup.Model.Prediction;
import com.gs.fifaworldcup.Repository.FifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FifaService {

    @Autowired
    private FifaRepository fifaRepository;

    private Prediction realResult = new Prediction("admin","admin",-1,-1,"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","");
    private static int groupRankcorrect = 0 ;
    private static int groupRankPartial = 0 ;
    private static int groupRankInverted = 0 ;

    private static int roundOf16Correct = 0 ;
    private static int qfCorrect = 0 ;
    private static int sfCorrect = 0 ;
    private static int championCorrect = 0 ;


    public void registerPredictions(Prediction prediction) {
        prediction.setScore(0);
        prediction.setRank(-1);
        fifaRepository.save(prediction);
    }



    public Prediction myprediction(String kerb) {
        return fifaRepository.findByKerb(kerb).orElse(new Prediction(kerb));
    }

    public List<LeaderBoardEntry> getLeaderBoard(String kerb) {
//        return new ArrayList<LeaderBoardEntry>();
        boolean userinTop10 = false;
        List<Prediction> top10 = fifaRepository.findTop10ByOrderByScore();
        List<LeaderBoardEntry> leaderboard = new ArrayList<>();
        int rank = 1;
        for(Prediction p: top10) {
            if(p.getKerb() == kerb)    userinTop10 = true;
            leaderboard.add(new LeaderBoardEntry(rank++,p.getName(),p.getKerb(),p.getScore()));
        }
        if(!userinTop10) {
            Optional<Prediction> userPrediction = fifaRepository.findByKerb(kerb);
            if(userPrediction.isPresent())  leaderboard.add(new LeaderBoardEntry(userPrediction.get().getRank(),userPrediction.get().getName(), userPrediction.get().getKerb(),userPrediction.get().getScore()));
        }
        return leaderboard;
    }

    public void updateScores() {
        List<Prediction> AllResponses = fifaRepository.findAll();
        for(Prediction p: AllResponses) {
            int score = computeScore(p);
            p.setScore(score);
        }
        Collections.sort(AllResponses, new Comparator<Prediction>() {
            public int compare(Prediction o1, Prediction o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });
        int rank = 1;
        for(Prediction p: AllResponses) {
            p.setRank(rank++);
            fifaRepository.save(p);
        }
    }

    private int computeScore(Prediction p) {
        int score = 0;
        if(p.getGroupATopper() == realResult.getGroupATopper() && p.getGroupARunnerUp() == realResult.getGroupARunnerUp())  score += groupRankcorrect;
        else if(p.getGroupATopper() == realResult.getGroupARunnerUp() && p.getGroupARunnerUp() == realResult.getGroupATopper())  score += groupRankInverted;
        else if(p.getGroupATopper() == realResult.getGroupATopper() || p.getGroupARunnerUp() == realResult.getGroupARunnerUp()) score += groupRankPartial;

        if(p.getGroupBTopper() == realResult.getGroupBTopper() && p.getGroupBRunnerUp() == realResult.getGroupBRunnerUp())  score += groupRankcorrect;
        else if(p.getGroupBTopper() == realResult.getGroupBRunnerUp() && p.getGroupBRunnerUp() == realResult.getGroupBTopper())  score += groupRankInverted;
        else if(p.getGroupBTopper() == realResult.getGroupBTopper() || p.getGroupBRunnerUp() == realResult.getGroupBRunnerUp()) score += groupRankPartial;

        if(p.getGroupCTopper() == realResult.getGroupCTopper() && p.getGroupCRunnerUp() == realResult.getGroupCRunnerUp())  score += groupRankcorrect;
        else if(p.getGroupCTopper() == realResult.getGroupCRunnerUp() && p.getGroupCRunnerUp() == realResult.getGroupCTopper())  score += groupRankInverted;
        else if(p.getGroupCTopper() == realResult.getGroupCTopper() || p.getGroupCRunnerUp() == realResult.getGroupCRunnerUp()) score += groupRankPartial;

        if(p.getGroupDTopper() == realResult.getGroupDTopper() && p.getGroupDRunnerUp() == realResult.getGroupDRunnerUp())  score += groupRankcorrect;
        else if(p.getGroupDTopper() == realResult.getGroupDRunnerUp() && p.getGroupDRunnerUp() == realResult.getGroupDTopper())  score += groupRankInverted;
        else if(p.getGroupDTopper() == realResult.getGroupDTopper() || p.getGroupDRunnerUp() == realResult.getGroupDRunnerUp()) score += groupRankPartial;

        if(p.getGroupETopper() == realResult.getGroupETopper() && p.getGroupERunnerUp() == realResult.getGroupERunnerUp())  score += groupRankcorrect;
        else if(p.getGroupETopper() == realResult.getGroupERunnerUp() && p.getGroupERunnerUp() == realResult.getGroupETopper())  score += groupRankInverted;
        else if(p.getGroupETopper() == realResult.getGroupETopper() || p.getGroupERunnerUp() == realResult.getGroupERunnerUp()) score += groupRankPartial;

        if(p.getGroupFTopper() == realResult.getGroupFTopper() && p.getGroupFRunnerUp() == realResult.getGroupFRunnerUp())  score += groupRankcorrect;
        else if(p.getGroupFTopper() == realResult.getGroupFRunnerUp() && p.getGroupFRunnerUp() == realResult.getGroupFTopper())  score += groupRankInverted;
        else if(p.getGroupFTopper() == realResult.getGroupFTopper() || p.getGroupFRunnerUp() == realResult.getGroupFRunnerUp()) score += groupRankPartial;

        if(p.getGroupGTopper() == realResult.getGroupGTopper() && p.getGroupGRunnerUp() == realResult.getGroupGRunnerUp())  score += groupRankcorrect;
        else if(p.getGroupGTopper() == realResult.getGroupGRunnerUp() && p.getGroupGRunnerUp() == realResult.getGroupGTopper())  score += groupRankInverted;
        else if(p.getGroupGTopper() == realResult.getGroupGTopper() || p.getGroupGRunnerUp() == realResult.getGroupGRunnerUp()) score += groupRankPartial;

        if(p.getGroupHTopper() == realResult.getGroupHTopper() && p.getGroupHRunnerUp() == realResult.getGroupHRunnerUp())  score += groupRankcorrect;
        else if(p.getGroupHTopper() == realResult.getGroupHRunnerUp() && p.getGroupHRunnerUp() == realResult.getGroupHTopper())  score += groupRankInverted;
        else if(p.getGroupHTopper() == realResult.getGroupHTopper() || p.getGroupHRunnerUp() == realResult.getGroupHRunnerUp()) score += groupRankPartial;


        if(p.getRoundOf16_1() == realResult.getRoundOf16_1())   score += roundOf16Correct;
        if(p.getRoundOf16_2() == realResult.getRoundOf16_2())   score += roundOf16Correct;
        if(p.getRoundOf16_3() == realResult.getRoundOf16_3())   score += roundOf16Correct;
        if(p.getRoundOf16_4() == realResult.getRoundOf16_4())   score += roundOf16Correct;
        if(p.getRoundOf16_5() == realResult.getRoundOf16_5())   score += roundOf16Correct;
        if(p.getRoundOf16_6() == realResult.getRoundOf16_6())   score += roundOf16Correct;
        if(p.getRoundOf16_7() == realResult.getRoundOf16_7())   score += roundOf16Correct;
        if(p.getRoundOf16_8() == realResult.getRoundOf16_8())   score += roundOf16Correct;

        if(p.getQF1Winner() == realResult.getQF1Winner())   score += qfCorrect;
        if(p.getQF2Winner() == realResult.getQF2Winner())   score += qfCorrect;
        if(p.getQF3Winner() == realResult.getQF3Winner())   score += qfCorrect;
        if(p.getQF4Winner() == realResult.getQF4Winner())   score += qfCorrect;

        if(p.getSF1Winner() == realResult.getSF1Winner())   score += sfCorrect;
        if(p.getSF2Winner() == realResult.getSF2Winner())   score += sfCorrect;

        if(p.getChampion() == realResult.getChampion()) score += championCorrect;
        return score;
    }

}
