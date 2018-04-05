package br.com.manzatech.estoque.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.manzatech.estoque.Movimentacao;
import br.com.manzatech.estoque.Produto;
import br.com.manzatech.estoque.dao.MovimentacaoDao;
import br.com.manzatech.estoque.dao.ProdutoDao;
import br.com.manzatech.estoque.services.GeradorDeMovimentacao;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	@Qualifier("produtoDaoHibernate")
	private ProdutoDao produtoDao;

	@Autowired
	private GeradorDeMovimentacao geradorDeMovimentacao;
	
	@Autowired
	private MovimentacaoDao movimentacaoDao;
	
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
	public String form(Model model) {
		model.addAttribute(new Produto());
		return "produtos/form";
	}

	@PostMapping(value = "/salvar")
	@Transactional
	public String salvar(@Valid Produto produto, BindingResult result) {
		
		if (result.hasErrors()) {
			return "produtos/form";
		}
		produtoDao.salvar(produto);
		geradorDeMovimentacao.geraMovimentacao(produto);
		
		return "redirect:/produtos";
	}
	
	@Transactional
	@PostMapping("/alterar")
	public String alterar(@Valid Produto produto, BindingResult result) {
		if (result.hasErrors()) {
			return "produtos/editar";
		}
		Movimentacao mov = geradorDeMovimentacao.geraMovimentacao(produto);
		movimentacaoDao.salvar(mov);
		produtoDao.alterar(produto);
		return "redirect:/produtos/";
	}
	
	@GetMapping("/editar")
	public String editar(Long id, Model model) {
		Produto produto = produtoDao.buscarPorId(id);
		model.addAttribute("produto", produto);
		return "produtos/editar";
	}

}