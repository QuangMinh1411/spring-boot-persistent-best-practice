Why And How To Avoid The AUTO Generator Type In Hibernate 5 And MySQL

If you prefer to read it as a blog-post containing the relevant snippets of code then check this post

Description: In MySQL & Hibernate 5, the GenerationType.AUTO generator type will result in using the TABLE generator. This adds a significant performance penalty. Turning this behavior to IDENTITY generator can be obtained by using GenerationType.IDENTITY or the native generator.

Key points:

use GenerationType.IDENTITY instead of GenerationType.AUTO
use the native generator - exemplified in this application