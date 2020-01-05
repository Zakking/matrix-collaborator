package com.humanup.matrixcollaborator.dao;

import com.humanup.matrixcollaborator.dao.entities.Project;
import com.humanup.matrixcollaborator.dao.entities.Situation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SituationDAO extends CrudRepository<Situation, Long> {

    List<Situation> findAll();
    Project findBySituationId(long situationId);
    Project findBySituationTitle(String situationTitle);
}
