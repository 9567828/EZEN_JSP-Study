package chap06.dto;

import java.util.Date;

public class Members {
	String account_id;
	String account_email;
	String account_pw;
	Date join_date;
	String member_status;
	Character terms_agree;
	String social_login;
	Date change_pw_date;
	
	public Members(String account_id, String account_email, String account_pw, Date join_date, String member_status, Character terms_agree, String social_login, Date change_pw_date) {
		this.account_id = account_id;
		this.account_email = account_email;
		this.account_pw = account_pw;
		this.join_date = join_date;
		this.member_status = member_status;
		this.terms_agree = terms_agree;
		this.social_login = social_login;
		this.change_pw_date = change_pw_date;
	}

	public String getAccount_id() {
		return account_id;
	}

	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}

	public String getAccount_email() {
		return account_email;
	}

	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}

	public String getAccount_pw() {
		return account_pw;
	}

	public void setAccount_pw(String account_pw) {
		this.account_pw = account_pw;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getMember_status() {
		return member_status;
	}

	public void setMember_status(String member_status) {
		this.member_status = member_status;
	}

	public Character getTerms_agree() {
		return terms_agree;
	}

	public void setTerms_agree(Character terms_agree) {
		this.terms_agree = terms_agree;
	}

	public String getSocial_login() {
		return social_login;
	}

	public void setSocial_login(String social_login) {
		this.social_login = social_login;
	}

	public Date getChange_pw_date() {
		return change_pw_date;
	}

	public void setChange_pw_date(Date change_pw_date) {
		this.change_pw_date = change_pw_date;
	}

	@Override
	public String toString() {
		return "Mebers [account_id=" + account_id + ", account_email=" + account_email + ", account_pw=" + account_pw
				+ ", join_date=" + join_date + ", member_status=" + member_status + ", terms_agree=" + terms_agree
				+ ", social_login=" + social_login + ", change_pw_date=" + change_pw_date + "]";
	}
	
}
