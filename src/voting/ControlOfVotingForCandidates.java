package voting;

import entity.User;

import java.time.LocalDate;
import java.util.List;


public class ControlOfVotingForCandidates extends Voting {

    public ControlOfVotingForCandidates() {
    }

    public void createVoting(LocalDate endDate) {
        setEndVotingDate(endDate);
    }

    public void addCandidateInVoting(User candidate) {
        addCandidate(candidate);
    }

    public void addCandidatesInVoting(List<User> candidates) {
        for (User candidate: candidates) {
            addCandidate(candidate);
        }
    }
    public void deleteCandidateInVoting(User candidate) {

    }
    public void voteForCandidate(User candidate) {
        if (getCandidateAndVotes().isEmpty()) {
            throw new NullPointerException("Не добавленно ни одного кандидата");
        }
        getCandidateAndVotes().put(candidate, getCandidateAndVotes().get(candidate) + 1);
    }
}
