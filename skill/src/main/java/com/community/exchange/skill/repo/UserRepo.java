package com.community.exchange.skill.repo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.community.exchange.skill.DAO.Message;
import com.community.exchange.skill.DAO.Skill;
import com.community.exchange.skill.DAO.User;
import com.community.exchange.skill.exception.UserNotFoundException;

@Repository
public class UserRepo {

	@Autowired JdbcTemplate jdbcTemplate;
	public void addUser(User user) {
		String query="INSERT INTO skill.user"
				+ "(userName,"
				+ "password,"
				+ "firstName,"
				+ "lastName,"
				+ "email,"
				
				+ "address)"
				+ "VALUES    (?,?,?,?,?,?)";
				
		
		jdbcTemplate.update(query, user.getUserName(),user.getPassword(),
				user.getFirstName(),user.getLastName(),
				user.getEmail(),user.getAddress());
		
		
	}

	
	public User searchUserByName(String userName) throws UserNotFoundException {
		String query= "select userName,password,firstName,lastName,email,address from USER where userName=?";
		 List<User> users = null;

		    try {
		        // Use queryForList method to get a List<User> result
		        users = jdbcTemplate.query(query, userRowmapper, userName);
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw new UserNotFoundException("userName and password are invalid.");
		    }

		    // Check if the list is not empty before accessing the first element
		    if (users != null && !users.isEmpty()) {
		        return users.get(0); // Return the first user in the list
		    } else {
		        // Handle the case where no user is found
		        throw new UserNotFoundException("User not found.");
		    }
		
	}
    private static final RowMapper<User> userRowmapper = (rs, rowNum) ->{
        User user = new User();
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
       user.setFirstName(rs.getString("firstName"));
       user.setLastName(rs.getString("lastName"));
       user.setEmail(rs.getString("email"));
       user.setAddress(rs.getString("address"));
        return user;
    };
	public void saveMessage(Message msg) {
		
		String query="INSERT INTO skill.Message"
				+ "(Message,"
				+ "senderName,"
				+ "receiverName,"
				+ "sentTime)"
				+ " VALUES    (?,?,?,?)";
				
		
		jdbcTemplate.update(query, msg.getContent(),msg.getSenderUserName(),msg.getReceiverUserName(),msg.getTimestamp());
			
	}
	
}
