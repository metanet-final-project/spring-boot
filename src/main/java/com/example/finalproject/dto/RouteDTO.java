package com.example.finalproject.dto;

import com.example.finalproject.domain.Terminal;
import lombok.Data;

@Data
public class RouteDTO {
    private int id;
    private Terminal startTerminal;
    private Terminal endTerminal;
    private int travelTime;
}
