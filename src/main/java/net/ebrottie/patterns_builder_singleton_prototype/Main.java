package net.ebrottie.patterns_builder_singleton_prototype;

import net.ebrottie.patterns_builder_singleton_prototype.model.AccountStatus;
import net.ebrottie.patterns_builder_singleton_prototype.model.AccountType;
import net.ebrottie.patterns_builder_singleton_prototype.model.BankAccount;
import net.ebrottie.patterns_builder_singleton_prototype.model.BankDirector;
import net.ebrottie.patterns_builder_singleton_prototype.repository.AccountRepositoryImpl;
import net.ebrottie.patterns_builder_singleton_prototype.util.JsonSerializer;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {

        // I create the first Object of BankAccount with Pattern Builder
        BankAccount bankAccount1 = BankDirector.accountBuilder()
                .accountId(1L)
                .currency("XOF")
                .status(AccountStatus.CREATED)
                .type(AccountType.SAVING_ACCOUNT)
                .balance(7000000)
                .build();
        System.out.println(bankAccount1);

        // or create other Objects of BankAccount with Pattern Builder by method populateData
        JsonSerializer<BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();
        AccountRepositoryImpl accountRepository = AccountRepositoryImpl.getInstance(); //Now you call the class itself by his instance because of it's a static method.

        //Using Pattern Singleton with Threads
        for (int i=0; i<10; i++){
            new Thread(()-> {
                accountRepository.populateData();
            }).start();
        }
        System.out.print("Tape a character :");
        System.in.read();

        //To search BankAccount with some criteria
        /*List<BankAccount> bankAccounts = accountRepository
                .searchAccounts(bankAccount -> bankAccount.getStatus().equals(AccountStatus.ACTIVATED) && (bankAccount.getBalance()>1000));*/

        List<BankAccount> bankAccounts = accountRepository.findAll();
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);

        //Get an BankAccount by Id
        /*System.out.println("===================================");
        BankAccount account = accountRepository.findById(1L).orElse(null);
        if(account!=null)
            System.out.println(bankAccountJsonSerializer.toJson(account));*/
    }
}
