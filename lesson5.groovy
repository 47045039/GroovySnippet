import groovy.util.GroovyTestCase
import groovy.util.GroovyTestSuite
import junit.textui.TestRunner
import java.util.regex.Matcher

class AllTests extends GroovyTestCase {

    // . ƥ������һ���ַ�
    void test_1() {
        assertTrue('bat =~ ^b.t$ is false', ('bat' =~ '^b.t$').matches())
    }
    
    // x* ƥ��x 0-n��
    void test_2() {
        assertTrue('bt =~ ^ba*t$ is false', ('bt' =~ '^ba*t$').matches())
    }
    
    // x+ ƥ��x 1-n��
    void test_3() {
        assertTrue('baaaat =~ ^ba+t$ is false', ('baaaat' =~ '^ba+t$').matches())
    }

    // x�� ƥ��x 0-1��
    void test_4() {
        assertTrue('bt =~ ^ba?t$ is false', ('bt' =~ '^ba?t$').matches())
    }
}

Matcher m = ('bat' =~ 'bat')
println('@@@@@@@@@@@ matches: ' + m.matches())
println('@@@@@@@@@@@ find: ' + m.find())
println('@@@@@@@@@@@ group count: ' + m.groupCount())

GroovyTestSuite t = new GroovyTestSuite()
t.addTestSuite(AllTests.class)
TestRunner.run(t)

println(3592 + 42390)