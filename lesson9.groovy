// ��ʾfile��stream����

def file = new File('lesson9.groovy')
def file2 = new File('lesson9.groovy.comment')
def file3 = new File('lesson9.groovy.copy')

// ���д�ӡÿһ�еĴ���
println "\r\n\r\n ================ �ָ��� 1 ================"
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


// �ļ� => byte[] => string
def bytes = file.getBytes()
def codes = new String(bytes)
println "\r\n\r\n ================ �ָ��� 2 ================"
println "lesson9.groovy codes: \r\n$codes"


// �ļ� => stream => string
def ins = file.newInputStream()
println "\r\n\r\n ================ �ָ��� 3 ================"
println "lesson9.groovy codes: \r\n" + ins.getText()
ins.close()    // �ر���


// ���˳�ע�Ͳ�д����һ���ļ�
println "\r\n\r\n ================ �ָ��� 4 ================"
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


// �ļ� => input stream => ��ӡÿһ��
println "\r\n\r\n ================ �ָ��� 5 ================"
println "lesson9.groovy comment 2: \r\n"
file2.withInputStream {
    ins2 ->
    ins2.eachLine {
        line ->
        println line
    }
//    println ins2.getText()

//    ins2.close()    // ����Ҫ�ֶ�close
}


// �ļ�����
println "\r\n\r\n ================ �ָ��� 6 ================"
println "lesson9.groovy copy : \r\n"
file.withInputStream {
    ins3 ->
    file3.withOutputStream {
        outs ->
        // outs << ins3    // OutputStream << ����������
    }
}

file3.withOutputStream {
    outs2 ->
    file.withInputStream {
        ins4 ->
        outs2 << ins4     // OutputStream << ����������
    }
}
