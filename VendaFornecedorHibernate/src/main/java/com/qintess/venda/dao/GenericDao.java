package com.qintess.venda.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import com.qintess.venda.hibernate.config.HibernateConfig;

public class GenericDao<T, ID extends Serializable> {

	protected Session session;
	private Class<T> persistedClass;
	
	public GenericDao() {
	}
	public GenericDao(Class<T> persistedClass) {
		this.persistedClass = persistedClass;
	}
	
	private Session getSession() {
		return session = HibernateConfig.getSessionFactory().openSession();
	}
	
	public T persistir(T entidade) {
		try (Session ses = getSession()){
		ses.getTransaction().begin();
		ses.persist(entidade);
		ses.flush();
		ses.getTransaction().commit();
		return entidade;
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public T atualizar(T entidade) {
		try (Session ses = getSession()){
		ses.getTransaction().begin();
		ses.merge(entidade);
		ses.flush();
		ses.getTransaction().commit();
		return entidade;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public T encontrarPorId(ID id) {
		try (Session ses = getSession()){
		return session.find(persistedClass, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<T> encontrarTodos(){
		try (Session ses = getSession()){
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return session.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void deletar(T entity) {
		try (Session ses = getSession()){
		ses.getTransaction().begin();
		ses.remove(entity);
		ses.flush();
		ses.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
