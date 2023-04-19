package model.voting;

import model.Candidate;

public class ControlOfVotingForCandidatesForUser extends ControlOfVotingForCandidatesForAdmin{
    @Override
    public void voteForObject(Candidate votingObj) {
        super.voteForObject(votingObj);
    }

    @Override
    public CandidateVoting getVoting() {
        return super.getVoting();
    }
}
