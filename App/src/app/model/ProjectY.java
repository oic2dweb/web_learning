package app.model;

import java.security.SecureRandom;

public class ProjectY {
	 private String str;
	 private String randpass;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str+"yokota";
	}

	public String getRandPass() {
		return randpass;
	}

	public void setRandPass() {
		SecureRandom random = new SecureRandom();
		char[] pass = new char[12];
		for(int k = 0; k < pass.length; k++){
			switch (random.nextInt(2)){
			case 0: // 'a' - 'z'
				pass[k] = (char)(97 + random.nextInt(26));
				break;
				case 1: // '0' - '9'
				pass[k] = (char)(48 + random.nextInt(10));
				break;
			}
		}
		System.out.println(pass);
		this.randpass = String.valueOf(pass);
		System.out.println(randpass);
	}


}
