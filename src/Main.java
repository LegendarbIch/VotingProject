import controller.LoginController;
import controller.RegistrationController;
import entity.User;
import repository.UsersRepository;
import view.Menu;
import voting.ControlOfVotingForCandidates;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        User candidate1 = new User("Путин");
        User candidate2 = new User("Трамп");
        List<User> candidates = new ArrayList<>(Arrays.asList(candidate1,candidate2));
        ControlOfVotingForCandidates controlForAdmin = new ControlOfVotingForCandidates();
        controlForAdmin.createVoting(LocalDate.parse("2023-11-11"), LocalDate.parse("2024-11-11"));
        controlForAdmin.addCandidateInVoting(candidate1);
        controlForAdmin.voteForCandidate(candidate1);
        controlForAdmin.voteForCandidate(candidate1);
        System.out.println(controlForAdmin.getVoting());
        Menu menu = new Menu(new LoginController(new UsersRepository()),
                             new RegistrationController(new UsersRepository()),
                             new ControlOfVotingForCandidates(),
                             new UsersRepository());
        menu.drawAuthMenu();
    }
}