package repositories;

import java.io.PrintWriter;

import entities.Funcionario;
import interfaces.FuncionarioRepository;

public class FuncionarioRepositoryXmlImpl implements FuncionarioRepository {

	@Override
	public void exportar(Funcionario funcionario) {
		
try {
			
			var printWriter = new PrintWriter("funcionario_" + funcionario.getId() + ".xml");
			
			printWriter.write("<?xml version='1.0' encoding='iso-8859-1'?>");
			printWriter.write("<funcionario>");
				printWriter.write("<id>" + funcionario.getId() + "</id>");
				printWriter.write("<nome>" + funcionario.getNome() + "</nome>");
				printWriter.write("<cpf>" + funcionario.getCpf() + "</cpf>");
				printWriter.write("<matricula>" + funcionario.getMatricula() + "</matricula>");
				printWriter.write("<salario>" + funcionario.getSalario() + "</salario>");	
				printWriter.write("<setor>");
					printWriter.write("<id>" + funcionario.getSetor().getId() + "</id>");
					printWriter.write("<descricao>" + funcionario.getSetor().getDescricao() + "</descricao>");
				printWriter.write("</setor>");
				printWriter.write("<funcao>");
					printWriter.write("<id>" + funcionario.getFuncao().getId() + "</id>");
					printWriter.write("<nome>" + funcionario.getFuncao().getNome() + "</nome>");
				printWriter.write("</funcao>");
			printWriter.write("</funcionario>");
			
			printWriter.close();
			
			System.out.println("\nARQUIVO XML GRAVADO COM SUCESSO!");
		}
		catch(Exception e) {
			System.out.println("\nERRO: " + e.getMessage());
		}
	
	}

}
