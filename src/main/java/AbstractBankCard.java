import java.time.DayOfWeek;
import java.time.LocalDate;
public abstract class AbstractBankCard {

    /*
    *  В dayOfWeek попадает значение текущего дня недели,
    *  который в дальнейшем используется для определения акции
    */
    LocalDate currentDate = LocalDate.now();
    protected DayOfWeek dayOfWeek = currentDate.getDayOfWeek();

    protected double balance;

    /*
    * С помощью метода toUp пополняем банковскую карту
    */
    public abstract boolean toUp (double sum);

    /*
     * С помощью метода toPay платим за покупки
     */
    public abstract boolean toPay(double sum);

    public void getBalance(){
        System.out.println("Ваш баланс составляет: " + balance + " рублей");
    }

    public abstract void getAllInformation();
}
