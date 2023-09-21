How To Implement Offset Pagination in Spring Boot

Description: This is a regular Spring Boot offset pagination example. However, is not advisable to use this approach in production because of its performance penalties explained further.

When we rely on an offset pagination, we have the performance penalty induced by throwing away n records before reaching the desired offset. Larger n leads to a significant performance penalty. Another penalty is the extra-SELECT needed to count the total number of records. In order to understand how bad offset pagination can perform please check this article