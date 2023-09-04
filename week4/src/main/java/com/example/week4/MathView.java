package com.example.week4;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index1")
public class MathView extends VerticalLayout {
    private TextField num1, num2, ans;
    private Button Plus, Minus, Multiply, Divide, Mod, Max;

    public MathView() {
        num1 = new TextField("Number 1");
        num2 = new TextField("Number 2");
        ans = new TextField("Answer");

        Text op = new Text("Operator");

        HorizontalLayout h1 = new HorizontalLayout();
        Plus = new Button("+");
        Minus = new Button("-");
        Multiply = new Button("X");
        Divide = new Button("/");
        Mod = new Button("Mod");
        Max = new Button("Max");
        h1.add(Plus, Minus, Multiply, Divide, Mod, Max);
        this.add(num1,num2, op,h1,ans);

        Plus.addClickListener(event -> {
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String out = WebClient.create()
                    .get().uri("http://localhost:8080/plus/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });
        Minus.addClickListener(event -> {
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String out = WebClient.create()
                    .get().uri("http://localhost:8080/minus/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });
        Multiply.addClickListener(event -> {
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String out = WebClient.create()
                    .get().uri("http://localhost:8080/multi/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });
        Divide.addClickListener(event -> {
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String out = WebClient.create()
                    .get().uri("http://localhost:8080/divide/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });
        Mod.addClickListener(event -> {
            double n1 = Double.parseDouble(num1.getValue());
            double n2 = Double.parseDouble(num2.getValue());

            String out = WebClient.create()
                    .get().uri("http://localhost:8080/mod/"+n1+"/"+n2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });
        Max.addClickListener(event -> {
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("n1", num1.getValue());
            formData.add("n2", num2.getValue());

            String out = WebClient.create()
                    .post().uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ans.setValue(out);
        });
    }
}