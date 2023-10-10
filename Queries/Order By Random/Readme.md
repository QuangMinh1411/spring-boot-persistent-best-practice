How To Shuffle Small Result Sets

Description: This application is an example of shuffling small results sets. DO NOT USE this technique for large results sets, since is extremely expensive.

Key points:

write a JPQL SELECT query and append to it ORDER BY RAND()
each RDBMS support a function similar to RAND() (e.g., in PostgreSQL is random())