package model.voting;

import model.Candidate;

import java.time.LocalDate;
import java.util.*;

public class CandidateVoting {
    private LocalDate startDate;
    private LocalDate endDate;
    private final Map<Candidate, Integer> candidateAndVotes = new HashMap<>();

    public CandidateVoting(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Map<Candidate, Integer> getCandidateAndVotes() {
        return candidateAndVotes;
    }

    @Override
    public String toString() {
        return "CandidateVoting{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", candidateAndVotes=" + candidateAndVotes +
                '}';
    }
}
