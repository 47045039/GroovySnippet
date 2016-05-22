import groovy.util.GroovyTestCase
import groovy.util.GroovyTestSuite
import junit.textui.TestRunner
import java.util.regex.Matcher

class AllTests extends GroovyTestCase {

    // . 匹配任意一个字符
    void test_1() {
        assertTrue('bat =~ ^b.t$ is false', ('bat' =~ '^b.t$').matches())
    }
    
    // x* 匹配x 0-n次
    void test_2() {
        assertTrue('bt =~ ^ba*t$ is false', ('bt' =~ '^ba*t$').matches())
    }
    
    // x+ 匹配x 1-n次
    void test_3() {
        assertTrue('baaaat =~ ^ba+t$ is false', ('baaaat' =~ '^ba+t$').matches())
    }

    // x？ 匹配x 0-1次
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