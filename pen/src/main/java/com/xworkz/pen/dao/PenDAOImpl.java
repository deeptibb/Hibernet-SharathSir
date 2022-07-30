package com.xworkz.pen.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.pen.entity.PenEntity;

@Component
public class PenDAOImpl implements PenDAO {
	public PenDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " invoked");
	}

	@Autowired
	private SessionFactory sessionFactory;

	public boolean savePen(PenEntity penEntity) {

		Session session = null;
		boolean flag = false;
		try {

			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			System.out.println("penEntity are  " + penEntity);
			session.save(penEntity);
			System.out.println("penEntity are  " + penEntity);
			transaction.commit();
			flag = true;
		} catch (RollbackException m) {
			System.out.println(m.getMessage());
		} catch (HibernateException n) {
			System.out.println(n.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				System.out.println("Session is closed");
				session.close();

			} else {
				System.out.println("Session is Not closed");
			}
		}

		return flag;

	}

	@Override
	public PenEntity findPenByName(String name) {
		System.out.println("Invoked findPenByName() from PenDAOImpl");
		Session session = null;
		PenEntity penEntity = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createNamedQuery("PenEntity.findPenByName");
			query.setParameter("NAME", name);
			Object object = query.uniqueResult();
			penEntity = (PenEntity) object;

			if (penEntity != null) {
				return penEntity;
			} else {
				System.out.println("PenEntity not found");
			}
		} catch (HibernateException e) {
			System.out.println("HibernateException");
		}

		finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			} else {
				System.out.println("session is not closed");
			}
		}
		return penEntity;
	}

	@Override
	public List<PenEntity> getAllPenDetails() {
		List<PenEntity> list = null;
		System.out.println("DAO UPDATE() START");
		try (Session session = sessionFactory.openSession();) {
			Query query = session.createNamedQuery("PenEntity.getAllDetails");
			list = query.list();
			if (list.size() > 0 && list != null) {
				return list;
			} else {
				System.err.println("Table is Empty");
			}
		}
		return list;
	}
	
	public boolean deletePenByName(String name) {
		System.out.println("delete method started");
		Session session = null;
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createNamedQuery("PenEntity.delete");
			query.setParameter("NAME", name);
			int update = query.executeUpdate();
			if (update > 0) {
				transaction.commit();
				System.out.println(update + " rows deleted ");
				flag = true;
			} else {
				System.out.println("pen not deleted");
			}
		} catch (RollbackException m) {
			System.out.println(m.getMessage());
		} catch (HibernateException n) {
			System.out.println(n.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				System.out.println("Session is closed");
				session.close();

			} else {
				System.out.println("Session is Not closed");
			}
		}

		return flag;

	}
        public boolean updatePenByName(String name) {
		System.out.println("update started");
		Session session = null;
		PenEntity penEntity = null;
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createNamedQuery("PenEntity.update");
			query.setParameter("PENName", name);
			int num = query.executeUpdate();
			if (num > 0) {
				transaction.commit();
				System.out.println(num + " rows updated ");
				flag = true;
			} else {
				System.out.println("pen not updated");
			}
		} catch (RollbackException m) {
			System.out.println(m.getMessage());
		} catch (HibernateException n) {
			System.out.println(n.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				System.out.println("Session is closed");
				session.close();

			} else {
				System.out.println("Session is Not closed");
			}
		}

		return flag;

	}
}