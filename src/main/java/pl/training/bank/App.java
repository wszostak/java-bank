package pl.training.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.training.bank.entity.Account;
import pl.training.bank.entity.Client;

import java.math.BigDecimal;

public class App
{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bank.xml");
        Bank bank = context.getBean(Bank.class);
        try {
            Account account1 = bank.addAccount(new Account());
            Account account2 = bank.addAccount(new Account());
            System.out.println("Account 1 balance: " + account1.getBalance());
            System.out.println("Account 2 balance: " + account2.getBalance());

            bank.payInCashToAccount(account1.getNumber(), new BigDecimal(1000));
            bank.payInCashToAccount(account2.getNumber(), new BigDecimal(200));
            System.out.println("Account 1 balance: " + account1.getBalance());
            System.out.println("Account 2 balance: " + account2.getBalance());

            bank.transferCash(account1.getNumber(), account2.getNumber(), new BigDecimal(10));
            System.out.println("Account 1 balance: " + account1.getBalance());
            System.out.println("Account 2 balance: " + account2.getBalance());

            bank.payInCashToAccount("0001", new BigDecimal(0));
        } catch (BankException e) {
            // e.printStackTrace();
        }
    }

}
