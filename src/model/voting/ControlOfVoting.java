package model.voting;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ControlOfVoting<V,T> {
    void createVoting(LocalDate startDate, LocalDate endDate);
    void addObjectInVoting(T votingObj);
    void addObjectsInVoting(List<T> votingObj);
    void deleteObjectInVoting(T votingObj);
    void voteForObject(T votingObj);
    V getVoting();
}
