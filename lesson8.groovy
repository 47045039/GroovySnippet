// ��ʾ���Ϊ�����ȫ���ֶΣ��Լ�������������
// groovyc lesson8.groovy����Ϊ.class�ļ���jd-gui������鿴.class�ļ�

def x = 1
def printx() {   // printx�����һ����������ȫ��������
    println x    // FIXME: �Ҳ���x��x��һ���ֲ���������printx����������һ��
}

def printx2 = {  // printx2��һ����������xһ���Ǿֲ�������
    println x
}

//printx()    // exception
printx2()
printx2.call()


y = 2            // ��̬Ϊ��Ķ������һ���ֶ�
def printy() {
    println y
}

def printy2 = {
    println y
}

printy()
printy2()


import groovy.transform.Field
@Field z = 3    // ��z��Ϊ��Ķ����һ���ֶ�
def printz() {
    println z
}

def printz2 = {
    println z
}

printz()
printz2()