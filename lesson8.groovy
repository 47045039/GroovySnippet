// 演示如何为类添加全局字段，以及变量的作用域
// groovyc lesson8.groovy编译为.class文件，jd-gui反编译查看.class文件

def x = 1
def printx() {   // printx是类的一个方法，类全局作用域
    println x    // FIXME: 找不到x，x是一个局部变量，和printx方法作用域不一样
}

def printx2 = {  // printx2是一个变量，和x一样是局部作用域
    println x
}

//printx()    // exception
printx2()
printx2.call()


y = 2            // 动态为类的对象添加一个字段
def printy() {
    println y
}

def printy2 = {
    println y
}

printy()
printy2()


import groovy.transform.Field
@Field z = 3    // 将z作为类的对象的一个字段
def printz() {
    println z
}

def printz2 = {
    println z
}

printz()
printz2()