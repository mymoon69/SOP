package com.example.week5_2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;


@Route("index2")
public class MyView2 extends HorizontalLayout {
    public Word words = new Word();

    public MyView2(){
        VerticalLayout v1 = new VerticalLayout();

        TextField addWord = new TextField("Add Word");
        Button addGoodWord = new Button("Add Good Word");
        Button addBadWord = new Button("Add Bad Word");

        ComboBox goodWord = new ComboBox("Good Words");
        goodWord.setItems(words.goodWords);

        ComboBox badWord = new ComboBox("Bad Words");
        badWord.setItems(words.badWords);

        v1.add(addWord, addGoodWord, addBadWord, goodWord, badWord);

        VerticalLayout v2 = new VerticalLayout();

        TextField addSentence = new TextField("Add Sentence");
        Button addSen = new Button("Add Sentence");
        TextArea goodSentence = new TextArea("Good Sentences");
        TextArea badSentence = new TextArea("Bad Sentences");
        Button showSentence = new Button("Show Sentence");

        v2.add(addSentence, addSen, goodSentence, badSentence, showSentence);

        this.add(v1, v2);

        addGoodWord.addClickListener(event->{
            String word = addWord.getValue();
            ArrayList out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/addGood/" + word)
                    .retrieve()
                    .bodyToMono(ArrayList.class)
                    .block();
            goodWord.setItems(out);
        });

        addBadWord.addClickListener(event->{
            String word = addWord.getValue();
            ArrayList out = WebClient.create().post().uri("http://localhost:8080/addBad/" + word)
                    .retrieve().bodyToMono(ArrayList.class).block();
            badWord.setItems(out);
        });

        addSen.addClickListener(event->{
            String sentence = addSentence.getValue();
            String out = WebClient.create().post().uri("http://localhost:8080/proof/" + sentence)
                    .retrieve().bodyToMono(String.class).block();
            Notification noti = new Notification(out);
            noti.open();
        });

        showSentence.addClickListener((event->{
            Sentence out = WebClient.create().get().uri("http://localhost:8080/getSentence")
                    .retrieve().bodyToMono(Sentence.class).block();
            goodSentence.setValue(out.goodSentences.toString());
            badSentence.setValue(out.badSentences.toString());
        }));
    }
}