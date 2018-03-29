# SameSentence

Author: CubeSky

A Sentence Analysis Library base on HanLP and Levenshtein Distance.

## Install

You can use `Cube Repo` at [https://cubesky-mvn.github.io/](https://cubesky-mvn.github.io/)

## API

### Sentence Similar Percent

```java
SentenceAnalysis.similar("Sentence 1", "Sentence 2");
```

This will return how similar between two sentence. return value in [0,1]

### Keyword

```java
SentenceAnalysis.keyword("Sentence"); //Default size is 10
```

or

```java
SentenceAnalysis.keyword("Sentence", 10); //10 is the size of keyword
```

### Summary

```java
SentenceAnalysis.summary("Sentence"); //Default size is 10
```

or

```java
SentenceAnalysis.summary("Sentence", 10); //10 is the size of summary
```

### Phrase

```java
SentenceAnalysis.phrase("Sentence"); //Default size is 10
```

or

```java
SentenceAnalysis.phrase("Sentence", 10); //10 is the size of phrase
```

### Raw Segment

```java
SentenceAnalysis.statement("Sentence");
```

## Dependency

| Name  | Description                                                                                               | Package Name       |
|:--    |:--                                                                                                        |:--                 |
| HanLP | 自然语言处理 中文分词 词性标注 命名实体识别 依存句法分析 关键词提取 新词发现 短语提取 自动摘要 文本分类 拼音简繁  | `com.hankcs.hanlp` |

## License

This library is under Apache License 2.0.