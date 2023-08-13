public final class GoldCreditCard extends CreditCard {

    {
        System.out.println("Для золотой кредитной карты сегодня следующие условия: \n");

        switch (dayOfWeek) {
            case MONDAY, WEDNESDAY, FRIDAY, SUNDAY -> {
                System.out.println("На пополнение сегодня нет акций");
                System.out.println("На попупки сегодня нет акций");
            }

            case TUESDAY -> {
                System.out.println("Акция 'ВТОРНИК': Пополните баланс на 200 000 рублей и получите путевку в Сочи на 3 дня!");
                System.out.println("Потратьте до 80000 рублей и верните до 100% на счет!");
            }

            case THURSDAY -> {
                System.out.println("Акция 'ЧЕТВЕРГ': Пополните баланс на 60000 рублей или более и мы подарим Вам акцию, стоимостью до 15000 рублей");
                System.out.println("Не жалейте деньги, потратьте 40000 рублей или более и получите промокод на месяц бесплатного кофе!");
            }


            case SATURDAY -> {
                System.out.println("Акция 'ВОСКРЕСЕНЬЕ': Пополните баланс на 500 000 рублей или более и мы застрахуем эту сумму на 2 месяца!");
                System.out.println("Выходные! Тратьте деньги (не менее 90000) и получите шанс выйграть MacBook!");
            }
        }
    }

    @Override
    public boolean toUp(double sum) {

        switch (dayOfWeek) {

            case MONDAY, WEDNESDAY, FRIDAY, SUNDAY -> super.toUp(sum);

            case TUESDAY -> {
                super.toUp(sum);
                if (sum >= 200000) {
                    System.out.println("Отсканируйте QR-код, следуйте инструкциям и путешествуйте!");
                }
            }

            case THURSDAY -> {
                super.toUp(sum);
                if (sum >= 60000) {
                    System.out.println("Вот ваша акция в подарок стоимостью: " + (int) (Math.random() * 15000));
                }
            }

            case SATURDAY -> {
                super.toUp(sum);
                if (sum >= 500000) {
                    System.out.println("Ваши деньги успешно застрахованы!");
                }
            }
        }
        return true;
    }

    @Override
    public boolean toPay(double sum) {

        switch (dayOfWeek) {

            case MONDAY, WEDNESDAY, FRIDAY, SUNDAY -> super.toPay(sum);

            case TUESDAY -> {
                if (sum <= 80000) {
                    if (balance > 0) {
                        balance = balance - (sum * Math.random());
                        if (balance < 0) {
                            creditBalance = creditBalance - (-balance);
                            balance = 0;
                            System.out.println("На основном счете не хватило средств, с кредитного счета списано: " + (creditLimit - creditBalance) + " рублей");
                        }
                    } else {
                        creditBalance = creditBalance - sum;
                        System.out.println("На основном счете не было средств, списаны деньги с кредитного счета" + "\n"
                                + "Кредитный баланс: " + creditBalance);
                    }
                } else {
                    super.toPay(sum);
                }
            }

            case THURSDAY -> {
                super.toPay(sum);
                if (sum >= 40000) {
                    System.out.println("Ваш промокод: COFFEE-2023");
                }
            }

            case SATURDAY -> {
                super.toPay(sum);
                if (sum >= 90000) {
                    System.out.println("Ваш билет для участи: " + (int) (Math.random() * 9999));
                }
            }
        }
        return true;
    }
}