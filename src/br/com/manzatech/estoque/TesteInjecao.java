package br.com.manzatech.estoque;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TesteInjecao {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("./applicationContext.xml");
		

		GerenciadorDeProduto gerenciadorDeProduto = context.getBean("gerenciadorProduto", GerenciadorDeProduto.class);

		// cria um Produto como se o usuário tivesse preenchido um formulário
		Produto produto = new Produto();
		produto.setDescricao("Livro Spring in Action");
		produto.setQuantidade(10);

		gerenciadorDeProduto.novoProduto(produto);

		// verifica que o produto foi adicionao ao nosso dao em memoria
		for (Produto p : gerenciadorDeProduto.getProdutos()) {
			System.out.println("Descricao: " + p.getDescricao());
			System.out.println("Quantidade: " + p.getQuantidade());
		}
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
