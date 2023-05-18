package view;

import controller.LoginController;
import controller.RegistrationController;
import details.UserDetailsImpl;
import entity.User;
import enums.Roles;
import voting.ControlOfVotingForCandidates;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final LoginController loginController;
    private final RegistrationController registrationController;
    private final ControlOfVotingForCandidates controlOfVotingForCandidates;
    private UserDetailsImpl userDetails;

    public Menu(LoginController loginController, RegistrationController registrationController,
                ControlOfVotingForCandidates controlOfVotingForCandidates) {
        this.loginController = loginController;
        this.registrationController = registrationController;
        this.controlOfVotingForCandidates = controlOfVotingForCandidates;
    }

    public void drawMainMenu() {
        System.out.println("------Голосование------");
        System.out.println("1. Регистрация и вход");
        System.out.println("2. Голосование для пользователя");
        System.out.println("3. Голосование для админа");
        executeMainMenu();
    }

    private void executeMainMenu() {
        int command = scanner.nextInt();
        scanner.nextLine();
        switch (command) {
            case 1 -> drawAuthMenu();
            case 2 -> drawVotingMenuForUser();
            case 3 -> drawVotingMenuForAdmin();
        }
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
            userDetails = new UserDetailsImpl(user);
            userDetails.isAuthorized = true;
            System.out.println("Успешно!");
            drawMainMenu();

        } else {
            System.out.println("Пароль или имя пользователя не подходят");
            drawAuthMenu();
        }
    }
    private void drawVotingMenuForUser() {
        isVotingCreated();
        System.out.println("------Голосование для пользователя------");
        System.out.println("1. Проголосовать за кандидата");
        System.out.println("2. Показать состояние голосования");
        System.out.println("3. Вернуться в меню");
        executeUserVotingMenu();

    }

    private void isVotingCreated() {
        if (controlOfVotingForCandidates.getEndVotingDate() == null) {
            System.out.println("Голосование еще не создано ");
            drawMainMenu();
        }
    }

    private void executeUserVotingMenu() {
        int command = scanner.nextInt();
        scanner.nextLine();
        switch (command) {
            case (1) -> candidatesMenu();
            case (2) -> votingStatementMenu();
            case (3) -> drawMainMenu();
        }
    }
    private void votingStatementMenu() {
        isVotingCreated();
        System.out.println("Дата проведения: " + controlOfVotingForCandidates.getStartDate() + " - " + controlOfVotingForCandidates.getEndVotingDate());
        controlOfVotingForCandidates.getCandidateAndVotes().forEach
                ((user, integer) -> System.out.println("Кандидат " + user + ":\n" + "Количество голосов " + integer));
        System.out.println("До конца голосования " +
                Math.abs(controlOfVotingForCandidates.getStartDate().toEpochDay() - controlOfVotingForCandidates.getEndVotingDate().toEpochDay()) );
        System.out.println("1. Выйти");
        int command = scanner.nextInt();
        scanner.nextLine();
        switch (command) {
            case (1) -> drawMainMenu();
        }
    }
    private void candidatesMenu() {
        if (!userDetails.isVoted) {
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
            userDetails.isVoted = true;
            System.out.println("Вы успешно проголосовали");
            drawVotingMenuForUser();
        } else {
            System.out.println("Вы уже пролосовали");
            drawVotingMenuForUser();
        }
    }

    private void drawVotingMenuForAdmin() {
        if (userDetails.getAuthorities().equals(Roles.ADMIN)) {
            System.out.println("------Управление голосованием------");
            System.out.println("1. Показать состояние голосования");
            System.out.println("2. Создать голосование ");
            System.out.println("3. Добавить кандидатов ");
            System.out.println("4. Получить статистику по проголосовашим");
            System.out.println("5. Вернуться в меню");
            executeAdminVotingMenu();
        } else {
            System.out.println("Вы не администратор и не можете сюда войти");
            drawMainMenu();
        }
    }

    private void executeAdminVotingMenu() {
        int command = scanner.nextInt();
        scanner.nextLine();
        switch (command) {
            case 1 -> votingStatementMenu();
            case 2 -> createVotingMenu();
            case 3 -> addCandidateMenu();
        }
    }

    private void addCandidateMenu() {
        System.out.println("Введите имя кандидата");
        String name = scanner.nextLine();
        controlOfVotingForCandidates.addCandidateInVoting(new User(name));
        System.out.println("Кандидат успешно добавлен");
        drawVotingMenuForAdmin();
    }

    private void createVotingMenu() {
        System.out.println("Введите дату конца голосования, отчёт начнется с нынешней даты (формат ввода yyyy-mm-dd");
        String dateEnd = scanner.nextLine();
        try {
            controlOfVotingForCandidates.createVoting(LocalDate.parse(dateEnd));
        } catch (DateTimeParseException e) {
            throw new RuntimeException(e);
        }
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
