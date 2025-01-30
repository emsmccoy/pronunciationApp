# JPA

[In Spring Boot what is the difference between CrudRepository and JpaRepository in extending a Java repository interface - Stack Overflow](https://stackoverflow.com/questions/72058502/in-spring-boot-what-is-the-difference-between-crudrepository-and-jparepository-i)

## CrudRepository vs. JpaRepository

| CrudRepository                                                                                         | JpaRepository                                                                                                                                     |
| ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| CrudRepository does not provide any method for pagination and sorting.                                 | JpaRepository extends PagingAndSortingRepository. It provides all the methods for implementing the pagination.                                    |
| It works as a **marker** interface.                                                                    | JpaRepository extends both **CrudRepository** and **PagingAndSortingRepository**.                                                                 |
| It provides CRUD function only. For example **findById(), findAll(),** etc.                            | It provides some extra methods along with the method of PagingAndSortingRepository and CrudRepository. For example, **flush(), deleteInBatch().** |
| It is used when we do not need the functions provided by JpaRepository and PagingAndSortingRepository. | It is used when we want to implement pagination and sorting functionality in an application.                                                      |
