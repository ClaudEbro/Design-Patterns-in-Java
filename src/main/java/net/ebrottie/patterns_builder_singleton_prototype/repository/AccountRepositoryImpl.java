package net.ebrottie.patterns_builder_singleton_prototype.repository;

import net.ebrottie.patterns_builder_singleton_prototype.model.AccountStatus;
import net.ebrottie.patterns_builder_singleton_prototype.model.AccountType;
import net.ebrottie.patterns_builder_singleton_prototype.model.BankAccount;
import net.ebrottie.patterns_builder_singleton_prototype.model.BankDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {


    //Pattern Singleton - 1 - Introduce Singleton Pattern by creating an object and initializing it
    public static final AccountRepositoryImpl accountRepository;
    static {
        System.out.println("Singleton instantiation");
        accountRepository = new AccountRepositoryImpl();
    }

    private AccountRepositoryImpl(){}//Pattern Singleton - 3 - Define a private constructor without parameter to avoid the instantiation of AccountRepositoryImpl.

    private Map<Long, BankAccount> bankAccountMap = new HashMap<>();
    private long accountsCount = 0;

    @Override
    public BankAccount save(BankAccount bankAccount) { //or synchronize the method by "public synchronized BankAccount save(BankAccount bankAccount)"
        Long accountId;
        synchronized (this) { //Synchronize account created to avoid error
          accountId = ++accountsCount; //critical zone
        }

        bankAccount.setAccountId(accountId);

        synchronized (this) {
            bankAccountMap.put(accountId, bankAccount);
        }

        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount account = bankAccountMap.get(id);

        if (account == null){
            return Optional.empty();
        }
        else
            return Optional.of(account);
    }

    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount account) {
        bankAccountMap.put(account.getAccountId(), account);
        return account;
    }

    @Override
    public void deleteById(Long id) {
        bankAccountMap.remove(id);
    }

    public void populateData(){
        for (int i=0; i<10; i++){
            BankAccount account = BankDirector.accountBuilder()
                    .balance(10000+Math.random()*900000)
                    .type(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                    .status(Math.random()>0.5? AccountStatus.CREATED:AccountStatus.ACTIVATED)
                    .currency(Math.random()>0.5?"XOF":"USD")
                    .build();
            save(account);
        }

        System.out.println("**********************************");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Account count = "+accountsCount);
        System.out.println("Size : "+bankAccountMap.values().size());
        System.out.println("**********************************");
    }

    //Pattern Singleton - 2 - After creating an object and initializing it you define a static method to return an instance of this class.
    public static AccountRepositoryImpl getInstance(){

        /*if(accountRepository == null){
            System.out.println("Singleton instantiation");
            accountRepository = new AccountRepositoryImpl();
        }*/
        return accountRepository; //or you can instantiate this class here after delete the key word "final" and the static bloc
    }
}
