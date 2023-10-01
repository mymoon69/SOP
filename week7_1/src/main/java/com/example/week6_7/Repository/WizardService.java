package com.example.week6_7.Repository;

import com.example.week6_7.POJO.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WizardService {
    @Autowired
    private WizardRepository repository;

    public WizardService (WizardRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "Wizard") //select
    public List<Wizard> retrieveWizards() {
        return repository.findAll();
    }

    @CacheEvict(value = "Wizard", allEntries = true) //insert, delete
    public Wizard addWizard (Wizard wizard) {
        return repository.save(wizard);
    }

    @CacheEvict(value = "Wizard", allEntries = true) //insert, delete
    public void deleteWizard (String id) {
        repository.deleteById(id);
    }

    @CachePut(value = "Wizard")
    public Wizard updateWizard (Wizard wizard) {
        return repository.save(wizard);
    }

}
