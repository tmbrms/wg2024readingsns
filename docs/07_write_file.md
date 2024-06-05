# 投稿機能を作ってみよう

## 前回までのあらすじ
* CSV形式のファイルを読んで、Articleデータを作成出来るようになった
* テスト駆動開発のやり方を学んだ
  1. ToDoリストにやるべきことを書く
  2. ToDoリストから1つ取り出して、テストを実装する
  3. テストが失敗することを確認する
  4. テストを成功させるように実装を作る
  5. ToDoから完了したタスクを消し、次のToDoに取りかかる
  6. すべてのToDoが消えたら、テストを成功させたまま、コードをキレイにする

## 元の画面をファイルのデータから作ってみよう

DataStore.getArticles()を、前回作ったDataStore.getFileContents()とDataStore.createArticle()を
組み合わせたものに作り直そう。

実質、順番に呼ぶだけなので、DataStore.getArticles()のテストコードは必要ない。
GradleでbootRunして、トップページがいままで通り表示されるかを確かめよう。

## ファイルフォーマットを変更しよう

前回までのファイルフォーマットでは、1行にArticleを構成する全ての情報が入っていました。
しかし、Userの情報とBookの情報はそんなに頻繁に変更されません。

一方、Messageの情報はどんどん変更されます。なんせSNSですから・・・

なので、3つのファイルにわけて、それらを全て読み込んでArticleを作るように変えてみましょう

## Messageの読込方法を変更しよう

Messageのファイルのフォーマットはこんな感じになるでしょうか。
投稿時間、メッセージの投稿者、メッセージ本文の3つのデータが含まれていればOKでしょう。
メッセージが投稿されたとき、このファイルを更新するのだとすると、ファイル更新がぶつかってしまいそうです。
なので、このファイルは新しいメッセージをどんどん後ろに付け足していくことにします。

```
2024-02-07T05:24:32.911Z,tambara,1章まで読んだ。ホームズが腐れ大学生なんだが？
2024-02-08T05:24:32.911Z,tambara,2章まで読んだ。挫折しそう
```

このようなファイルがある中で、表示するものを「同じ人のメッセージの中で、投稿日時が一番新しいもの」に限定する機能を作りましょう

## 投稿機能を作りましょう

以下の2つを作りましょう。

* 投稿画面
  * 以下の入力欄がある
    * 名前(認証機能がまだないのでなりすましできますが、あとで変更しましょう)
    * 書名とISBN(省略すると前回の投稿と同じ本についてコメントしたと見なしましょう)
    * メッセージ

* 投稿機能
  * ControllerにPOSTを受け取るメソッドを作ります
  * 本の情報を更新できるようにします
    * ファイルロックが必要かどうか検討してください
  * メッセージを追加出来るようにします