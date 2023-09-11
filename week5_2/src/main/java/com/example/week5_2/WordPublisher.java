package com.example.week5_2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class WordPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    protected Word words;

    public WordPublisher(){
        words = new Word();
        this.words.badWords.add("fuck");
        this.words.badWords.add("olo");
        this.words.goodWords.add("happy");
        this.words.goodWords.add("enjoy");
        this.words.goodWords.add("like");
    }

    @RequestMapping(value = {"/addBad/{word}"}, method = {RequestMethod.GET})
    public ArrayList<String> addBadWord(@PathVariable("word") String s){
        words.badWords.add(s);
        return words.badWords;
    }

    @RequestMapping(value = {"/delBad/{word}"}, method = {RequestMethod.GET})
    public ArrayList<String> deleteBadWord(@PathVariable("word") String s){
        words.badWords.remove(s);
        return words.badWords;
    }

    @RequestMapping(value = {"/addGood/{word}"}, method = {RequestMethod.GET})
    public ArrayList<String> addGoodWord(@PathVariable("word") String s){
        words.goodWords.add(s);
        return words.goodWords;
    }

    @RequestMapping(value = {"/delGood/{word}"}, method = {RequestMethod.GET})
    public ArrayList<String> deleteGoodWord(@PathVariable("word") String s){
        words.goodWords.remove(s);
        return words.goodWords;
    }

    @RequestMapping(value = {"/proof/{sentence}"}, method = {RequestMethod.GET})
    public String proofSentence(@PathVariable("sentence") String s){
        boolean good = false;
        boolean bad = false;

        // check good words
        for (int i = 0; i < this.words.goodWords.size(); i++) {
            if (s.contains(this.words.goodWords.get(i))){
                good = true;
            }
        }
        // check bad words
        for (int i = 0; i < this.words.badWords.size(); i++) {
            if (s.contains(this.words.badWords.get(i))){
                bad = true;
            }
        }

        if (good&&bad){
            rabbitTemplate.convertAndSend("Fanout", "", s);
            System.out.println("Found Bad & Good Word");
            return "Found Bad & Good Word";
        }
        else if (good){
            rabbitTemplate.convertAndSend("Direct", "good", s);
            System.out.println("Found Good Word");
            return "Found Good Word";
        } else if (bad) {
            rabbitTemplate.convertAndSend("Direct", "bad", s);
            System.out.println("Found Bad Word");
            return "Found Bad Word";
        }
        return "Don't fond";
    }

    @RequestMapping(value = {"/getSentence"}, method = {RequestMethod.GET})
    public Sentence getSentences(){
        Sentence sentence = (Sentence)rabbitTemplate.convertSendAndReceive("Direct", "queue", "");
        return sentence;
    }
}
