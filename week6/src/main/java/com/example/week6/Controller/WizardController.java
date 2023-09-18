package com.example.week6.Controller;

import com.example.week6.POJO.Wizard;
import com.example.week6.Repository.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class WizardController {
    @Autowired
    private WizardService wizardService;

    @RequestMapping(value = {"/wizards"}, method = {RequestMethod.GET})
    public List<Wizard> getWizards() {
        List<Wizard> wizards = wizardService.retrieveWizards();
        return wizards;
    }

    @RequestMapping(value = {"/addWizard"}, method = {RequestMethod.POST})
    public ResponseEntity<String> addWizard(@RequestBody MultiValueMap<String, String> fromData){
        Map<String, String> data = fromData.toSingleValueMap();
        Wizard wizard = wizardService.addWizard(new Wizard(null, data.get("gender"), data.get("name"), data.get("school"), data.get("house"), data.get("money"), data.get("position")));
        return ResponseEntity.ok("Wizard has been Created");
    }

    @RequestMapping(value = {"/updateWizard"}, method = {RequestMethod.POST})
    public ResponseEntity<String> updateWizard(@RequestBody MultiValueMap<String, String> fromData){
        Map<String, String> data = fromData.toSingleValueMap();
        Wizard wizard = wizardService.addWizard(new Wizard(data.get("id"), data.get("gender"), data.get("name"), data.get("school"), data.get("house"), data.get("money"), data.get("position")));
        return ResponseEntity.ok("Wizard has been Update");
    }

    @RequestMapping(value = {"/daleteWizard/{id}"}, method = {RequestMethod.POST})
    public ResponseEntity<String> deleteWizard(@PathVariable String id) {
        wizardService.deleteWizard(id);
        return ResponseEntity.ok("Wizard has been Delete");
    }
}
