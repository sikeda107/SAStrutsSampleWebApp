# SAStruts サンプルアプリ

# 実行方法

```bash
# プロジェクトダウンロード
git clone https://github.com/sikeda107/SAStrutsSampleWebApp.git

# DB初期データ投入
cd SAStrutsSampleWebApp
docker-compose -f docker-compose-db.yml up
# SequelAceでtestdata.sqlを実行
docker-compose -f docker-compose-db.yml down

# アプリの起動
./graldew clean build -x test
docker-compose up
open http://localhost:8080/app/
# ctrl + c で終了

# コード修正後の起動
docker-compose down && ./graldew clean build -x test && docker-compose up
```

# 技術

- Java11 ([Amazon Corretto](https://aws.amazon.com/jp/corretto/))
- [Apache Tomcat 9](https://tomcat.apache.org/download-90.cgi)
- [MySQL 5.6](https://dev.mysql.com/doc/refman/5.6/ja/)
- [Gradle Build Tool](https://gradle.org/)
- [Seasar2](http://s2container.seasar.org/2.4/ja/)
    - WEBフレームワーク [Super Agile Struts](http://sastruts.seasar.org/)
    - O/Rマッパー[S2JDBC](http://s2container.seasar.org/2.4/ja/s2jdbc.html)
    - テスティング [JUnit 4](https://junit.org/junit4/) & [S2JUnit4](http://s2container.seasar.org/2.4/ja/S2JUnit4.html)

## [Seasar プロジェクト](https://www.seasar.org/)

> Seasarプロジェクトが提供するプロダクトの多くは 2016年9月26日 をもって EOL (End of Life) となります。
> EOLとなるのは以下を除いた全プロダクトです。
> ・DBFlute
> ・DBFlute.NET
> ・Doma
> ・Emecha
> ・Mayaa
> ・S2Container.NET
> ・S2Dao.NET
> 上記以外のプロダクトは全て2016年9月26日をもってEOLとなり、 Seasarプロジェクトによるメンテナンスおよびサポートは終了となります。

# [Super Agile Struts (SAStruts)](http://sastruts.seasar.org/)

> Super Agile Struts(以降SAStrutsと省略)は、Strutsを使った開発をSuper Agileに行なうためのフレームワークです。

参考

- [チュートリアル](http://sastruts.seasar.org/tutorial.html)
- [機能リファレンス](http://sastruts.seasar.org/featureReference.html)

## S2Containerとは

- [DIコンテナ（Dependency Injection container）とは - IT用語辞典 e-Words](https://e-words.jp/w/DI%E3%82%B3%E3%83%B3%E3%83%86%E3%83%8A.html)
- [S2Container#FeatureReference](http://s2container.seasar.org/2.4/ja/DIContainer.html#FeatureReference)
- [Seasar - DI Container with AOP - #Quickstart](http://s2container.seasar.org/2.3/ja/DIContainer.html#Quickstart)

## S2AOPとは

- [AOP（アスペクト指向プログラミング）とは - IT用語辞典 e-Words](https://e-words.jp/w/AOP.html)
- [S2AOP](http://s2container.seasar.org/2.4/ja/aop.html)

# [S2JDBC](http://s2container.seasar.org/2.4/ja/s2jdbc.html)

> S2JDBCは、データベースプログラミングの生産性を10倍以上高めることを目標として作成した Seasar2のO/R Mapperです。何に比べて生産性が10倍かというとJava標準のJPA(Java Persistence API)に対してです。次のような特徴があります。

# [S2Junit4](http://s2container.seasar.org/2.4/ja/S2JUnit4.html)

> S2JUnit4はJUnit4を拡張したテスティングフレームワークです。 S2JUnit4はアノテーションと命名規則をバランス良く組み合わせ少ないコードで効率のよいテストを可能にします。
>
> **自動フィールドバインディング**   
> 自動フィールドバインディングとはコンテナに管理されたコンポーネントを特定のルールに従ってテストクラスのフィールドに自動でセットする機能です。

# 他参考

- [【Java】フレームワークSeasar2とは？概要を解説します - ゲーマーときどきエンジニア](https://www.tairax.com/entry/study/Java/Seasar2/brief)
