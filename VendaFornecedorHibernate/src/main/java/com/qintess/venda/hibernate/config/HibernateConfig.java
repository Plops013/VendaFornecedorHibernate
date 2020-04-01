package com.qintess.venda.hibernate.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.venda.model.Fornecedor;
import com.qintess.venda.model.FornecedorProduto;
import com.qintess.venda.model.Produto;
import com.qintess.venda.model.Venda;
import com.qintess.venda.model.VendaItens;

public class HibernateConfig {

private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null) {
			try {
				Configuration configuration = new Configuration();
				Properties prop = new Properties();
				
				prop.put(Environment.DRIVER, "org.postgresql.Driver");
				prop.put(Environment.URL, "jdbc:postgresql://localhost/vendas");
				prop.put(Environment.USER, "postgres");
				prop.put(Environment.PASS, "admin");
				
				//Prestar atenção nisso em banco de dados de produção
				prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				configuration.setProperties(prop);
				
				configuration.addAnnotatedClass(Fornecedor.class);
				configuration.addAnnotatedClass(FornecedorProduto.class);
				configuration.addAnnotatedClass(Produto.class);
				configuration.addAnnotatedClass(Venda.class);
				configuration.addAnnotatedClass(VendaItens.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	
}
