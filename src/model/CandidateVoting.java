package model;

import java.util.*;

public class CandidateVoting {
    private Date date;
    private final Map<Candidate, Integer> candidateAndVote = new HashMap<>();

    public void addCandidateInVoting(Candidate candidate) {
        candidateAndVote.put(candidate, 0);
    }
    public void VoteForCandidate(Candidate candidate) {
        if (candidateAndVote.isEmpty()) {
            System.out.println("Не добавлено ни одного кандидатаца");
        }
        candidateAndVote.put(candidate, candidateAndVote.get(candidate) + 1);
    }
}
