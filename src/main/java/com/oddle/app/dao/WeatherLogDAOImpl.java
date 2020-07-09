package com.oddle.app.dao;

import com.oddle.app.model.WeatherLog;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WeatherLogDAOImpl implements WeatherLogDAO{
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(WeatherLog weatherLog) {
        getSession().save(weatherLog);
    }

    @Override
    public void deleteWeatherLog(Long id) {
        WeatherLog weatherLog = (WeatherLog) getSession().get(WeatherLog.class, id);
        getSession().delete(weatherLog);
    }

    @Override
    public List<WeatherLog> listAllWeatherLog() {
        Criteria criteria = getSession().createCriteria(WeatherLog.class);
        return criteria.list();
    }

}
