How To Use Subqeries in JPQL WHERE/HAVING Clause

Description: This application is an example of using subqueries in JPQL WHERE clause (you can easily use it in HAVING clause as well).

Key points:
Keep in mind that subqueries and joins queries may or may not be semantically equivalent (joins may returns duplicates that can be removed via DISTINCT).

Even if the Execution Plan is specific to the database, historically speaking joins are faster than subqueries among different databases, but this is not a rule (e.g., the amount of data may significantly influence the results). Of course, do not conclude that subqueries are just a replacement for joins that doesn't deserve attention. Tuning subqueries can increases their performance as well, but this is an SQL wide topic. So, benchmark! Benchmark! Benchmark!

As a rule of thumb, prefer subqueries only if you cannot use joins, or if you can prove that they are faster than the alternative joins.

How To Return A Map Result From A Spring Data Query Method

Description: Sometimes, we need to write in repositories certain query-methods that return a Map instead of a List or a Set. For example, when we need a Map<Id, Entity> or we use GROUP BY and we need a Map<Group, Count>. This application shows you how to do it via default methods directly in repository.

Key points:

rely on default methods and Collectors.toMap()