import model.Lancamento;
import repository.LancamentoRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LancamentoRepository repo = new LancamentoRepository();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GERENCIADOR DE GASTOS ===");
            System.out.println("1. Adicionar lançamento");
            System.out.println("2. Listar lançamentos");
            System.out.println("3. Atualizar lançamento");
            System.out.println("4. Remover lançamento");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir \n

            switch (opcao) {
                case 1 -> {
                    System.out.print("Data (DD/MM/AAAA): ");
                    String data = scanner.nextLine();

                    System.out.print("Descrição (opcional): ");
                    String descricao = scanner.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    System.out.print("Valor (XX,XX): ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    Lancamento l = new Lancamento(data, descricao, categoria, valor);
                    repo.adicionar(l);
                    System.out.println("✅ Lançamento adicionado!");
                }
                case 2 -> {
                    List<Lancamento> lancamentos = repo.listar();
                    if (lancamentos.isEmpty()) {
                        System.out.println("Nenhum lançamento encontrado.");
                    } else {
                        lancamentos.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("Digite o ID do lançamento a atualizar: ");
                    String id = scanner.nextLine();
                    List<Lancamento> lancamentos = repo.listar();
                    Lancamento alvo = lancamentos.stream()
                            .filter(l -> l.getId().equals(id))
                            .findFirst()
                            .orElse(null);

                    if (alvo == null) {
                        System.out.println("❌ ID não encontrado!");
                        break;
                    }

                    System.out.print("Nova data (DD/MM/AAAA): ");
                    alvo.setData(scanner.nextLine());

                    System.out.print("Nova descrição: ");
                    alvo.setDescricao(scanner.nextLine());

                    System.out.print("Nova categoria: ");
                    alvo.setCategoria(scanner.nextLine());

                    System.out.print("Novo valor: ");
                    alvo.setValor(scanner.nextDouble());
                    scanner.nextLine();

                    repo.atualizar(alvo);
                    System.out.println("✅ Lançamento atualizado!");
                }
                case 4 -> {
                    System.out.print("Digite o ID do lançamento a remover: ");
                    String id = scanner.nextLine();
                    repo.remover(id);
                    System.out.println("✅ Lançamento removido (se existia)!");
                }
                case 5 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}