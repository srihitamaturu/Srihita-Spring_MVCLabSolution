package com.greatlearning.debateevent.dataservice;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.debateevent.domain.entities.Student;

@Service
public class StudentDataServiceImpl implements StudentDataService {

	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	public StudentDataServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}
	
	@Override
	public List<Student> findAll() {
		Transaction transaction = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		transaction.commit();
		return students;
	}

	@Override
	@Transactional
	public Student findById(int id) {
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, id);
		transaction.commit();
		return student;
	}

	@Override
	public void persist(Student student) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(student);
		transaction.commit();
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		transaction.commit();
	}

}
