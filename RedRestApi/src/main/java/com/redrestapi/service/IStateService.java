package com.redrestapi.service;

import java.util.List;

import com.redrestapi.entity.State;

public interface IStateService {
     List<State> getAllStates();
     State getStateById(int stateId);
     boolean addState(State state);
     void updateState(State state);
     void deleteState(int stateId);
}
