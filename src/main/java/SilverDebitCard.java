public final class SilverDebitCard extends DebitCard {

    {
        System.out.println("Для серебряной дебетовой карты сегодня следующие условия:\n");

        switch (dayOfWeek) {
            case MONDAY -> {
                System.out.println("Акция 'ПОНЕДЕЛЬНИК': Пополните баланс на 10000 рублей или больше и получите 1% от этой суммы на счет");
                System.out.println("На попупки сегодня нет акций");
            }

            case TUESDAY -> {
                System.out.println("Акция 'ВТОРНИК': Несчастливый день! При пополнении от 3000 комиссия 5%");
                System.out.println("На попупки сегодня нет акций");
            }

            case WEDNESDAY -> {
                System.out.println("Акция 'СРЕДА': Компания делится деньгами, получите на счет 50 рублей!");
                System.out.println("На попупки сегодня нет акций");
            }

            case THURSDAY -> {
                System.out.println("Акция 'ЧЕТВЕРГ': Пополните баланс ровно на 5050 рублей и получите шанс выйграть машину!");
                System.out.println("На попупки сегодня нет акций");
            }

            case FRIDAY -> {
                System.out.println("Акция 'ПЯТНИЦА': Пополните баланс на 3000 рублей или больше и получите бесплатный массаж");
                System.out.println("Кэшбэк 5% от покупок при тратах от 5000 рублей и более");
            }

            case SATURDAY -> {
                System.out.println("Акции на пополнение баланса отдыхают, вернутся в понедельник !)");
                System.out.println("Выходные! Тратьте деньги (не менее 10000 рублей) и получите шанс выйграть Iphone!");
            }

            case SUNDAY -> {
                System.out.println("Акции отдыхают, вернутся в понедельник !)");
                System.out.println("Потратьте ровно 7777 рублей и верните 77% кэшбеком!");
            }
        }
    }

    @Override
    public boolean toUp(double sum) {

        switch (dayOfWeek) {
            case MONDAY -> {
                if (sum >= 10000) {
                    balance = balance + (sum * 1.01);
                } else super.toUp(sum);
            }

            case TUESDAY -> {
                if (sum >= 3000) {
                    balance = balance + (sum * 0.95);
                } else super.toUp(sum);
            }

            case WEDNESDAY -> {
                if (sum > 0) {
                    balance = balance + (sum + 50);
                } else {
                    System.out.println("Введите сумму отличную от 0");
                    return false;
                }
            }

            case THURSDAY -> {
                if (sum == 5050) {
                    balance = balance + sum;
                    System.out.println("Ваш билет для участи: " + (int) (Math.random() * 9999));
                } else super.toUp(sum);
            }

            case FRIDAY -> {
                if (sum >= 3000) {
                    balance = balance + sum;
                    System.out.println("Отсканируйте QR-код и получите бесплатный массаж!");
                } else super.toUp(sum);
            }

            case SATURDAY, SUNDAY -> super.toUp(sum);

        }
        return true;
    }

    @Override
    public boolean toPay(double sum) {

        switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY -> super.toPay(sum);

            case FRIDAY -> {
                if (sum >= 5000) {
                    balance = balance - (sum * 0.95);
                    System.out.println("Вам вернули кэшбэк 5%!");
                } else super.toPay(sum);
            }

            case SATURDAY -> {
                if (sum >= 10000) {
                    balance = balance - sum;
                    System.out.println("Ваш билет для участи: " + (int) (Math.random() * 9999));
                } else super.toPay(sum);
            }

            case SUNDAY -> {
                if (sum == 7777) {
                    balance = balance - (sum * 0.33);
                    System.out.println("Вам вернули кэшбэк 77%!");
                } else super.toPay(sum);
            }
        }
        return true;
    }
}
