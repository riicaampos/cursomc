package br.com.campos.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.campos.cursomc.domain.Categoria;
import br.com.campos.cursomc.domain.Cidade;
import br.com.campos.cursomc.domain.Cliente;
import br.com.campos.cursomc.domain.Endereco;
import br.com.campos.cursomc.domain.Estado;
import br.com.campos.cursomc.domain.Pedido;
import br.com.campos.cursomc.domain.Produto;
import br.com.campos.cursomc.domain.enums.TipoCliente;
import br.com.campos.cursomc.repository.CategoriaRepository;
import br.com.campos.cursomc.repository.CidadeRepository;
import br.com.campos.cursomc.repository.ClienteRepository;
import br.com.campos.cursomc.repository.EnderecoRepository;
import br.com.campos.cursomc.repository.EstadoRepository;
import br.com.campos.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository catRepo;
	
	@Autowired
	private ProdutoRepository prodRepo;
	
	@Autowired
	private EstadoRepository estRepo;
	
	@Autowired
	private CidadeRepository cidRepo;
	
	@Autowired
	private ClienteRepository cliRepo;
	
	@Autowired
	private EnderecoRepository endRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	// Executa o que está dentro do metodo quando a aplicação é iniciada
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null,"Computador",3.500);
		Produto p2 = new Produto(null,"Impressora",1.200);	
		Produto p3 = new Produto(null,"Mouse",3.50);
		
		cat1.setProdutos(Arrays.asList(p1,p2,p3));
		cat2.setProdutos(Arrays.asList(p2));
		
		p1.setCategorias(Arrays.asList(cat1));
		p2.setCategorias(Arrays.asList(cat1,cat2));
		p3.setCategorias(Arrays.asList(cat1));
		
		catRepo.saveAll(Arrays.asList(cat1,cat2));
		prodRepo.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado e1 = new Estado(null,"São Paulo");
		Estado e2 = new Estado(null,"Rio de Janeiro");
		
		Cidade c1 = new Cidade(null,"Indaiatuba", e1);
		Cidade c2 = new Cidade(null,"Paraty", e2);
		Cidade c3 = new Cidade(null,"Osasco",e1);
	
		
        estRepo.saveAll(Arrays.asList(e1,e2));
        cidRepo.saveAll(Arrays.asList(c1,c2,c3));
        
        Cliente cli1 = new Cliente(null,"Ricardo Campos","ricampos91@gmail.com","41296773817",TipoCliente.PESSOAFISICA);
        HashSet<String> telefones = new HashSet<>();
        HashSet<Endereco> enderecos = new HashSet<>();
        telefones.add("19992599587");
        telefones.add("1938851574");
        cli1.setTelefones(telefones);
        
        Cliente cli2 = new Cliente(null,"Adriana de Campos","dri_grace@gmail.com","43089772147",TipoCliente.PESSOAFISICA);
        HashSet<String> telefones2 = new HashSet<>();
        HashSet<Endereco> enderecos2 = new HashSet<>();
        telefones.add("19991125944");
        telefones.add("1938853466");
        cli2.setTelefones(telefones2);
        
        Endereco end = new Endereco(null,"Luis Forner",119,"s/n","Vila Rubens","13335170",cli1,c1);
        enderecos.add(end);
        cli1.setEnderecos(enderecos);
        
        Endereco end2 = new Endereco(null,"Agostinho Cação",57,"Próximo ao posto de Saúde","Jardim Itamaracá","13335590",cli1,c1);
        enderecos.add(end);
        cli2.setEnderecos(enderecos2);
        
        Pedido ped1 = new Pedido(null, sdf.parse("24/09/1991 09:30"), cli1, end);
        Pedido ped2 = new Pedido(null, sdf.parse(""), cli2, end2);
        
        cliRepo.save(cli1);
        endRepo.save(end);
        

			
	}

}
