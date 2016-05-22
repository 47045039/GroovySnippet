def numbers1 = [] as LinkedList
println('numbers1 type: ' + numbers1.getClass().getName())

numbers1.addAll([1,2,3])
println('numbers1 type: ' + numbers1.getClass().getName())

def numbers2 = [] as LinkedList
numbers2 = [4,5,6] + numbers2
println('numbers2 type: ' + numbers2.getClass().getName())

def numbers3 = [] as LinkedList
numbers3 = numbers3 + [4,5,6]
println('numbers3 type: ' + numbers3.getClass().getName())

//def numbers4 = [1,2,3] as LinkedList // 语法错误
println('[1,2,3] type: ' + [1,2,3].getClass().getName())

def ranger1 = (1 .. 10)    // 1 .. 10表示范围 1 - 10（包含边界1和10）
println('ranger1 type: ' + ranger1.getClass().getName())
println("ranger1 from: ${ranger1.getFrom()}, ranger1 to: ${ranger1.getTo()}")

//def ranger2 = (1 <..< 10)
def ranger2 = (1 ..< 10)    // 1 ..< 10表示范围 1 - 10（包含边界1，不包含10）
println('ranger2 type: ' + ranger2.getClass().getName())
println("ranger2 from: ${ranger2.getFrom()}, ranger2 to: ${ranger2.getTo()}")


// 演示操作符重载
class Vector {
    def values = []
    
    def Vector(list) {
        values = list
    }
    
    def plus(vec) {
        def res = []
        def size = values.size()
        if (size == vec.values.size()) {
            for (idx in 0 ..< size) {
                res << (values[idx] + vec.values[idx])
            }
        }
        
        return res
    }
    
    def multiply(vec) {
        def tmp = 0
        def size = values.size()
        if (size == vec.values.size()) {
            for (idx in 0 ..< size) {
                tmp += (values[idx] * vec.values[idx])
            }
        }
        
        return tmp
    }
}
println([1,2,3] + [4,5,6])    // [1, 2, 3, 4, 5, 6]
//println([1,2,3] * [4,5,6])    // groovy.lang.MissingMethodException
println(new Vector([1,2,3]) + new Vector([4,5,6]))    // [5, 7, 9]
println(new Vector([1,2,3]) * new Vector([4,5,6]))    // 32