package com.ibmtambara.readingsns

import spock.lang.*
import java.time.Instant

class DataStoreSpec extends Specification {
    DataStore data
    String testfilename = "tmp/articles.txt"

    def setup() {
        data = new DataStore(testfilename)
    }
    def "全てのユーザーの最新のメッセージを取得する"() {
        given:
        new File(testfilename).delete()
        new File(testfilename).text = 
"""tambara,tambara-icon.png,シャーロック・ホームズの凱旋,9784120057341,1章まで読んだ。ホームズが腐れ大学生なんだが？,2024-02-09T01:48:54.298Z
Eri KUWAHARA,kuwahara-icon.png,AIリスク教本　攻めのディフェンスで危機回避＆ビジネス加速,9784296204082,リスクの章の2つ目まで読んだ。17個は多くない！？,2024-02-07T05:24:32.911Z
harimoto,harimoto-icon.png,入門 モダンLinux,9784814400217,ワタシ、リナックスチョットデキル,2023-01-30T10:07:32.929Z"""

        when:
        def ret = data.getArticles()

        then:
        ret.size() == 3
    }

    def "ファイルを読んで、行のリストを返す"() {
        given:
        new File(testfilename).delete()
        new File(testfilename).text = 
"""tambara,tambara-icon.png,シャーロック・ホームズの凱旋,9784120057341,1章まで読んだ。ホームズが腐れ大学生なんだが？,2024-02-09T01:48:54.298Z
Eri KUWAHARA,kuwahara-icon.png,AIリスク教本　攻めのディフェンスで危機回避＆ビジネス加速,9784296204082,リスクの章の2つ目まで読んだ。17個は多くない！？,2024-02-07T05:24:32.911Z
harimoto,harimoto-icon.png,入門 モダンLinux,9784814400217,ワタシ、リナックスチョットデキル,2023-01-30T10:07:32.929Z"""

        when:
        def ret = data.readLines(testfilename)

        then:
        ret[0] == "tambara,tambara-icon.png,シャーロック・ホームズの凱旋,9784120057341,1章まで読んだ。ホームズが腐れ大学生なんだが？,2024-02-09T01:48:54.298Z"
    }

    def "ファイルから読んだ1行をArticleに変換する"() {
        given:
        def line = "tambara,tambara-icon.png,シャーロック・ホームズの凱旋,9784120057341,1章まで読んだ。ホームズが腐れ大学生なんだが？,2024-02-09T01:48:54.298Z"  

        when:
        def ret = data.parseLine(line)

        then:
        ret.user.name == "tambara"
        ret.user.icon == "tambara-icon.png"
        ret.book.name == "シャーロック・ホームズの凱旋"
        ret.book.isbn == "9784120057341"
        ret.message.content == "1章まで読んだ。ホームズが腐れ大学生なんだが？"
        ret.message.timestamp == Instant.parse("2024-02-09T01:48:54.298Z")
    }
}