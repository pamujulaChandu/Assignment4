package com.javatechie.spring.orm.api.dao;


import com.javatechie.spring.orm.api.model.Person;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonDao {

  @Autowired
  private SessionFactory factory;
  
  public void savePerson(Person person)
  {
    getSession().save(person);
  }
  
  @SuppressWarnings("unchecked")
  public List<Person> getPerson()
  {
    return  getSession().createCriteria(Person.class).list();
  }
  private Session getSession(){
    Session session = factory.getCurrentSession();
    if(session == null)
    {
      session = factory.openSession();
    }
    return  session;
  }

}