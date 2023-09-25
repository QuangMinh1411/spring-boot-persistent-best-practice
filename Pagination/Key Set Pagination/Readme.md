How To Implement Keyset Pagination in Spring Boot

Description: When we rely on an offset paging we have the performance penalty induced by throwing away n records before reached the desired offset. Larger n leads to a significant performance penalty. When we have a large n is better to rely on keyset pagination which maintain a "constant" time for large datasets. In order to understand how bad offset can perform please check this article:

Screenshot from that article (offset pagination):

Need to know if there are more records?
By its nature, keyset doesn't use a SELECT COUNT to fetch the number of total records. But, with a little tweak, we can easily say if there are more records, therefore to show a button of type Next Page. Mainly, if you need such a thing then consider this application.

Key points:

choose the column(s) to act as the latest visited record (e.g., id)
use the column(s) in the WHERE and ORDER BY clauses of your SQL