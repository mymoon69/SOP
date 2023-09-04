package com.example.week4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index2")
public class CashierView extends VerticalLayout {
    private TextField money, n1000, n500, n100, n20, n10, n5, n1;
    private Button btn;

    public CashierView(){
        money = new TextField("เงินทอน");
        money.setPrefixComponent(VaadinIcon.DOLLAR.create());

        btn = new Button("คำนวณเงินทอน");

        n1000 = new TextField();
        n1000.setPrefixComponent(new Span("$ 1000:"));
        n500 = new TextField();
        n500.setPrefixComponent(new Span("$ 500:"));
        n100 = new TextField();
        n100.setPrefixComponent(new Span("$ 100:"));
        n20 = new TextField();
        n20.setPrefixComponent(new Span("$ 20:"));
        n10 = new TextField();
        n10.setPrefixComponent(new Span("$ 10:"));
        n5 = new TextField();
        n5.setPrefixComponent(new Span("$ 5:"));
        n1 = new TextField();
        n1.setPrefixComponent(new Span("$ 1:"));
        
        this.add(money, btn, n1000, n500, n100, n20, n10, n5, n1);

        btn.addClickListener(event -> {
            int mymoney = Integer.parseInt(money.getValue());
            Change out = WebClient.create()
                    .get().uri("http://localhost:8080/getChange/"+mymoney)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            n1000.setValue(String.valueOf(out.getB1000()));
            n500.setValue(String.valueOf(out.getB500()));
            n100.setValue(String.valueOf(out.getB100()));
            n20.setValue(String.valueOf(out.getB20()));
            n10.setValue(String.valueOf(out.getB10()));
            n5.setValue(String.valueOf(out.getB5()));
            n1.setValue(String.valueOf(out.getB1()));
        });
    }
}
