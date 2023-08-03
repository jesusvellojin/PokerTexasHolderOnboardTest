package com.Pruebatecnica.PokerTexasHolderOnboardTest.controller;

import com.Pruebatecnica.PokerTexasHolderOnboardTest.model.Card;
import com.Pruebatecnica.PokerTexasHolderOnboardTest.model.Hand;
import com.Pruebatecnica.PokerTexasHolderOnboardTest.model.ManoGanadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class HandController {
    @Autowired
    private Card card;
    Logger logger = Logger.getLogger(HandController.class.getName());
@GetMapping("//poker/validation")
    public String hacerAlgo(){

        return "hola";
    }

    @PostMapping("/poker/validation")
    public ManoGanadora leerMano(@RequestBody Hand hand){
        logger.info("INGRESA AL METODO findAllRoutes");
        ManoGanadora result = card.Par(hand.getHand1(),hand.getHand2());
        return result;

    }

}
