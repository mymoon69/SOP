package com.example.week6.Repository;

import com.example.week6.POJO.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WizardService {
    @Autowired
    private WizardRepository repository;

    public WizardService (WizardRepository repository) {
        this.repository = repository;
    }

    public List<Wizard> retrieveWizards() {
        return repository.findAll();
    }

    public Wizard addWizard (Wizard wizard) {
        return repository.save(wizard);
    }

    public void deleteWizard (String id) {
        repository.deleteById(id);
    }

    public Wizard updateWizard (Wizard wizard) {
        return repository.save(wizard);
    }

}
