package controllers;

import java.util.Random;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Funcao;
import entities.Funcionario;
import entities.Setor;
import interfaces.FuncionarioRepository;
import repositories.FuncionarioRepositoryTxtImpl;
import repositories.FuncionarioRepositoryXmlImpl;

public class FuncionarioController {

	Random random = new Random();
	int id = random.nextInt(5000000);

	public void cadastrarFuncionario() {

		var funcionario = obterDadosFuncionario();
		funcionario.setSetor(obterDadosSetor());
		funcionario.setFuncao(obterDadosFuncao());

		FuncionarioRepository funcionarioRepository = null;

		var tipo = JOptionPane.showInputDialog("ESCOLHA (1)TXT OU (2)XML");
		switch (tipo) {
		case "1":
			funcionarioRepository = new FuncionarioRepositoryTxtImpl();// POLIMOFISMO
			break;
		case "2":
			funcionarioRepository = new FuncionarioRepositoryXmlImpl();// POLIMOFISMO
			break;
		}

		funcionarioRepository.exportar(funcionario);
	}

	private Funcionario obterDadosFuncionario() {

		var funcionario = new Funcionario();

		funcionario.setId(UUID.randomUUID());
		funcionario.setNome(JOptionPane.showInputDialog("INFORME O NOME DO FUNCIONÁRIO:"));
		funcionario.setCpf(JOptionPane.showInputDialog("INFORME O CPF DO FUNCIONÁRIO:"));
		funcionario.setMatricula(JOptionPane.showInputDialog("INFORME A MATRICULA DO FUNCIONÁRIO:"));
		funcionario.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Informe o salário do funcionario: ")));

		return funcionario;
	}

	private Setor obterDadosSetor() {

		var setor = new Setor();
		
		setor.setId(UUID.randomUUID());
		setor.setDescricao(JOptionPane.showInputDialog("Informe o setor: "));

		return setor;
	}

	private Funcao obterDadosFuncao() {

		var funcao = new Funcao();
		
		funcao.setId(UUID.randomUUID());
		funcao.setNome(JOptionPane.showInputDialog("Informe a função:"));

		return funcao;
	}
}
