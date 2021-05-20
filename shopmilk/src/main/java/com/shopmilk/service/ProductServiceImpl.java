package com.shopmilk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopmilk.entities.Product;
import com.shopmilk.repository.ProductRepo;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public List<Product> search(String q) {
		// TODO Auto-generated method stub
		return productRepo.findByNameContaining(q);
	}

	@Override
	public Product findOne(int id) {
		// TODO Auto-generated method stub
		return productRepo.findOne(id);
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productRepo.save(product);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productRepo.delete(id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> searchByCateID(int id) {
		// TODO Auto-generated method stub
		String query = "from Product where category.id = " + id;
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> SearchByPriceRange(long from, long to) {
		// TODO Auto-generated method stub
		String query = "from Product where price between " + from + " and " + to;
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> SearchByCateAndPriceRange(int id, long from, long to) {
		// TODO Auto-generated method stub
		String query = "from Product where category.id = " + id + " and price between " + from + " and " + to;
		return sessionFactory.getCurrentSession().createQuery(query).list();
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tst = session.beginTransaction();
		try {
			session.update(product);
			tst.commit();
		} catch (Exception e) {
			tst.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object> getByBestSeller(int topNumber) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT product_id, product.name, " + "product.price, product.image, COUNT(product_id) "
				+ "FROM order_detail JOIN product on order_detail.product_id = product.id "
				+ "GROUP BY product_id order BY COUNT(product_id) DESC LIMIT " + topNumber;
		return session.createSQLQuery(sql).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getByMostViews(int topNumber) {
		// TODO Auto-generated method stub
		String hql = "FROM Product ORDER BY views DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(topNumber);
		return query.list();
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		String hql = "FROM Product WHERE name = '" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Product) query.list().get(0);
	}

}
