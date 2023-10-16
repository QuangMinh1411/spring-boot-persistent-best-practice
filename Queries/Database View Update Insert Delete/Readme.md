How To Update/Insert/Delete Data From/In A MySQL Database View

Description: This application is an example of updating, inserting and deleting data in a MySQL database view. Every update/insert/delete will automatically update the contents of the underlying table(s).

Key points:

the database views are available in data-mysql.sql file
respect MySQL requirements for updatable and insertable database views

How To Prevent A MySQL Database View From Updating/Inserting Rows That Are Not Visible Through It Via WITH CHECK OPTION

Description: This application is an example of preventing inserts/updates of a MySQL view that are not visible through this view via WITH CHECK OPTION. In other words, whenever you insert or update a row of the base tables through a view, MySQL ensures that the this operation is conformed with the definition of the view.

Key points:

add WITH CHECK OPTION to the view
this application will throw an exception of type java.sql.SQLException: CHECK OPTION failed 'bookstoredb.author_anthology_view