How To Create Specification Query Fetch Joins

Description: This application contains two examples of how to define JOIN in Specification to emulate JPQL join-fetch operations.

Key points:

the first approach trigger two SELECT statements and the pagination is done in memory (very bad!)
the second approach trigger three SELECT statements but the pagination is done in the database
in both approaches the JOIN is defined in a Specification implementation