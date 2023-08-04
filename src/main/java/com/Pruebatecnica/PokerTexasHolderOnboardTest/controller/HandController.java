package com.Pruebatecnica.PokerTexasHolderOnboardTest.controller;

import com.Pruebatecnica.PokerTexasHolderOnboardTest.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin
@RestController
public class HandController {

    @Autowired
    private TwoPair twoPair;
    @Autowired
    private TreeCard treeCard;
    @Autowired
    private Poker poker;
    Logger logger = Logger.getLogger(HandController.class.getName());
@GetMapping("//poker/validation")
    public String hacerAlgo(){

        return "hola";
    }

    @PostMapping("/poker/validation")
    public ManoGanadora leerMano(@RequestBody Hand hand){
        logger.info("INGRESA AL METODO findAllRoutes");
        //ManoGanadora result = card.Par(hand.getHand1(),hand.getHand2());
        //ManoGanadora result1 =parDos.doblePar(hand.getHand1(),hand.getHand2());
        //ManoGanadora result1=treeCard.treeCar(hand.getHand1(),hand.getHand2());
        ManoGanadora result1=poker.poker(hand.getHand1(),hand.getHand2());

        return result1;

    }

}
