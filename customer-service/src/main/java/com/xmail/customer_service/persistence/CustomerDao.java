package com.xmail.customer_service.persistence;

import com.xmail.model.customer.CustomerInformation;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

private final SqlSession sqlSession;


    public CustomerDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    public List<CustomerInformation> getAllCustomerWithoutFilter(){
        return this.sqlSession.selectList("getAllCustomerWithoutFilter");
    }
}
