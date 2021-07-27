SELECT FirstName, LastName, a.City, a.State
FROM Person p
LEFT JOIN Address a
ON p.PersonId = a.PersonId

 -- Since the PersonId in table Address is the foreign key of table Person, we can join this two table to get the address information of a person.

 -- Considering there might not be an address information for every person, we should use outer join instead of the default inner join.
