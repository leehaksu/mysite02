package com.jx372.exception;

public class UserDaoException extends RuntimeException{
	
	private static final long serialVersionUID = 3417361978108746034L;
	
	public UserDaoException ()
	{
		super("UserDao Exception Occured");
	}
	
	public UserDaoException(String message)
	{
		super(message);
	}

}
