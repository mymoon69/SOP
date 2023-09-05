package com.example.week6;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "mainPage.it")
public class MainWizardView extends VerticalLayout {
    private TextField name, money;
    private RadioButtonGroup<String> gender;
    private ComboBox<String> position, school, house;
    private Button back, create, update, delete, next;

    public MainWizardView(){
        name = new TextField();
        name.setPlaceholder("Fullname");
        money = new TextField("Dollars");
        money.setPrefixComponent(new Span("$"));

        gender = new RadioButtonGroup<>();
        gender.setItems("Male", "Female");
        gender.setLabel("Gender : ");

        position = new ComboBox<>();
        position.setItems("Student", "Teacher");
        position.setPlaceholder("position");
        school = new ComboBox<>();
        school.setItems("Hogwarts", "Beauxbatons", "Durmstrang");
        school.setPlaceholder("School");
        house = new ComboBox<>();
        house.setItems("Gryffindor", "Ravenclaw", "Hufflepuff", "Slyther");
        house.setPlaceholder("House");

        HorizontalLayout h1 = new HorizontalLayout();
        back = new Button("<<");
        create = new Button("Create");
        update = new Button("Update");
        delete = new Button("Delete");
        next = new Button(">>");
        h1.add(back, create, update, delete, next);

        this.add(name, gender, position, money, school, house, h1);
    }
}
