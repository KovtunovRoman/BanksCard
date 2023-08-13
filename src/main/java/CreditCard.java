import java.util.Scanner;

public class CreditCard extends AbstractBankCard {
    protected double creditLimit;
    protected double creditBalance;

    {
        System.out.println("Установите кредитный лимит на данную карту:");

        Scanner scanner = new Scanner(System.in);
        creditLimit = scanner.nextDouble();
        creditBalance = creditLimit;

        System.out.println("Удачного пользования!");
    }

    @Override
    public boolean toUp(double sum) {

        if (sum <= 0) {
            System.out.println("Введите сумму отличную от 0");
            return false;
        }

        if (creditBalance != creditLimit) {  // Если у нас есть долг по кредитной части, то
            creditBalance = creditBalance + sum;  // гасим кредитную часть
            if (creditBalance >= creditLimit) {  //  Если кредитная часть погашена, а средства для пополнения еще есть, то
                balance = balance + (creditBalance - creditLimit); // пополняем основной баланс
            } else
                System.out.println("Ваш кредитный долг составляет: " + (creditLimit - creditBalance) + " рублей" + "\n" + "Погасите его, чтобы пополнить баланс");
        } else {
            balance = balance + sum;
        }
        return true;
    }

    @Override
    public boolean toPay(double sum) {

        if (sum <= 0) {
            System.out.println("Вы нашли товар за который Вам заплатят?)");
            return false;
        }

        if (balance > 0) {
            balance = balance - sum;  // Может произойти ситуация, когда деньги есть, но их недостаточно для покупки
            if (balance < 0) {  // Если баланс ушел в минус, значит это произошло и тогда
                creditBalance = creditBalance - (-balance);  // списываем деньги уже с кредитного счета
                balance = 0;  // обнуляя при этом сам баланс, иначе он будет отрицательным при отображении
                System.out.println("На основном счете не хватило средств, с кредитного счета списано: " + (creditLimit - creditBalance) + " рублей");
            }
        } else {
            if (sum <= creditBalance) {
                creditBalance = creditBalance - sum;
                System.out.println("На основном счете не было средств, списаны деньги с кредитного счета" + "\n"
                        + "Кредитный баланс: " + creditBalance);
            } else {
                System.out.println("На вашей кредитке не хватает средств!");
                return false;
            }
        }
        return true;
    }

    @Override
    public void getAllInformation() {
        System.out.println("Ваш основной баланс составляет: " + balance + " рублей" + "\n"
                + "Ваш кредитный баланс составляет: " + creditBalance + " рублей");
    }
}