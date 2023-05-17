package voting;

import entity.User;

import java.time.LocalDate;
import java.util.*;

public class Voting {
    private LocalDate startDate;
    private LocalDate endDate;
    private final List<User> candidates = new ArrayList<>();
    private final Map<User, Integer> candidateAndVotes = new HashMap<>();

    public Voting() {
        init();
    }

    public void addCandidate(User user) {
        candidates.add(user);
    }
    public List<User> getCandidates() {
        return new ArrayList<>(candidates);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Map<User, Integer> getCandidateAndVotes() {
        return candidateAndVotes;
    }

    @Override
    public String toString() {
        return "Voting{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", candidateAndVotes=" + candidateAndVotes +
                '}';
    }
    private void init() {
        candidates.add(new User("Путин"));
        candidates.add(new User("Трамп"));
    }
}
