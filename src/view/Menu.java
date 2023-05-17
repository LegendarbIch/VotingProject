package view;

import controller.AuthorizationManager;
import controller.LoginController;
import controller.RegistrationController;
import entity.User;
import enums.Roles;
import repository.UsersRepository;
import voting.ControlOfVotingForCandidates;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private final LoginController loginController;
    private final RegistrationController registrationController;
    private final ControlOfVotingForCandidates controlOfVotingForCandidates;
    private final UsersRepository usersRepository;

    public Menu(LoginController loginController, RegistrationController registrationController,
                ControlOfVotingForCandidates controlOfVotingForCandidates, UsersRepository usersRepository) {
        this.loginController = loginController;
        this.registrationController = registrationController;
        this.controlOfVotingForCandidates = controlOfVotingForCandidates;
        this.usersRepository = usersRepository;
    }

    public void draw() {
        System.out.println("------Голосование------");
        System.out.println("1. Регистрация и вход");
        System.out.println("2. Проголосовать за ");
    }
    public void drawAuthMenu() {
        System.out.println("------Регистрация------");
        System.out.println("1. Войти в систему");
        System.out.println("2. Зарегестрироваться");

        executeAuthMenu();
    }
    private void executeAuthMenu() {
        int command = scanner.nextInt();
        scanner.nextLine();
        switch (command) {
            case 1 -> drawLoginMenu();
            case 2 -> drawRegistrationMenu();
            default -> throw new IllegalArgumentException("No command found");
        }
    }

    private void drawLoginMenu() {
        System.out.println("Введите имя пользователя");
        String name = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        User user = new User(name, password);
        if (loginController.loginUser(user)) {
            AuthorizationManager.isAuthorized = true;
            System.out.println("Успешно!");
            Optional<User> loginedUser = usersRepository.find(user);
            if (loginedUser.isPresent()) {
                if (loginedUser.get().getRole().equals(Roles.ADMIN)){
                    drawVotingMenuForAdmin();
                } else{
                    drawVotingMenuForUser();
                }
            }
        } else {
            System.out.println("Пароль или имя пользователя не подходят");
        }
    }
    private void drawVotingMenuForUser() {
        System.out.println("------Голосование для пользователя------");
        System.out.println("1. Проголосовать за кандидата");
        candidatesMenu();
    }

    private void candidatesMenu() {
        System.out.println("-----Список кандидатов-----");
        Map<Integer, User> candidates = new HashMap<>();
        int num = 1;
        for (User candidate : controlOfVotingForCandidates.getCandidates()) {
            System.out.println(num + ". " + candidate.getName());
            candidates.put(num, candidate);
            num++;
        }
        System.out.println("Выберите, за кого проголосовать");
        int selection = scanner.nextInt();
        scanner.nextLine();
        try {
            controlOfVotingForCandidates.voteForCandidate(candidates.get(selection));
        } catch (NoSuchElementException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Вы успешно проголосовали");
    }

    private void drawVotingMenuForAdmin() {

    }

    private void drawRegistrationMenu() {
        System.out.println("Как вас зовут?");
        String name = scanner.nextLine();
        System.out.println("Ваша дата рождения");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println("Придумайте пароль");
        String password = scanner.nextLine();
        registrationController.registerUser(new User(name, date, password));
        System.out.println("Вы успешно зарегистрировались! Теперь войдите");
        drawLoginMenu();
    }



}
