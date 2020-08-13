package com.easyblueapp.secureapp.util;

public class SendEmailTask {
	
	public SendEmailTask () {
		
	}
	
	@SuppressWarnings("finally")
	public String doUselessWork() {
		System.out.println(Thread.currentThread().getName());
		int result = 0;
		try {
			result = 1 +(int)(Math.random() * 100);
			Thread.sleep(1000);
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}finally {
			return "Email with random payload "+result;
		}
	}

}
