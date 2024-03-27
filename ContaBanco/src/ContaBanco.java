import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ContaBanco {
    public static void main(String[] args) throws Exception {
        Scanner dice = new Scanner(System.in);

        String agency, customerName, number, balance;

        boolean validAgency = false;
        do {
            System.out.println("Por favor, digite o número da Agência: ");
            agency = dice.nextLine();
            agency = agency.replace("-", "");

            if (agency.length() == 4 && agency.matches("\\d+")) {
                validAgency = true;
            } else {
                System.out.println("Número de Agência inválido. Por favor, insira corretamente os 4 dígitos.");
            }
        } while (!validAgency);

        boolean validAccount = false;
        do {
            System.out.println("Por favor, digite o número da Conta: ");
            number = dice.nextLine();
            number = number.replace("-", "");

            if (number.length() == 9) {
                number = number.substring(0, 2) + "-" + number.substring(2, 8) + "-" + number.substring(8);
            }

            if (number.matches("\\d{2}-\\d{6}-\\d")) {
                validAccount = true;
            } else {
                System.out.println("Número de Conta inválido. Por favor, insira corretamente os 9 dígitos.");
            }
        } while (!validAccount);

        System.out.println("Por favor, digite seu nome completo:");
        customerName = dice.nextLine();

        boolean validValue = false;
        do{
        System.out.println("Por favor, digite o valor do depósito: ");
        balance = dice.nextLine();

        balance = balance.replaceAll("\\.", "").replace(",", ".");
            try {
                Double.parseDouble(balance);
                
                validValue = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Por favor, insira corretamente o valor.");
            }
        } while (!validValue);

        DecimalFormat df = new DecimalFormat("#,##0.00");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(dfs);

        String balanceFormatted = "R$ " + df.format(Double.parseDouble(balance));

    System.out.println("Olá " + customerName + ", Obrigado por manter sua conta em nosso banco, Agradecemos pela sua Confiança e Preferência!! \nA sua agência é " + agency + ", junto da Conta " + number + " e seu saldo agora está avaliado em \n" + balanceFormatted + " Reais e já está disponível para saques!.");

    }
}
