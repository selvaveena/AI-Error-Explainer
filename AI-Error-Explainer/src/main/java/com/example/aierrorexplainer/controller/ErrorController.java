package com.example.aierrorexplainer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.aierrorexplainer.service.OllamaService;

@RestController
public class ErrorController {

    private final OllamaService ollamaService;

    public ErrorController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/explain")
    public String explainError(@RequestBody String error) {
        return ollamaService.explainError(error);
    }
}