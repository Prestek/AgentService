package com.prestek.agent.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidad que representa un agente en el sistema")
public class Agent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del agente", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    
    @Column(nullable = false)
    @Schema(description = "Nombre del agente", example = "Agente Smith", required = true)
    private String name;
    
    @Column(nullable = false)
    @Schema(description = "Estado del agente", example = "ACTIVE", required = true)
    private String status;
    
    @Schema(description = "Descripción del agente", example = "Agente especializado en procesamiento de datos")
    private String description;
}