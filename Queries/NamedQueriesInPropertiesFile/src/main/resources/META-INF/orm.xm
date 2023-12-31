<?xml version="1.0" encoding="UTF-8"?>

<entity-mappings version="2.0" xmlns="http://java.sun.com/xml/ns/persistence/orm"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://java.sun.com/xml/ns/persistence/orm
        http://java.sun.com/xml/ns/persistence/orm_2_0.xsd ">

    <!-- Named Queries -->
    <!-- Find all authors -->
    <named-query name="Author.fetchAll">
        <query>SELECT a FROM Author a</query>
    </named-query>

    <!-- Find author by name and age -->
    <named-query name="Author.fetchByNameAndAge">
        <query>SELECT a FROM Author a WHERE a.name=?1 AND a.age=?2</query>
    </named-query>

    <!-- Find authors ordered descending by name via Sort -->
    <!-- causes exception
    <named-query name="Author.fetchViaSort">
        <query>SELECT a FROM Author a</query>
    </named-query>
    -->

    <!-- Find authors older than 30 ordered descending by name via Sort -->
    <!-- causes exception
    <named-query name="Author.fetchViaSortWhere">
        <query>SELECT a FROM Author a WHERE a.age > ?1</query>
    </named-query>
    -->

    <!-- Find page of authors ordered descending by name via Pageable -->
    <named-query name="Author.fetchPageSort">
        <query>SELECT a FROM Author a</query> <!-- ignore sort -->
    </named-query>

   <!-- Find page of authors older than 30 ordered descending by name via Pageable -->
    <named-query name="Author.fetchPageSortWhere">
        <query>SELECT a FROM Author a WHERE a.age > ?1</query> <!-- ignore sort -->
    </named-query>

    <!-- Find slice of authors ordered descending by name via Pageable -->
    <named-query name="Author.fetchSliceSort">
        <query>SELECT a FROM Author a</query> <!-- ignore sort -->
    </named-query>

    <!-- Find slice of authors older than 30 ordered descending by name via Pageable -->
    <named-query name="Author.fetchSliceSortWhere">
        <query>SELECT a FROM Author a WHERE a.age > ?1</query> <!-- ignore sort -->
    </named-query>

    <!-- Named Native Queries-->
    <!-- Find all authors (native) -->
    <named-native-query name="Author.fetchAllNative"
                        result-class="com.bookstore.entity.Author">
        <query>SELECT * FROM author</query>
    </named-native-query>

    <!-- Find author by name and age (native) -->
    <named-native-query name="Author.fetchByNameAndAgeNative"
                        result-class="com.bookstore.entity.Author">
        <query>SELECT * FROM author WHERE name=?1 AND age=?2</query>
    </named-native-query>

    <!-- Find authors ordered descending by name via Sort (native) -->
    <!-- causes exception
    <named-native-query name="Author.fetchViaSortNative"
                        result-class="com.bookstore.entity.Author">
        <query>SELECT * FROM author</query>
    </named-native-query>
    -->

    <!-- Find authors older than 30 ordered descending by name via Sort (native) -->
    <!-- causes exception
    <named-native-query name="Author.fetchViaSortWhereNative"
                        result-class="com.bookstore.entity.Author">
        <query>SELECT * FROM author WHERE age > ?1</query>
    </named-native-query>
    -->

    <!-- Find page of authors ordered descending by name via Pageable (native) -->
    <named-native-query name="Author.fetchPageSortNative"
                        result-class="com.bookstore.entity.Author">
        <query>SELECT * FROM Author a</query> <!-- ignore sort -->
    </named-native-query>

    <!-- Find page of authors older than 30 ordered descending by name via Pageable (native) -->
    <named-native-query name="Author.fetchPageSortWhereNative"
                        result-class="com.bookstore.entity.Author">
        <query>SELECT * FROM Author a WHERE a.age > ?1</query> <!-- ignore sort -->
    </named-native-query>

    <!-- Find slice of authors ordered descending by name via Pageable (native) -->
    <named-native-query name="Author.fetchSliceSortNative"
                        result-class="com.bookstore.entity.Author">
        <query>SELECT * FROM author</query> <!-- ignore sort -->
    </named-native-query>

    <!-- Find slice of authors older than 30 ordered descending by name via Pageable (native) -->
    <named-native-query name="Author.fetchSliceSortWhereNative"
                        result-class="com.bookstore.entity.Author">
        <query>SELECT * FROM author WHERE age > ?1</query> <!-- ignore sort -->
    </named-native-query>
</entity-mappings>