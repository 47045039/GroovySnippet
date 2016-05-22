public interface AccountIF {
    def display()
    
    def display2()
}

public class Account implements AccountIF {
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
    
    def display() {
        return toString()
    }
    
    def display2() {
        return "account: number=$number balance=$balance"
    }
    
    String toString() {
        return "account: { my number: $number, my balance: $balance }"
    }
}

import groovy.util.GroovyTestCase
class AccountTest extends GroovyTestCase {

    void test_display() {
        def acc = new Account(number: "abcd_1000", balance: 100)
        def actual = "account: { my number: abcd_1000, my balance: 100 }"
        assertEquals(actual, acc.display())
    }
    
    void test_display2() {
        def acc = new Account(number: "abcd_1000", balance: 100)
        def actual = "account: number=abcd_1000, balance=100"
        assertTrue("Account.display2() result is not expected", acc.display2() == actual)
    }

    void test_toString() {
        def acc = new Account(number: "abcd_1000", balance: 100)
        def actual = "account: { my number: abcd_1000, my balance: 100 }"
        assertToString(acc, actual)
    }
    
    void test_() {
        assertTrue(1.1 + 0.1 == 1.2)
    }
    
}

//def accTest = new AccountTest()
//accTest.test_display()
//accTest.test_display2()
//accTest.test_toString()

import groovy.util.GroovyTestSuite
import junit.framework.Test
import junit.textui.TestRunner
Test suite() {
    def allTests = new GroovyTestSuite()
    allTests.addTestSuite(AccountTest.class)
    return allTests
}

TestRunner.run(suite())