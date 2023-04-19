package model;

public class Candidate {

    public Candidate(String FIO, Long id) {
        this.FIO = FIO;
        this.id = id;
    }

    private String FIO;

    private Long id;

    @Override
    public String toString() {
        return "Candidate{" +
                "FIO='" + FIO + '\'' +
                ", id=" + id +
                '}';
    }
}
