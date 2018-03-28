package br.com.manzatech.estoque;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TesteInjecao2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("./applicationContext.xml");
		SpringBean bean = context.getBean(SpringBean.class);
		if (null != bean) {
			System.out.println("instanciado!");
			System.out.println(bean.getNome());
			System.out.println(bean.getQuantidade());
			System.out.println(bean.getPropriedades().get("cidade"));
			System.out.println(bean.getPropriedades().get("pais"));
			for (String string : bean.getNomes()) {
				System.out.println(string);
			}
		}
		((ClassPathXmlApplicationContext)context).close();
	}

}
