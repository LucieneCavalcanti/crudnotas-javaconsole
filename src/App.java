import java.util.ArrayList;
import java.util.Scanner;

import banco.Conexao;
import entities.NotasEntity;
import repository.NotasRepository;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Conexao conexao = new Conexao();
            System.out.println("Conectado!!!");
            NotasRepository DAO = new NotasRepository();
            NotasEntity nota = new NotasEntity();
            Scanner ler = new Scanner(System.in);
            int opcao = 0;

            do {
                System.out.println("----- menu --------");
                System.out.println("1 - Cadastrar nota");
                System.out.println("2 - Editar nota");
                System.out.println("3 - Excluir nota");
                System.out.println("4 - Listar notas");
                System.out.println("5 - Pesquisar notas por aluno");
                System.out.println("10 - Sair");
                opcao = ler.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o nome do aluno: ");
                        nota.setAluno(ler.next());
                        System.out.println("Digite a disciplina: ");
                        nota.setDisciplina(ler.next());
                        System.out.println("Digite a nota: ");
                        nota.setNota(ler.nextFloat());
                        if (DAO.incluir(nota))
                            System.out.println("Salvou");
                        else
                            System.out.println("Não deu certo...");
                        break;
                    case 2:
                        System.out.println("Digite o id:");
                        nota.setId(ler.nextInt());
                        System.out.println("Digite o nome do aluno: ");
                        nota.setAluno(ler.next());
                        System.out.println("Digite a disciplina: ");
                        nota.setDisciplina(ler.next());
                        System.out.println("Digite a nota: ");
                        nota.setNota(ler.nextFloat());
                        if (DAO.editar(nota))
                            System.out.println("Atualizado");
                        else
                            System.out.println("Não deu certo...");
                        break;  
                    case 3:
                        System.out.println("Digite o id a ser excluído:");
                        int id = ler.nextInt();
                        if(DAO.excluir(id))
                            System.out.println("Registro apagado.");
                        else
                            System.out.println("Erro ao excluir.");
                        break;
                    case 4:
                        System.out.println("\n\n ---- mostrando as notas cadastradas ----");
                        ArrayList<NotasEntity> lista = DAO.listarTodos();
                        for (NotasEntity nota1 : lista) {
                            System.out.println(nota1);//toString da classe
                        }
                    case 5:
                        System.out.println("Digite o nome a ser pesquisado:");
                        String nome = ler.next();
                        System.out.println("\n\n ---- mostrando as notas cadastradas ----");
                        ArrayList<NotasEntity> lista2 = DAO.pesquisar(nome);
                        for (NotasEntity nota1 : lista2) {
                            System.out.println(nota1);//toString da classe
                        }

                    default:
                        break;
                }
            } while (opcao!=10);





            
        } catch (Exception e) {
            System.out.println("Deu erro: " + e.getMessage());
        }
    }
}
