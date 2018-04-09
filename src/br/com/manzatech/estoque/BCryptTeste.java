package br.com.manzatech.estoque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		String x = encoder.encode("senha");
		Logger logger = LoggerFactory.getLogger(BCryptTeste.class);
		logger.info(x);
	}

}
