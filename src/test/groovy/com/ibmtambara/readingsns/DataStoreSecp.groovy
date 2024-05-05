package com.ibmtambara.readingsns

import spock.lang.*

class DataStoreSpec extends Specification {
    def "helloテスト"() {
        def hoge = 0

        expect:
        hoge > 1
    }
}