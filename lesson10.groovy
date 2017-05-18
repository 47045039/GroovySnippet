import groovy.util.XmlSlurper
import groovy.util.slurpersupport.GPathResult

def xparser = new XmlSlurper() // xml����

// GPath��xpath��һ��ʵ�֣�https://en.wikipedia.org/wiki/XPath
// xpath�������Ϊһ��Ϊxmlʵ�ֵ��﷨��������xml tree��ʵ����������ת�����������˵�
// GPathResult gpath = xparser.parse(new File("lesson10.groovy.test"))
GPathResult gpath = xparser.parseText(
'''<response version-api="2.0">  
       <value>  
           <books>  
               <book available="20" id="1">  
                   <title>Don Xijote</title>  
                   <author id="1">Manuel De Cervantes</author>  
               </book>  
               <book available="14" id="2">  
                   <title>Catcher in the Rye</title>  
                  <author id="2">JD Salinger</author>  
              </book>  
              <book available="13" id="3">  
                  <title>Alice in Wonderland</title>  
                  <author id="3">Lewis Carroll</author>  
              </book>  
              <book available="5" id="4">  
                  <title>Don Xijote</title>  
                  <author id="4">Manuel De Cervantes</author>  
              </book>  
           </books>  
      </value>  
   </response>'''
)

println "\r\n\r\n ================ �ָ��� 1 ================"
println "response: " + gpath.response?.getClass()             // �÷�����gpath�ʹ����˸��ڵ�response
println "value: " + gpath.value.getClass()                    // response�ڵ���ӽڵ�value
println "value.books: " + gpath.value.books.getClass()        // value�ڵ���ӽڵ�books


println "\r\n\r\n ================ �ָ��� 2 ================"
def book = gpath.value.books.book                  // books�ڵ�������ӽڵ�book
println book.getClass()            // class groovy.util.slurpersupport.NodeChildren
def iterator = book.childNodes()
println iterator.getClass()        // class groovy.util.slurpersupport.NodeChildren$1


println "\r\n\r\n ================ �ָ��� 3 ================"
println "book size = " + book.size()
println "book text = " + book.text()
println "book[0]  author=" + book[0].author + "  title=" + book[0].title    // ֱ��������book[0]


println "\r\n\r\n ================ �ָ��� 4 ================"
// book.childNodes()������book�µ����нڵ㣬������ֱ���ӽڵ㡢�ӽڵ���ӽڵ㣬���Դ�ӡ����Ϣ��8��Node
def iterator2 = book.childNodes()
iterator2.each {
    it ->
    println it.getClass()        // class groovy.util.slurpersupport.Node
    
//    name=title text=Don Xijote attrs=[:]
//    name=author text=Manuel De Cervantes attrs=[id:1]
//    name=title text=Catcher in the Rye attrs=[:]
//    name=author text=JD Salinger attrs=[id:2]
//    name=title text=Alice in Wonderland attrs=[:]
//    name=author text=Lewis Carroll attrs=[id:3]
//    name=title text=Don Xijote attrs=[:]
//    name=author text=Manuel De Cervantes attrs=[id:4]
    println "name=" + it.name() + " text=" + it.text() + " attrs=" + it.attributes()
}


println "\r\n\r\n ================ �ָ��� 5 ================"
def iterator3 = book.childNodes();
def index = 0
while (iterator3.hasNext()) {     // FIXME: fuck����ѭ����why��
    def it = iterator2.next()
    println it?.getClass()        // class groovy.util.slurpersupport.Node
    println "name=" + it?.name() + " text=" + it?.text() + " attrs=" + it?.attributes()
    if (index++ > 5) {
        break
    }
}


println "\r\n\r\n ================ �ָ��� 6 ================"
def index2 = 0
def index3 = 0

book.each {
    bookNode ->
    println bookNode.getClass()    // class groovy.util.slurpersupport.NodeChild
    println "book[$index2] text=" + bookNode.text() + " attrs=" + bookNode.attributes()
    
    index3 = 0
    
    bookNode.childNodes()?.each {
        bookChild ->
        
        println bookChild.getClass()    // class groovy.util.slurpersupport.Node
        println "book[$index2] child[$index3]  name=" + bookChild?.name() + " text=" + bookChild?.text() + " attrs=" + bookChild?.attributes()
                 
        index3++
    }
    
    index2++
}

println "\r\n\r\n ================ �ָ��� 7 ================"
def book2 = book[2]
assert book[2].author.text() == "Lewis Carroll"
assert book[2].title.text() == "Alice in Wonderland"
println book[2].author.@id        // ע�⣬�˴���xpath�﷨����ʾauthor��id����
println book[2].@id               // ע�⣬�˴���xpath�﷨����ʾbook��id����
println book[2]["@available"]     // book��available����

def map = [key: "value"]          // ����һ��map
map.putAll key2: "value2"         // ��̬�ҹ����д��
println map
