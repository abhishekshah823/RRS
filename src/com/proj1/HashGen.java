package com.proj1;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.io.*;
public class HashGen {

	public static void main(String arg[])throws IOException,NoSuchAlgorithmException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter password for hashing:\n");
		String text=br.readLine();
		String pass=getPass(text);
		System.out.println("Hash value="+pass);
	}
	
	
	 public static String getPass(String passwordToHash)
	    {
	        String generatedPassword = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-512");
	           
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            generatedPassword = sb.toString();
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }
	 
	}

