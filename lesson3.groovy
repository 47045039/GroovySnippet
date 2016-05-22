public interface AccountIF {
    def display()
}

public abstract class Account implements AccountIF {
    def number
    def balance
    
    Account(n, b) {
        number = n
        balance = b
    }
    
    Account(Map map) {
        number = map.get('number')
        balance = map.get('balance')
    }
}


public class AccountImpl extends Account {
    AccountImpl(n, b) {
        super(n, b)
    }
    
    AccountImpl(Map map) {
        super(map)
    }
    
    def display() {
        return println(toString())
    }
    
    String toString() {
        return "account impl: { my number: $number, my balance: $balance }"
    }
}

public class CurrentAccount extends AccountImpl {
    def overdraftLimit
    
    CurrentAccount(n, b, l = 0) {
        super(n, b)
        overdraftLimit = l
    }

    CurrentAccount(Map map) {
        super(map)
        overdraftLimit = map.get('overdraftLimit')
    }
    
    String toString() {
        return "current account: { my number: $number, my balance: $balance, my overdraft limit: $overdraftLimit }"
    }
}

def acc = new AccountImpl(number:'abcd_1234', balance:55)
acc.display()
acc.number = 'abcd_1235'
acc.display()

def accs = [
    new AccountImpl('abcd_1000', 55),
    new CurrentAccount(number: 'abcd_1001', balance: 60),
    new CurrentAccount('abcd_1002', 65, 10)
]
accs.each({ it ->
    if (it.balance >= 60) {
        println(it)
    }
})