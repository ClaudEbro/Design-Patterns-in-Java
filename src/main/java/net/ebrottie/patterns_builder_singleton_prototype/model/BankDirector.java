package net.ebrottie.patterns_builder_singleton_prototype.model;

public class BankDirector {

    public static BankAccount.AccountBuilder accountBuilder(){
        return new BankAccount.AccountBuilder();
    }
}
