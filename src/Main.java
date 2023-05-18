
import controller.LoginController;
import controller.RegistrationController;
import details.UserDetailsImpl;
import entity.User;
import repository.UsersRepository;
import view.Menu;
import voting.ControlOfVotingForCandidates;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        UsersRepository uR = new UsersRepository();
       Menu menu = new Menu(new LoginController(uR),
               new RegistrationController(uR),
               new ControlOfVotingForCandidates(),
               uR);
       menu.drawAuthMenu();
    }
}