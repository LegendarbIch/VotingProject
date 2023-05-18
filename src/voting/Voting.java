package voting;

import entity.User;

import java.time.LocalDate;
import java.util.*;

public class Voting {
    private final LocalDate startDate;
    private LocalDate endVotingDate;
    private final List<User> candidates = new ArrayList<>();
    private final Map<User, Integer> candidateAndVotes = new HashMap<>();

    public Voting() {
        startDate = LocalDate.now();
        init();
    }

    public void addCandidate(User user) {
        candidates.add(user);
        candidateAndVotes.put(user, 0);
    }
    public List<User> getCandidates() {
        return new ArrayList<>(candidates);
    }

    public LocalDate getStartDate() {
        return startDate;
    }


    public LocalDate getEndVotingDate() {
        return endVotingDate;
    }

    public void setEndVotingDate(LocalDate endVotingDate) {
        this.endVotingDate = endVotingDate;
    }

    public Map<User, Integer> getCandidateAndVotes() {
        return candidateAndVotes;
    }

    @Override
    public String toString() {
        return "Voting{" +
                "startDate=" + startDate +
                ", endDate=" + endVotingDate +
                ", candidateAndVotes=" + candidateAndVotes +
                '}';
    }
    private void init() {
        addCandidate(new User("Путин"));
        addCandidate(new User("Трамп"));
    }
}
