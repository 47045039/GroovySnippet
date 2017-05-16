// 演示file和stream操作

def file = new File('lesson9.groovy')
def file2 = new File('lesson9.groovy.comment')
def file3 = new File('lesson9.groovy.copy')

// 按行打印每一行的代码
println "\r\n\r\n ================ 分割线 1 ================"
println "lesson9.groovy codes: \r\n"
def lineCount = 0
file.eachLine {
    line ->
    lineCount++
    if (!line.startsWith("//")) {
        // println "line " + lineCount + ': ' + line
        println "line $lineCount : $line"
    }
}


// 文件 => byte[] => string
def bytes = file.getBytes()
def codes = new String(bytes)
println "\r\n\r\n ================ 分割线 2 ================"
println "lesson9.groovy codes: \r\n$codes"


// 文件 => stream => string
def ins = file.newInputStream()
println "\r\n\r\n ================ 分割线 3 ================"
println "lesson9.groovy codes: \r\n" + ins.getText()
ins.close()    // 关闭流


// 过滤出注释并写入另一个文件
println "\r\n\r\n ================ 分割线 4 ================"
println "lesson9.groovy comment: \r\n"
def writer = file2.newWriter(false)
file.filterLine(writer, {
    if (it.startsWith('//')) {
        println it
        return true
    } else {
        return false
    }
})
writer.close()


// 文件 => input stream => 打印每一行
println "\r\n\r\n ================ 分割线 5 ================"
println "lesson9.groovy comment 2: \r\n"
file2.withInputStream {
    ins2 ->
    ins2.eachLine {
        line ->
        println line
    }
//    println ins2.getText()

//    ins2.close()    // 不需要手动close
}


// 文件复制
println "\r\n\r\n ================ 分割线 6 ================"
println "lesson9.groovy copy : \r\n"
file.withInputStream {
    ins3 ->
    file3.withOutputStream {
        outs ->
        // outs << ins3    // OutputStream << 操作符重载
    }
}

file3.withOutputStream {
    outs2 ->
    file.withInputStream {
        ins4 ->
        outs2 << ins4     // OutputStream << 操作符重载
    }
}
