package net.ebrottie.patterns_builder_singleton_prototype;

import net.ebrottie.patterns_builder_singleton_prototype.model.AccountStatus;
import net.ebrottie.patterns_builder_singleton_prototype.model.AccountType;
import net.ebrottie.patterns_builder_singleton_prototype.model.BankAccount;
import net.ebrottie.patterns_builder_singleton_prototype.model.Customer.Customer;

public class Test {
    /*
    * To implement The Pattern Prototype
    * */
    public static void main(String[] args) throws CloneNotSupportedException {

        //I create an instance of BankAccount

        BankAccount account1 = new BankAccount();
        account1.setAccountId(1L);
        account1.setBalance(80000);
        account1.setCurrency("USD");
        account1.setStatus(AccountStatus.ACTIVATED);
        account1.setType(AccountType.CURRENT_ACCOUNT);
        account1.setCustomer(new Customer(1L,"EBROTTIE"));//Creating a customer for this account


        //Create a Clone of account1 with Clone interface
        BankAccount account3 = account1.clone();

        System.out.println("ACC1 = "+account1);
        System.out.println("ACC3 = "+account3);


        System.out.println("**********************");
        account1.getCustomer().setName("CLAUDIO");

        System.out.println("ACC1 = "+account1);
        System.out.println("ACC3 = "+account3);
    }
}
