
SELECT * FROM `practice_db`.`authors` LIMIT 1000;

SELECT authors.id,authors.name,books.title
FROM authors INNER JOIN books ON authors.id=books.author_id
ORDER BY name DESC;

