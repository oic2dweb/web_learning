package app.persistence;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMd5 {
	public String create(String str){
		StringBuilder hashStr = new StringBuilder();
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] hash = digest.digest(str.getBytes("UTF-8"));

			for (int i = 0, l = hash.length; i < l; i++) {
			    int h = hash[i];
			    if (h < 0) {
			        hashStr.append(Integer.toHexString(h + 256));
			    } else {
			        if (h < 16) {
			            hashStr.append("0");
			        }
			        hashStr.append(Integer.toHexString(h));
			    }
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return hashStr.toString();
	}
}
