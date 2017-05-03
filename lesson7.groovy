class Test extends Object {

    def static final TAG = "Test_TAG"
    static final String TAG2 = "Test_TAG2"

    def name
    def age
    def sex

    def getNameFunc() {
        return { name }
    }

    def getAgeFunc() {
        return { age }
    }

    def getSexFunc() {
        return { sex }
    }
}

def t = new Test(name: "1", age: 1, sex: 1)
println "\n===== Test 1 info ====="
println "name = " + t.getNameFunc().call()
println "age = " + t.getAgeFunc()()
println "sex = " + t.getSexFunc()()

def t2 = new Test(name: "2", age: 2, sex: 2)
println "\n===== Test 2 info ====="
println "name2 = " + t2.getName()
println "age2 = " + t2.getAge()
println "sex2 = " + t2.getSex()

def t3 = new Test(name: "3", age: 3, sex: 3)
println "\n===== Test 3 info ====="
println "name3 = " + t3.name
println "age3 = " + t3.age
println "sex3 = " + t3.sex

println "\n===== Test class info ====="
println "Test.getMetaClass() = " + Test.getMetaClass()
println "Test.metaClass = " + Test.metaClass
println "Test.getClass() = " + Test.getClass()
println "Test.class = " + Test.class

println "\n===== Test properties info ====="
println "Test.TAG = " + Test.TAG
println "Test.TAG2 = " + Test.TAG2