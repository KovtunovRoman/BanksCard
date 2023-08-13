public class DebitCard extends AbstractBankCard {

    {
        System.out.println("Дебетовая карта: \n");
    }
    @Override
    public boolean toUp(double sum) {

        if (sum <= 0) {
            System.out.println("Введите сумму отличную от 0");
            return false;
        }

        balance = balance + sum;
        return true;
    }

    @Override
    public boolean toPay(double sum) {

        if (sum <= 0) {
            System.out.println("Вы нашли товар за который Вам заплатят?)");
            return false;
        } else if (sum > balance) {
            System.out.println("На вашем счету недостаточно средств!");
            return false;
        }

        balance = balance - sum;
        return true;
    }


    @Override
    public void getAllInformation() {
        System.out.println("Ваш основной баланс составляет: " + balance + " рублей");
    }
}
