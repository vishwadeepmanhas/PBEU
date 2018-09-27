package com.pbeu.encryptor;


import java.io.IOException;
import java.io.StreamTokenizer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncryptedPwdGenerator {

    public static final String AES = "AES";

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }

    private static byte[] hexStringToByteArray(String s) {
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }

    public static String EncryptPassword(String Key,String Plainpassword) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {
        //String key = "DB99A2A8EB6904F492E9DF0595ED683C";
        //String password = "Admin";

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please Enter Key:");
//        String key = scanner.next();
//        System.out.println("Please Enter Plain Text Password:");
//        String password = scanner.next();
    	
    	String key = Key;
    	String password = Plainpassword;
    	

        byte[] bytekey = hexStringToByteArray(key);
        SecretKeySpec sks = new SecretKeySpec(bytekey, EncryptedPwdGenerator.AES);
        Cipher cipher = Cipher.getInstance(EncryptedPwdGenerator.AES);
        cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
        byte[] encrypted = cipher.doFinal(password.getBytes());
        String encryptedpwd = byteArrayToHexString(encrypted);
        System.out.println("****************  Encrypted Password  ****************");
        System.out.println(encryptedpwd);
        System.out.println("****************  Encrypted Password  ****************");
        return encryptedpwd;

    }
}