package com.example.decisionengine.Service;

import org.springframework.stereotype.Service;

@Service
public class CreditService {

    public int getCreditModifier(String personalCode) {

        if (personalCode.equals("49002010965")) {
            return -1;
        }

        if (personalCode.equals("49002010976")) {
            return 100;
        }

        if (personalCode.equals("49002010987")) {
            return 300;
        }

        if (personalCode.equals("49002010998")) {
            return 1000;
        }

        return 0;
    }
}
