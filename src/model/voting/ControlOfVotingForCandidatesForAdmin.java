package model.voting;

import model.Candidate;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ControlOfVotingForCandidatesForAdmin implements ControlOfVoting<CandidateVoting,Candidate>{

    private CandidateVoting candidateVoting;
    private Map<Candidate, Integer> candidateAndVotesMap;

    @Override
    public void createVoting(LocalDate startDate, LocalDate endDate) {
        this.candidateVoting = new CandidateVoting(startDate, endDate);
        candidateAndVotesMap = candidateVoting.getCandidateAndVotes();
    }

    @Override
    public void addObjectInVoting(Candidate votingObj) {
        candidateAndVotesMap.put(votingObj,0);
    }

    @Override
    public void addObjectsInVoting(List<Candidate> votingObj) {
        for (Candidate candidate: votingObj) {
            candidateAndVotesMap.put(candidate, 0);
        }
    }

    @Override
    public void deleteObjectInVoting(Candidate votingObj) {

    }

    @Override
    public void voteForObject(Candidate votingObj) {
        if (candidateVoting.getCandidateAndVotes().isEmpty()) {
            System.out.println("Не добавлено ни одного кандидата");
        }
        candidateAndVotesMap.put(votingObj, candidateAndVotesMap.get(votingObj) + 1);
    }

    @Override
    public CandidateVoting getVoting() {
        return candidateVoting;
    }
}
