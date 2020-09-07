package com.cibeg.getinfo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//import org.json.simple.*;

@Repository
public class CustomerRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<String[]> getAllCustNum(String cnum) {
		
		List<String[]> custNum = new ArrayList<>();
		custNum.addAll(jdbcTemplate.query("select ACCOUNT_KEY ,PHONE_NO , PHONE_TYPE ,POLICY_PRODUCT_NO ,LAST_UPDATED_DATE from CUSTOMER_SAMP where CUSTOMER_KEY  =" + cnum
				, (rs, rowNum) -> new String[] {"Account_key: " + rs.getString(1), "PHONE_NO: "+rs.getString(2),"PHONE_TYPE: "+rs.getString(3),"POLICY_PRODUCT_NO: "+rs.getString(4),"LAST_UPDATED_DATE: "+rs.getString(5)}));
		
		
		return custNum;
	}

	public List<String[]> getCustAct(String cnum) {
		List<String[]> custActDetails = new ArrayList<String[]>();
		custActDetails.addAll(jdbcTemplate.query("select cust.CRNM , cust.BBCNA1 , cust.BBCNA3 , act.TACNO , act.CCY , act.BRCA , act.LDBL/100 from T24CUSPF cust , T24ACCPF act where cust.TCNUM = act.TCNUM and cust.TCNUM = " + cnum
				, (rs, rowNum) -> new String[] {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)}));
		return custActDetails;
	}

	public List<String[]> getActDetails(String actNum) {
		List<String[]> actNumber = new ArrayList<String[]>();
		actNumber.addAll(jdbcTemplate.query("Select TCNUM from T24ACCPF where TACNO = "+ actNum,
				(rs, rowNum) -> new String[] {rs.getString(1)}));
		return actNumber;
	}
	
	
//	public List<int[]> getActDetails(int actNum) {
//		List<int[]> actDetails = jdbcTemplate.query("select TCNUM , ccy from T24ACCPF where TACNO =" + actNum
//				, (rs, rowNum) -> new String[] {rs.getString(1), rs.getString(2)});
//		 return actDetails;
//	select CUST_TYP_KEY  , LD_DT from DP_T3.CUSTOMER_SAMP where CUST_KEY =" + cnum
	//select cust.CRNM , cust.BBCNA1 , cust.BBCNA3 , act.TACNO , act.CCY , act.BRCA , act.LDBL/100 from T24CUSPF cust , T24ACCPF act where cust.TCNUM = act.TCNUM and cust.TCNUM = " + cnum
//		
//	}

}
