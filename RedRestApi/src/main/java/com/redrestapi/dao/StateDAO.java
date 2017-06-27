package com.redrestapi.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redrestapi.entity.State;

@Transactional
@Repository
public class StateDAO implements IStateDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public State getStateById(int StateId) {
		return entityManager.find(State.class, StateId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<State> getAllStates() {
		String hql = "FROM State ORDER BY state_name";
		return (List<State>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addState(State State) {
		entityManager.persist(State);
	}
	@Override
	public void updateState(State State) {
		State artcl = getStateById(State.getStateId());
		artcl.setName(State.getName());
		artcl.setStateId(State.getStateId());
		artcl.setAbbreviation(State.getAbbreviation());
		artcl.setDateAdded(State.getDateAdded());
		artcl.setDateTimeAdded(State.getDateTimeAdded());
		artcl.setLastUpdated(State.getLastUpdated());
		entityManager.flush();
	}
	@Override
	public void deleteState(int StateId) {
		entityManager.remove(getStateById(StateId));
	}
	@Override
	public boolean StateExists(String name, String stateId) {
		String hql = "FROM  State as atcl WHERE atcl.state_name= ? and atcl.abbreviation = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name)
		              .setParameter(2, stateId).getResultList().size();
		return count > 0 ? true : false;
	}
}
