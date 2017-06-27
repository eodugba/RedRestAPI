package com.redrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redrestapi.dao.IStateDAO;
import com.redrestapi.entity.State;
@Service
public class StateService implements IStateService {
	@Autowired
	private IStateDAO stateDAO;
	@Override
	public State getStateById(int stateId) {
		State obj = stateDAO.getStateById(stateId);
		return obj;
	}	
	@Override
	public List<State> getAllStates(){
		return stateDAO.getAllStates();
	}
	@Override
	public synchronized boolean addState(State state){
       if (stateDAO.StateExists(state.getName(), state.getAbbreviation())) {
    	   return false;
       } else {
    	   stateDAO.addState(state);
    	   return true;
       }
	}
	@Override
	public void updateState(State state) {
		stateDAO.updateState(state);
	}
	@Override
	public void deleteState(int stateId) {
		stateDAO.deleteState(stateId);
	}
}
