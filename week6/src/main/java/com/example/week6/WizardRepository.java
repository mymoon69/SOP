package com.example.week6;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WizardRepository extends MongoRepository<Wizard, String> {
//    @Query(value = "{name:  '?0'}")
//    public Wizard findByName (String name);
//
//    @Query(value = "{name:  '?0'}", fields = "{'_id': 0, 'price':  1}")
//    public Wizard findByName2 (String name);
}
