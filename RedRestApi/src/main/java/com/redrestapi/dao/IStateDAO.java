package com.redrestapi.dao;
import java.util.List;

import com.redrestapi.entity.State;
public interface IStateDAO {
    List<State> getAllStates();
    State getStateById(int StateId);
    void addState(State state);
    void updateState(State state);
    void deleteState(int StateId);
    boolean StateExists(String name, String i);
}
 