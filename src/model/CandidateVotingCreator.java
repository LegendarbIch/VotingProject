package model;

public class CandidateVotingCreator implements VotingCreator<CandidateVoting>{

    @Override
    public CandidateVoting createVoting() {
        return new CandidateVoting();
    }
}
