import spock.lang.Specification

class TestSpecification extends Specification {
    def "one plus one should equal two"() {
        expect:
        1+1 == 2
    }

    def "two plus two should equal four"() {
        given:
        int first = 2
        int second = 2

        when:
        int result = first + second

        then:
        result == 4
    }

    def "numbers to the power of two"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c

        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }

//    https://www.baeldung.com/groovy-spock

}