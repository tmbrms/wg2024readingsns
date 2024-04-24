# データをファイルから読み込んでみよう

## 前回までのあらすじ
* トップページの静的HTML版を表示できた
* HTMLとCSSの構成を理解した
* テンプレートエンジンを使って、動的HTML版を作成した

## ユニットテストを実行出来るようにする

### Spock

最新の安定版は2.3ですが2.4M1以降でSpring Boot3対応がされているので2.4の最新M4を使います
(2.4はいつリリースされるんだろう・・・？)

* https://spockframework.org/spock/docs/2.4-M4/index.html
* https://groovy-lang.org/documentation.html
* https://koji-k.github.io/groovy-tutorial/index.html

Maven Centralの使い方も確認しましょう

## ユニットテストを書きながらの開発について

細かいステップで、どう作るか考えながらコーディングしていきます。

今回のゴールは、Controllerから呼び出しているgetArticlesメソッドの中身が、
データが記載されいるファイルを読み込んで返す形に変更していきます。

1. まず、テスト対象のコードを独立したクラスに分離させましょう
1. 分離したクラスをテストから呼び出してみましょう
1. ファイルをGroovyで書き込んでみましょう
1. ファイルをJavaから読み込んでみましょう
1. 読んだ1行を整形してみよう
