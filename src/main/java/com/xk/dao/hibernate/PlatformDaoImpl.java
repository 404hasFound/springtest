package com.xk.dao.hibernate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xk.entity.MyUser;
import com.xk.entity.User;

@Repository
public class PlatformDaoImpl extends BaseDaoHibernate
{
    @Autowired
    private SessionFactory authsessionFactory;
    
    public List addOperatAudit(Object[] map){
        String sql = "select * from CEN_REG.ORDERWEB_MD_ORG";
        SQLQuery query = this.createSQLQuery(sql, null, null, null);
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }
    
    public MyUser getUserById(String id){
    	String hql = "from MyUser";
    	//MyUser users = (MyUser) super.authsessionFactory.getCurrentSession().createQuery(hql).setString(0, "2").list().get(0);
    	//MyUser user = (MyUser) super.authsessionFactory.getCurrentSession().get(MyUser.class, "2");
    	/*super.authsessionFactory.getCurrentSession().flush();  更新到数据库
    	super.authsessionFactory.getCurrentSession().refresh(MyUser.class);   相当于撤回操作  把快照的取消*/
    	/*MyUser users = new MyUser();
    	users.setId("2");
    	users.setPassword("123");
    	users.setUsername("addddd");
    	super.authsessionFactory.getCurrentSession().saveOrUpdate(users);
    	super.authsessionFactory.getCurrentSession().flush();
    	String hql = "from MyUser Where id=?";
    	MyUser users = (MyUser) super.authsessionFactory.getCurrentSession().createQuery(hql).setString(0, "2").list().get(0);
    	super.authsessionFactory.getCurrentSession().evict(users);
    	user.setUsername("我是修改的name");*/
    	//MyUser user = (MyUser) super.authsessionFactory.getCurrentSession().get(MyUser.class, "1342323");
    	/*MyUser users = new MyUser();
    	users.setId("134");
    	users.setPassword("12323111111");
    	users.setUsername("addddd");
    	super.authsessionFactory.getCurrentSession().persist(users);
    	
    	System.out.println(users.getDescn());*/
    	//super.authsessionFactory.getCurrentSession().clear();
    	//List<MyUser> myuser = super.authsessionFactory.getCurrentSession().createQuery(hql).list();
    	/*Iterator<MyUser> user = super.authsessionFactory.getCurrentSession().createQuery(hql).iterate();
    	while(user.hasNext()){
    		System.out.println(user.next().getUsername());
    	}*/
    	Session opensession = super.authsessionFactory.openSession();
    	User myusers = (User) opensession.get(User.class, "2");
    	MyUser myuser = (MyUser) opensession.get(MyUser.class, "2");
    	List<MyUser> myuserh =  opensession.createQuery("from MyUser").setCacheable(true).list();
    	List<MyUser> myuserhh =  opensession.createQuery("from MyUser").setCacheable(true).list();
    	MyUser userss = (MyUser) opensession.get(MyUser.class, "3");
    	opensession.flush();
    	opensession.close();
    	Session opensession1 = super.authsessionFactory.openSession();
    	User myusers1 = (User) opensession1.get(User.class, "2");
    	MyUser myuser1 = (MyUser) opensession1.get(MyUser.class, "2");
    	List<MyUser> myuserh1 =  opensession1.createQuery("from MyUser").list();
    	opensession1.flush();
    	opensession1.close();
    	return myuser1;
    }
    
    public MyUser getUser(String id){
    	MyUser user = (MyUser) super.authsessionFactory.getCurrentSession().get(MyUser.class, id);
    	return user;
    }
}
