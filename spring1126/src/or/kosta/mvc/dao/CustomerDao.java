package or.kosta.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.kosta.vo.CustomerVO;

@Repository
public class CustomerDao {
	@Autowired
	private SqlSessionTemplate ss;
	public void addCustomer(CustomerVO v){
		ss.insert("customer.customerAdd",v);
	}
}
