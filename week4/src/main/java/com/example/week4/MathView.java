package com.example.week4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "index1")
public class MathView extends VerticalLayout {
    private TextField tf1, tf2, tf3;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide, btnMod, btnMax;

    public MathView() {
        tf1 = new TextField("Number 1");
        tf2 = new TextField("Number 2");
        tf3 = new TextField("Answer");

        HorizontalLayout h1 = new HorizontalLayout();
        btnPlus = new Button("+");
        btnMinus = new Button("-");
        btnMultiply = new Button("X");
        btnDivide = new Button("/");
        btnMod = new Button("Mod");
        btnMax = new Button("Max");
        h1.add(btnPlus, btnMinus, btnMultiply, btnDivide, btnMod, btnMax);
        this.add(tf1,tf2, h1,tf3);
    }
}
