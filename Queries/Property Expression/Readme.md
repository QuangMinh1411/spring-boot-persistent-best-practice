Working With Spring Data Property Expressions

Description: Property expressions can refer to a direct property of the managed entity. However, you can also define constraints by traversing nested properties. This application is a sample of traversing nested properties for fetching entities and DTOs.

Key points:

Assume an Author has several Book and each book has several Review (between Author and Book there is a bidirectional-lazy @oneToMany association, and, between Book and Review there is also a bidirectional-lazy @OneToMany association)
Assume that we fetched a Review and we want to know the Author of the Book that has received this Review
via property expressions, we can write in AuthorRepository the following query that will be processed by the Spring Data Query Builder mechanism: Author findByBooksReviews(Review review);
Behind the scene Spring Data will produce a SELECT with two LEFT JOIN
In this case, the method creates the property traversal books.reviews. The algorithm starts by interpreting the entire part (BooksReviews) as the property and checks the domain class for a property with that name (uncapitalized). If the algorithm succeeds, it uses that property. If not, the algorithm splits up the source at the camel case parts from the right side into a head and a tail and tries to find the corresponding property — in our example, Books and Reviews. If the algorithm finds a property with that head, it takes the tail and continues building the tree down from there, splitting the tail up in the way just described. If the first split does not match, the algorithm moves the split point to the left and continues.
Although this algorithm should work for most cases, it is possible for the algorithm to select the wrong property. Suppose the Author class has an booksReview property as well. The algorithm would match in the first split round already, choose the wrong property, and fail (as the type of booksReview probably has no code property). To resolve this ambiguity you can use _ inside your method name to manually define traversal points. So our method name would be as follows: Author findByBooks_Reviews(Review review);
More examples (including DTOs) are available in the application