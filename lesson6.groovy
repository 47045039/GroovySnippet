def str = "abcdefg_12345"
str.metaClass.upper = {delegate.toUpperCase()}
println(str.metaClass)
println(str.upper())

println('@@@@@@@@@@@ String class methods count: ' + str.metaClass.methods.size())
str.metaClass.methods.each({println "method: " + it})

println('@@@@@@@@@@@ String class properties count: ' + str.metaClass.properties.size())
str.metaClass.properties.each({println "property: " + it})

def str2 = "12345_abcdefg"
println("String class has a upper method: " + str2.metaClass.respondsTo(str2, "upper"))
println("String class has a bytes properties: " + str2.metaClass.hasProperty(str2, "bytes"))

if (str2.metaClass.respondsTo(str2, 'upper')) {
    println str2.toUpperCase()
}

if (str2.metaClass.hasProperty(str2, 'bytes')) {
    println str2.bytes.encodeBase64()
}