package com.prestek.agent.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestek.agent.model.Agent;
import com.prestek.agent.service.AgentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/agents")
@CrossOrigin(origins = "*")
@Tag(name = "Agent Controller", description = "API para gestión de agentes")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping
    @Operation(summary = "Obtener todos los agentes", description = "Retorna una lista de todos los agentes registrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de agentes obtenida exitosamente",
                    content = @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = Agent.class)))
    })
    public ResponseEntity<List<Agent>> getAllAgents() {
        List<Agent> agents = agentService.getAllAgents();
        return ResponseEntity.ok(agents);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo agentes", description = "Crea un nuevo agente en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Agente creado exitosamente",
                    content = @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = Agent.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
        Agent createdAgent = agentService.createAgent(agent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAgent);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "Agent Service");
        response.put("timestamp", LocalDateTime.now());
        response.put("message", "Agent service is running successfully");
        
        return ResponseEntity.ok(response);
    }
}