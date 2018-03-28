package br.com.manzatech.estoque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.manzatech.estoque.Produto;
import br.com.manzatech.estoque.dao.ProdutoDao;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	@Qualifier("produtoDaoHibernate")
	private ProdutoDao produtoDao;

	@GetMapping(value = "/mostrar/{id}")
	public String mostrar(@PathVariable Long id, Model model) {
		System.out.println(id);
		model.addAttribute("produto", produtoDao.buscarPorId(id));
		return "produtos/mostrar";
	}

	@RequestMapping()
	public String listar(Model model) {
		model.addAttribute("produtoList", produtoDao.listar());
		return "produtos/lista";
	}

	@GetMapping("/cadastro")
	public String form() {
		return "produtos/form";
	}

	@PostMapping(value = "/salvar")
	public String salvar(Produto produto) {
		produto.setId(produtoDao.listar().size() + 1l);
		produtoDao.salvar(produto);
		return "redirect:/produtos";
	}

}