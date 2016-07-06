package com.maq.dao;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.maq.bean.Account;

@Repository
public class AccountDao extends CommonDao<Account> {
	private Query query;

	@Override
	protected Class<Account> getEntityClass() {
		return Account.class;
	}

	public boolean isUsed(Account account) {
		String email = account.getEmail();
		String phone = account.getPhone();

		// 查找是否已存在该注册号码/邮箱，存在则不能注册
		if (email != null) {
			query = new Query(Criteria.where("email").is(email));
		} else if (phone != null) {
			query = new Query(Criteria.where("phone").is(phone));
		}
		Account account2 = queryOne(query);
		if (account2==null) {
			return false;
		}
		return true;
	}

}
