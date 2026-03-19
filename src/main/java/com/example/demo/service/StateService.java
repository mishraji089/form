package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.State;
import com.example.demo.repository.StateRepository;

@Service
public class StateService {

    private final StateRepository repo;

    public StateService(StateRepository repo) {
        this.repo = repo;
    }

    public List<State> getStates() {
        return repo.findAll();
    }
}
