package com.ibmtambara.readingsns;

import java.util.List;
import java.util.ArrayList;

public class DataStore {
    public DataStore(){
        
    }

    public List<Article> getArticles(){
        List<Article> ret = new ArrayList<Article>();

        var article = new Article();

        article.setUser("tambara", "tambara-icon.png");
        article.setBook("シャーロック・ホームズの凱旋", "9784120057342");
        article.setMessage("2章まで読んだ。ホームズが腐れ大学生なんだが？", "2024-02-09T01:48:54.298Z");
        ret.add(article);

        article = new Article();
        article.setUser("Eri KUWAHARA", "kuwahara-icon.png");
        article.setBook("AIリスク教本　攻めのディフェンスで危機回避＆ビジネス加速", "9784296204083");
        article.setMessage("リスクの章の3つ目まで読んだ。17個は多くない！？", "2024-02-07T05:24:32.911Z");
        ret.add(article);

        article = new Article();
        article.setUser("harimoto","harimoto-icon.png");
        article.setBook("入門 モダンLinux", "9784814400218");
        article.setMessage("ワタシ、リナックスチョットデキル", "2024-01-30T10:07:32.929Z");
        ret.add(article);

        return ret;
    }
}
