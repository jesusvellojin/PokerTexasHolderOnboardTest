package com.Pruebatecnica.PokerTexasHolderOnboardTest.controller;

import com.Pruebatecnica.PokerTexasHolderOnboardTest.model.*;
import com.Pruebatecnica.PokerTexasHolderOnboardTest.service.Poker;
import com.Pruebatecnica.PokerTexasHolderOnboardTest.service.TreeCard;
import com.Pruebatecnica.PokerTexasHolderOnboardTest.service.TwoPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RestController
public class HandController {

    @Autowired
    private TwoPair twoPair;
    @Autowired
    private TreeCard treeCard;
    @Autowired
    private Poker poker;


    @PostMapping("/poker/validation")
    public ManoGanadora leerMano(@RequestBody Hand hand){

        ManoGanadora result=poker.poker(hand.getHand1(),hand.getHand2());

        return result;

    }

}
