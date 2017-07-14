package springProject.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.season.springproject.dao.UserDAO;
import br.com.season.springproject.entity.User;
import springProject.config.TestJPAContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestJPAContextConfiguration.class }) // teste banco
@Transactional
@Rollback
public class UserTest {

	@Autowired
	private UserDAO dao;
	
	@Test
	public void shouldSaveNewUser(){
		
		User user = new User();
		user.setSobrenome("Teste");
		user.setNome("TesteName");
		
		dao.save(user);
		
		Assert.assertNotNull(user.getId());
		
	}
	

}
