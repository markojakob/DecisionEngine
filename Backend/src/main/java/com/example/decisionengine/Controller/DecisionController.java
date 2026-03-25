package com.example.decisionengine.Controller;

import com.example.decisionengine.Dto.Request.DecisionRequest;
import com.example.decisionengine.Dto.Response.DecisionResponse;
import com.example.decisionengine.Service.DecisionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decision")
public class DecisionController {

    private final DecisionService decisionService;

    public DecisionController(DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @PostMapping
    public DecisionResponse calculate(@RequestBody DecisionRequest request) {
        return decisionService.calculateDecision(request);
    }

}
