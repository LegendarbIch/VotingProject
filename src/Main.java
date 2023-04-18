import model.Candidate;
import model.voting.CandidateVoting;
import model.voting.ControlOfVotingForCandidatesForAdmin;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Candidate candidate1 = new Candidate("Путин", 1L);
        Candidate candidate2 = new Candidate("Трамп", 2L);
        List<Candidate> candidates = new ArrayList<>(Arrays.asList(candidate1,candidate2));
        ControlOfVotingForCandidatesForAdmin controlForAdmin = new ControlOfVotingForCandidatesForAdmin();
        controlForAdmin.createVoting(LocalDate.parse("2023-11-11"), LocalDate.parse("2024-11-11"));
        controlForAdmin.addObjectsInVoting(candidates);
        controlForAdmin.voteForObject(candidate1);
        System.out.println(controlForAdmin.getVoting());
    }
}