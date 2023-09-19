package com.example.week6.View;

import com.example.week6.POJO.Wizard;
import com.example.week6.POJO.Wizards;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import com.vaadin.flow.component.notification.Notification;

import java.util.ArrayList;
import java.util.List;

@Route(value = "mainPage.it")
public class MainWizardView extends VerticalLayout {
    private TextField name, money;
    private RadioButtonGroup<String> gender;
    private ComboBox<String> position, school, house;
    private Button back, create, update, delete, next;
    private Wizards data;
    private int index = 0;

    public MainWizardView(){
        data = new Wizards();
        name = new TextField();

        WizardData();
        name.setPlaceholder("Fullname");
        name.setValue(data.getModel().get(index).getName());

        money = new TextField("Dollars");
        money.setPrefixComponent(new Span("$"));
        money.setValue(data.getModel().get(index).getMoney());

        gender = new RadioButtonGroup<>("Gender :");
        gender.setItems("Male", "Female");
        if (data.getModel().get(index).getSex().equals("m")) {
            this.gender.setValue("Male");
        } else if (data.getModel().get(index).getSex().equals("f")) {
            this.gender.setValue("Female");
        }

        position = new ComboBox<>();
        position.setItems("Student", "Teacher");
        position.setPlaceholder("position");
        position.setValue(data.getModel().get(index).getPosition());

        school = new ComboBox<>();
        school.setItems("Hogwarts", "Beauxbatons", "Durmstrang");
        school.setPlaceholder("School");
        school.setValue(data.getModel().get(index).getSchool());

        house = new ComboBox<>();
        house.setItems("Gryffindor", "Ravenclaw", "Hufflepuff", "Slyther");
        house.setPlaceholder("House");
        house.setValue(data.getModel().get(index).getHouse());

        HorizontalLayout h1 = new HorizontalLayout();
        back = new Button("<<");
        create = new Button("Create");
        update = new Button("Update");
        delete = new Button("Delete");
        next = new Button(">>");
        h1.add(back, create, update, delete, next);

        this.add(name, gender, position, money, school, house, h1);

        //add
        create.addClickListener(event -> {
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("name", name.getValue());
            if (gender.getValue() == "Male") {
                formData.add("gender", "m");
            } else if (gender.getValue() == "Female") {
                formData.add("gender", "f");
            }
//            formData.add("gender", gender.getValue());
            formData.add("position", position.getValue());
            formData.add("money", money.getValue());
            formData.add("school", school.getValue());
            formData.add("house", house.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/addWizard")
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve().bodyToMono(String.class).block();
            //เอาไว้ index สุดท้าย
            this.index = this.WizardData().size() - 1;
            //save ค่า
            this.data.setModel((ArrayList<Wizard>) this.WizardData());
            new Notification(out, 10000).open();
        });
        update.addClickListener(event -> {
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("id", data.getModel().get(index).get_id());
            formData.add("name", name.getValue());
            if (gender.getValue() == "Male") {
                formData.add("gender", "m");
            } else if (gender.getValue() == "Female") {
                formData.add("gender", "f");
            }
//            formData.add("gender", gender.getValue());
            formData.add("position", position.getValue());
            formData.add("money", money.getValue());
            formData.add("school", school.getValue());
            formData.add("house", house.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/updateWizard")
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve().bodyToMono(String.class).block();
            this.data.setModel((ArrayList<Wizard>) this.WizardData());
            new Notification(out, 10000).open();
        });

        delete.addClickListener(event -> {
            String out = WebClient.create().post()
                    .uri("http://localhost:8080/daleteWizard/" + data.getModel().get(index).get_id())
                    .retrieve().bodyToMono(String.class)
                    .block();
            this.data.setModel((ArrayList<Wizard>) this.WizardData());
            new Notification(out, 1000).open();
        });

        next.addClickListener(event -> {
            this.index++;
           if (this.index >= this.data.getModel().toArray().length) {
               this.index = this.WizardData().size()-1;
           }

            name.setValue(data.getModel().get(index).getName());
//            gender.setValue(data.getModel().get(index).getSex());
            if (data.getModel().get(index).getSex().equals("m")) {
                this.gender.setValue("Male");
            } else if (data.getModel().get(index).getSex().equals("f")) {
                this.gender.setValue("Female");
            }
            position.setValue(data.getModel().get(index).getPosition());
            money.setValue(data.getModel().get(index).getMoney());
            school.setValue(data.getModel().get(index).getSchool());
            house.setValue(data.getModel().get(index).getHouse());
        });

        back.addClickListener(event -> {
            this.index--;
            if (this.index < 0) {
                this.index = 0;
            }

            name.setValue(data.getModel().get(index).getName());
//            gender.setValue(data.getModel().get(index).getSex());
            if (data.getModel().get(index).getSex().equals("m")) {
                this.gender.setValue("Male");
            } else if (data.getModel().get(index).getSex().equals("f")) {
                this.gender.setValue("Female");
            }
            position.setValue(data.getModel().get(index).getPosition());
            money.setValue(data.getModel().get(index).getMoney());
            school.setValue(data.getModel().get(index).getSchool());
            house.setValue(data.getModel().get(index).getHouse());
        });
    }

    // โชว์ข้อมูล
    public List<Wizard> WizardData(){
        List<Wizard> output = WebClient.create()
                .get()
                .uri("http://localhost:8080/wizards")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Wizard>>() {})
                .block();
        this.data.setModel((ArrayList<Wizard>) output);
        return output;
    }
}
