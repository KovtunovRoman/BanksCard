import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Данный класс создан исключительно для одного метода,
 * который создает небольшой интерактив для работы с программой
 * в класс добвлены такие поля, как кол-во попыток и счетчик.
 * Они нужны для того, чтобы во время возникновения ошибки InputMismatchException
 * сразу не выкидывало из программы, а был дополнительный шанс еще что-то исправить.
 **/

public final class ClassStart {
    public static void startProgram() {
        int attempts = 3; // количество попыток
        int counter = 0; // счетчик попыток


        Scanner scanner = new Scanner(System.in);
        AbstractBankCard bankCard = null;

        System.out.println("""
                Выберите какой картой Вы желаете воспользоваться:\s
                1 - Дебетовая карта;
                2 - Кредитная карта;
                3 - Серебряная дебетовая карта;
                4 - Золотая кредитная карта;
                5 - Выход.""");

        int card = scanner.nextInt();

        switch (card) {
            case 1 -> bankCard = new DebitCard();
            case 2 -> bankCard = new CreditCard();
            case 3 -> bankCard = new SilverDebitCard();
            case 4 -> bankCard = new GoldCreditCard();
            case 5 -> {
                System.out.println("До скорых встреч!");
                return;
            }
            default -> System.out.println("Вы выбрали неверное значение, попробуйте еще раз.\n");
        }


        boolean exit = true;

        while (exit) {
            System.out.println("""
                    Выберите операцию, которую вы хотите выполнить:\s
                    1 - Пополнить баланс;
                    2 - Оплатить покупку;
                    3 - Узнать баланс карты;
                    4 - Узнать всю информацию о карте;
                    5 - Выход.""");
            scanner.nextLine();
            int number = scanner.nextInt();

            switch (number) {
                case 1 -> {
                    System.out.println("\nВведите желаему сумму для пополнения: ");
                    while (counter < attempts) {
                        try {
                            scanner.nextLine();
                            double sumForCase1 = scanner.nextDouble();
                            boolean boolToUP = bankCard.toUp(sumForCase1);
                            if (boolToUP) {
                                System.out.println("""
                                        Операция выполнена успешно! Желаете сделать что-то еще?
                                        1 - да
                                        2 - нет""");
                                exit = scanner.nextInt() == 1;
                            }
                            counter = 0;
                            break;
                        } catch (InputMismatchException e) {
                            counter++;
                            if (counter < 3) {
                                System.out.println("Пожалуйста, дробные суммы вводите через запятую!" + "\n"
                                        + "У Вас осталось " + (attempts - counter) + " попытки(-а)");
                            } else {
                                System.out.println("Попытки исчерпаны");
                                counter = 0;
                                break;
                            }
                        }
                    }
                }

                case 2 -> {
                    System.out.println("Ваш чек вышел на: ");
                    while (counter < attempts) {
                        try {
                            scanner.nextLine();
                            double sumForCase2 = scanner.nextDouble();
                            boolean boolToPAY = bankCard.toPay(sumForCase2);
                            if (boolToPAY) {
                                System.out.println("""
                                        Операция выполнена успешно! Желаете сделать что-то еще?
                                        1 - да
                                        2 - нет""");
                                exit = scanner.nextInt() == 1;
                            }
                            counter = 0;
                            break;
                        } catch (InputMismatchException e) {
                            counter++;
                            if (counter < 3) {
                                System.out.println("Пожалуйста, дробные суммы вводите через запятую!" + "\n"
                                        + "У Вас осталось " + (attempts - counter) + " попытки(-а)");
                            } else {
                                System.out.println("Попытки исчерпаны");
                                counter = 0;
                                break;
                            }
                        }
                    }
                }
                case 3 -> {
                    bankCard.getBalance();
                    System.out.println("""
                            Операция выполнена успешно! Желаете сделать что-то еще?
                            1 - да
                            2 - нет""");
                    exit = scanner.nextInt() == 1;
                }
                case 4 -> {
                    bankCard.getAllInformation();
                    System.out.println("""
                            Операция выполнена успешно! Желаете сделать что-то еще?
                            1 - да
                            2 - нет""");
                    exit = scanner.nextInt() == 1;
                }
                case 5 -> {
                    System.out.println("До скорых встреч!");
                    exit = false;
                }
                default -> System.out.println("Вы выбрали неверное значение, попробуйте еще раз.\n");
            }
        }

    }
}


