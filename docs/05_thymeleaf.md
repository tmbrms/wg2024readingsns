# テンプレートエンジンで動的Webに挑戦しよう

## 前回までのあらすじ

* src/main/resources/staticにHTMLファイルを配置すると、それを静的Webページとして参照できた
* src/main/resources/static/index.html としてトップページのモックアップを配置し、それを閲覧できることを確認した
* index.htmlはarticleタグが順番に並んでいるだけのシンプルな構造。それを画面上に縦横に配置するのはCSSを使っていた
* main.cssにはposition:absolute、flexbox、Gridなどのフロー制御が含まれており、それをざっくり紹介した

## 今日やること

* テンプレートエンジンという概念を理解する
* サンプルのテンプレート(thymeleaf.html)の中をみて、必要なシンタックスを理解する
* Thymeleafのドキュメントを確認する
* index.htmlをテンプレートに直す

## 宿題

* 次回までにindex.htmlを動的ページにしてくること
