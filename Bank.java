package part1;

interface CheckingAccount {
    void checking();

}

interface SavingsAccount {
    void savings();

}

class BasicCheckingAccount implements CheckingAccount {
    @Override
    public void checking() {
        System.out.println("Creating Checking Account");
        System.out.println("**Basic Checking Account**");

    }
}

class BasicSavingsAccount implements SavingsAccount {
    @Override

    public void savings() {
        System.out.println("Creating Savings Account");
        System.out.println("**Basic Savings Account**\n");

    }
}

class BankOfAmericaCheckingAccount implements CheckingAccount {
    @Override
    public void checking() {
        System.out.println("Creating Checking Account");
        System.out.println("**Basic Checking Account**::BankOfAmerica Savings Account");

    }
}

class BankOfAmericaSavingsAccount implements SavingsAccount {
    @Override

    public void savings() {
        System.out.println("Creating Savings Account");
        System.out.println("**Basic Savings Account**::BankOfAmerica Savings Account\n");

    }
}

class ChaseCheckingAccount implements CheckingAccount {
    @Override
    public void checking() {
        System.out.println("Creating Checking Account");
        System.out.println("**Basic Checking Account**::Chase Savings Account");

    }
}

class ChaseSavingsAccount implements SavingsAccount {
    @Override
    public void savings() {
        System.out.println("Creating Savings Account");
        System.out.println("**Basic Savings Account**::Chase Savings Account\n");

    }
}

//abstract factory
interface AccountFactory {
    CheckingAccount createCheckingAccount();

    SavingsAccount createSavingsAccount();
}

//Concrete Factory -  Basic Account Factory
class BasicAccountFactory implements AccountFactory {
    @Override
    public CheckingAccount createCheckingAccount() {
        return new BasicCheckingAccount();
    }
    @Override
    public SavingsAccount createSavingsAccount() {
        return new BasicSavingsAccount();
    }
}

//Concrete Factory -  Bank of America Account Factory
class BankOfAmericaAccountFactory implements AccountFactory {
    @Override
    public CheckingAccount createCheckingAccount() {
        return new BankOfAmericaCheckingAccount();
    }
    @Override
    public SavingsAccount createSavingsAccount() {
        return new BankOfAmericaSavingsAccount();
    }
}

//Concrete Factory - Chase Account Factory
class ChaseAccountFactory implements AccountFactory {
    @Override
    public CheckingAccount createCheckingAccount() {
        return new ChaseCheckingAccount();
    }

    @Override
    public SavingsAccount createSavingsAccount() {
        return new ChaseSavingsAccount();
    }
}
// Client
public class Bank {

    public static void main(String[] args) {

        AccountFactory customerAccountFactory;

        System.out.println("--Testing Basic version of Accounts--");
        customerAccountFactory = new BasicAccountFactory();
        doSomething(customerAccountFactory);

        System.out.println("\"--Testing Bank of America version of Accounts--");
        customerAccountFactory = new BankOfAmericaAccountFactory();
        doSomething(customerAccountFactory);

        System.out.println("\"--Testing Chase version of Accounts--");
        customerAccountFactory = new ChaseAccountFactory();
        doSomething(customerAccountFactory);

    }

    private static void doSomething(AccountFactory accountFactory) {
        CheckingAccount customerCheckingAccount;
        SavingsAccount customerSavingsAccount;

        // Making a checking account through AccountFactory
        customerCheckingAccount = accountFactory.createCheckingAccount();
        customerCheckingAccount.checking();

        // Making a savings account through AccountFactory
        customerSavingsAccount = accountFactory.createSavingsAccount();
        customerSavingsAccount.savings();

    }
}
