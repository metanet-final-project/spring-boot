package com.example.finalproject.dto;

import lombok.Data;

@Data
public class RouteDTO {
    private int id;

    private TerminalDTO startTerminal;
    private TerminalDTO endTerminal;
    private int travelTime;
}
