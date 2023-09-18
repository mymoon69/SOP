package com.example.week6.Repository;

import com.example.week6.POJO.Wizard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository //บอกว่าเป็น Spring Bean จัดการ Persistence Layer
public interface WizardRepository extends MongoRepository<Wizard, String> {
    @Query(value = "{_id:  '?0'}")
    public Wizard getWizardById(String _id);
}
