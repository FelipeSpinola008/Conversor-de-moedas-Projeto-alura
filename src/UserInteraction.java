import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInteraction {
    private final ApiExchangeClient apiExchangeClient = new ApiExchangeClient();
    private final Scanner scanner = new Scanner(System.in);
    private int option;
    private void displayInteraction() { //Imprime a caixa de dialogo inicial
        System.out.println("""
                =============================================================================================
                Seja bem vindo(a) ao conversor de moedas!!
                
                1) Dólar =>> Real Brasileiro
                2) Real Brasileiro =>> Dólar
                3) Euro =>> Real Brasileiro
                4) Real Brasileiro =>> Euro
                5) Libra Esterlina =>> Real Brasileiro
                6) Real Brasileiro =>> Libra Esterlina
                7) Sair
                Escolha uma opção válida:
                =============================================================================================
                """);
    }
    private void performConversion(String baseCode, String targetCode) {
        try {
            ExchangeRate exchangeRate = apiExchangeClient.exchangeCurrency(baseCode, targetCode);
            System.out.println("Digite o valor que você quer converter: ");
            double exchangeValue = scanner.nextDouble();
            scanner.nextLine();
            double exchangeTax = exchangeRate.conversion_rate();
            double exchangedValue = exchangeValue * exchangeTax;
            System.out.println("=============================================================================================");
            System.out.println("CONVERSÃO REALIZADA");
            System.out.println(baseCode + " =>> " + targetCode);
            System.out.printf("%nValor original: %.2f" + " [" + baseCode + "]%n", exchangeValue);
            System.out.printf("Valor convertido: %.2f" + " [" + targetCode + "]%n", exchangedValue);
            System.out.printf("%n%.2f [" + baseCode + "]" + " Equivale à " + "%.2f" + " [" + targetCode + "]%n", exchangeValue, exchangedValue);
            System.out.println("=============================================================================================");
        } catch (InputMismatchException e) {
            System.out.println("Erro de leitura, Por favor digite um número válido:");
            scanner.nextLine();
        } catch (RuntimeException e) {
            System.out.println("Não foi possível realizar a conversão" + e.getMessage());
        }

    }


    public void start() {
            do {
                try {
                    displayInteraction();
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            performConversion("USD", "BRL");
                            break;
                        case 2:
                            performConversion("BRL", "USD");
                            break;
                        case 3:
                            performConversion("EUR", "BRL");
                            break;
                        case 4:
                            performConversion("BRL", "EUR");
                            break;
                        case 5:
                            performConversion("GBP", "BRL");
                            break;
                        case 6:
                            performConversion("BRL", "GBP");
                            break;
                        case 7:
                            System.out.println("Obrigado por usar meu conversor de moedas!");
                            break;
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Erro de leitura, Por favor digite um número válido:");
                    scanner.nextLine();
                } catch (RuntimeException e) {
                    System.out.println("Não foi possível realizar a conversão" + e.getMessage());
                }

            } while (option != 7);
    }
}
