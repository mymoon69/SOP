package com.example.week5_2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SentenceConsumer {
    protected Sentence sentences;

    public SentenceConsumer(){
        sentences = new Sentence();
    }

    @RabbitListener(queues = "BadWordQueue")
    public void addBadSentence(String s){
        sentences.badSentences.add(s);
        System.out.println("addBadSentence: " + sentences.badSentences);
    }

    @RabbitListener(queues = "GoodWordQueue")
    public void addGoodSentence(String s){
        sentences.goodSentences.add(s);
        System.out.println("addGoodSentence: " + sentences.goodSentences);
    }

    @RabbitListener(queues = "GetQueue")
    public Sentence getSentences() {
        return this.sentences;
    }
}
