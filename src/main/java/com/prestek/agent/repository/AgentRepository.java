package com.prestek.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prestek.agent.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    // JpaRepository ya proporciona métodos básicos como findAll(), save(), delete(), etc.
}