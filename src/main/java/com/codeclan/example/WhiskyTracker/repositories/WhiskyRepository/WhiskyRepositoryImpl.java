package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskiesFromDistilleryWithAge(Long distillery_id, int age){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);
//        cr.createAlias("distillery", "distilleryAlias");
        cr.add(Restrictions.eq("distillery.id", distillery_id));
        cr.add(Restrictions.eq("age", age));
        result = cr.list();
        return result;
    }

    @Transactional
    public List<Whisky> findWhiskiesByRegion(String region){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);
        cr.createAlias("distillery", "distilleryAlias");
        cr.add(Restrictions.eq("distilleryAlias.region", region));
        result = cr.list();
        return result;
    }

}
