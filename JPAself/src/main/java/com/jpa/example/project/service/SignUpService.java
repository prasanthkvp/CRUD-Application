package com.jpa.example.project.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jpa.example.project.model.SignUpModel;
import com.jpa.example.project.model.response.Response;
import com.jpa.example.project.repository.SignUpRepository;

@Service
public class SignUpService {
	@PersistenceContext
	private EntityManager EMmanger;
	Response res = new Response();
	@Autowired
	private SignUpRepository repo;

	public Response createUser(SignUpModel datas) {
		System.out.println(datas);

		String one = UUID.randomUUID().toString();
		datas.setsNo(one);
		datas.setCreatedBy(one);
		datas.setUpdatedBy(one);

		Date two = new Date(Calendar.getInstance().getTime().getTime());
		datas.setCreatedDate(two);
		datas.setUpdatedDate(two);
		try {
			repo.save(datas);
			res.setResponseCode(200);
			res.setResponseMgs("Success");
			res.setData("user created Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode(500);
			res.setResponseMgs("error");
			res.setData("error");
		}

		return res;
	}

	public Response findall() {

		try {

			res.setResponseCode(200);
			res.setResponseMgs("Success");
			res.setData("user login Successfully");
			res.setjData(repo.findAll());

		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode(500);
			res.setResponseMgs("error");
			res.setData("error");
		}
		return res;
	}

	public Response getone(String sNo) {
		try {
			res.setResponseCode(200);
			res.setResponseMgs("Success");
			res.setData("user login Successfully");
			res.setjData(repo.findById(sNo));

		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode(500);
			res.setResponseMgs("Error");
			res.setData("Server Error");
		}
		return res;
	}

/////////////////////////////////////////////////////////////////////
	public Response updateUser(SignUpModel datas) {
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		datas.setUpdatedDate(date);
		try {
			Optional<SignUpModel> optiUser = repo.findById(datas.getsNo());
			SignUpModel user = optiUser.get();

			user.setMail(datas.getMail());
			user.setFullName(datas.getFullName());
			user.setUpdatedDate(datas.getUpdatedDate());
			repo.save(user);

			res.setResponseCode(200);
			res.setResponseMgs("Success");
			res.setData("user updated Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode(500);
			res.setResponseMgs("Error");
			res.setData("server error");
		}
		return res;
	}

	public Response loginUser(String mail, String password) {
		try {

			Query query = EMmanger
					.createQuery("SELECT u FROM SignUpModel u WHERE u.mail = :mail AND u.password=:password");
			query.setParameter("mail", mail);
			query.setParameter("password", password);

			@SuppressWarnings("unchecked")
			List<SignUpModel> user = query.getResultList();
			if (user.isEmpty()) {
				res.setResponseCode(500);
				res.setResponseMgs("Error");
				res.setData("User Does Not Exist!");
			} else {
				res.setResponseCode(200);
				res.setResponseMgs("Success");
				res.setData("user login Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode(500);
			res.setResponseMgs("Error");
			res.setData("server error");
		}
		return res;
	}

	public Response todelete(String sNo) {
		try {
			repo.deleteById(sNo);
			res.setResponseCode(200);
			res.setResponseMgs("deleted");
			res.setData("details were deleted");

		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode(500);
			res.setResponseMgs("Error");
			res.setData("not deleted");
		}

		return res;
	}
}