package com.compasso.uol;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.compasso.uol.domain.Cidade;
import com.compasso.uol.domain.Cliente;
import com.compasso.uol.domain.Estado;
import com.compasso.uol.domain.enums.TipoCliente;
import com.compasso.uol.repositories.CidadeRepository;
import com.compasso.uol.repositories.ClienteRepository;
import com.compasso.uol.repositories.EstadoRepository;

@SpringBootApplication
public class AgendaclienteApplication implements CommandLineRunner{

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaclienteApplication.class, args);

	}

	@SuppressWarnings("unused")
	@Override
	public void run(String... args) throws Exception {
		Estado est1 = new Estado(null, "Acre - AC");
		Estado est2 = new Estado(null, "Alagoas - AL");
		Estado est3 = new Estado(null, "Amapá - AP");
		Estado est4 = new Estado(null, "Amazonas- AM");
		Estado est5 = new Estado(null, "Bahia - BA");
		Estado est6 = new Estado(null, "Ceará - CE");
		Estado est7 = new Estado(null, "Espírito Santo - ES");
		Estado est8 = new Estado(null, "Goiás - GO");
		Estado est9 = new Estado(null, "Maranhão - MA");
		Estado est10 = new Estado(null, "Mato Grosso - MT");
		Estado est11 = new Estado(null, "Mato Grosso do Sul - MS");
		Estado est12 = new Estado(null, "Minas Gerais - MG");
		Estado est13 = new Estado(null, "Pará - PA");
		Estado est14 = new Estado(null, "Paraíba - PB");
		Estado est15 = new Estado(null, "Paraná - PR");
		Estado est16 = new Estado(null, "Pernambuco - PE");
		Estado est17 = new Estado(null, "Piauí - PI");
		Estado est18 = new Estado(null, "Rio de Janiero - RJ");
		Estado est19 = new Estado(null, "Rondônia- RO");
		Estado est20 = new Estado(null, "Roraima - RR");
		Estado est21 = new Estado(null, "Santa Catarina - SC");
		Estado est22 = new Estado(null, "São Paulo - SP");
		Estado est23 = new Estado(null, "Sergipe - SE");
		Estado est24 = new Estado(null, "Tocantins - TO");
		Estado est25 = new Estado(null, "Distritto Federal - DF");
		
		Cidade c1 = new Cidade(null, "Belo Horizonte", est12);
		Cidade c2 = new Cidade(null, "São Paulo", est22);
		Cidade c3 = new Cidade(null, "Rio de Janeiro", est18);
		Cidade c4 = new Cidade(null, "Vitória", est7);

		est12.getCidade().addAll(Arrays.asList(c1));
		est22.getCidade().addAll(Arrays.asList(c2));
		est18.getCidade().addAll(Arrays.asList(c3));
		est7.getCidade().addAll(Arrays.asList(c4));

		estadoRepository.saveAll(Arrays.asList(est1,est2,est3,est4,est5,est6,est7,est8,est9,est10,est11,est12,est13,est14,est15,est16,est17,est18,est19,est20,est21,est22,est23,est24,est25));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3,c4));

		Cliente cli1 = new Cliente(null, "Maria Silva", "F", "20/05/1988", 32, TipoCliente.PESSOAFISICA,c1);
		Cliente cli2 = new Cliente(null, "José Samargo", "M", "01/01/1940", 81, TipoCliente.PESSOAFISICA,c2);
		Cliente cli3 = new Cliente(null, "Padaria do Manuel", null, null, null, TipoCliente.PESSOAJURIDICA,c3);
		Cliente cli4 = new Cliente(null, "Oficina Mecânica de Autóveis", null, null, null, TipoCliente.PESSOAJURIDICA,c3);
		Cliente cli5 = new Cliente(null, "Mar Azul Agência de Turismo", null, null, null, TipoCliente.PESSOAJURIDICA,c4);
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
	}
}
