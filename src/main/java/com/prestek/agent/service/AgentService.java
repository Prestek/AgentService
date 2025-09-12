package com.prestek.agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestek.agent.model.Agent;
import com.prestek.agent.repository.AgentRepository;

@Service
public class AgentService {
    
    @Autowired
    private AgentRepository agentRepository;
    
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }
    
    public Agent createAgent(Agent agent) {
        return agentRepository.save(agent);
    }
}