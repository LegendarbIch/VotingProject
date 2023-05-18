package voting;

import entity.User;

import java.time.LocalDate;
import java.util.List;


public class ControlOfVotingForCandidates extends Voting {

    public boolean isVoted;

    public void createVoting(LocalDate startDate, LocalDate endDate) {
        setStartDate(startDate);
        setEndDate(endDate);
    }

    public void addCandidateInVoting(User candidate) {
        addCandidate(candidate);
    }

    public void addCandidatesInVoting(List<User> candidates) {
        for (User candidate: candidates) {
            addCandidate(candidate);
        }
    }
    public void deleteObjectInVoting(User candidate) {

    }
    public void voteForCandidate(User candidate) {
        if (getCandidateAndVotes().isEmpty()) {
            throw new NullPointerException("Не добавленно ни одного кандидата");
        }
        getCandidateAndVotes().put(candidate, getCandidateAndVotes().get(candidate) + 1);
    }
    public Voting getVoting() {
        return this;
    }
}
