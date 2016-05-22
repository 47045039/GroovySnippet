println (3 + "12")
println 12.plus(34)

def num = 'abc'
def reg = ~"${num}"
println reg
println ('abcdef' =~ 'abc')
println ('abcdef' =~ reg)

def age = 25
print 'My age is '
println age
println("My age is ${age}")

//import Console.*
//def sum = 0
//while (sum < 5) {
//    print("Please enter a integer: ")
//    def data = Console.reader()
//    sum += data
//}

def str = 'abc'
switch(str) {
case 'abc':
    println('match abc')
    break
case 'bcd':
    println('match bcd')
    break
default:
    println('no match.')
    break;
}

def clos = {p -> println("@@@@@ ${p}")}
clos.call('abc')
clos('bcd')

def p1 = 'hello'
def clos2 = {p -> println("${p1} ${p}")}
def demo(clos) {
    def p1 = 'aaaaa'
    clos.call('john')
}

demo clos2
demo(clos2)
demo {p -> println("$p1 $p")}
demo({p -> println("$p1 $p")})

[1,2,3,4].each({if(it % 2 == 0) println(it)})
['ken':21, 'john':22].each({println("$it.key age is $it.value")})

def times(x, y = 4) {
    return x * y
}

//def times(x) {    // 方法重复定义
//    return x * 2
//}

println("times(3,4) = ${times(3,4)}")
println("times(3) = ${times(3)}")


def multiply = {x,y -> return x * y}     // def multiply = {x,y -> return x * y}
def clos3 = multiply.curry(3)
println "clos3(3) = ${clos3(3)}"   // multiply(3,3)
def clos4 = clos3.curry(4)
println "clos4() = ${clos4()}"    // multiply(3,4)


def clos6 = {f,g,x -> return f(g(x))}
def tmp = clos6.curry(clos3, clos3)
println("twice multiply: ${tmp(2)}")    // 3 * (3 * 2)

def map = {clos5,list -> list.collect(clos5)} // 省略了return关键字
def clos7 = map.curry(clos3)
println("table: ${clos7([1,2,3,4])}")    // table: [3, 6, 9, 12]
println("table2: ${map.curry(clos6.curry(clos3, clos3))([1,2,3,4])}")    // table2: [9, 18, 27, 36]


