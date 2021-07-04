package com.nghinv.beddingsellintroduce.service.repository.interfaces;

import com.nghinv.beddingsellintroduce.service.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {

    // https://docs.spring.io/
    // 参考１： https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories
    // 参考２： https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods


    // 6.3.3 Using JPA Named Queries
    List<User> findByUserName(String userName);

    User findByUserLogin(String userLogin);

    List<User> findBySex(Integer sex);

    List<User> findByIsAdmin(Boolean isAdmin);


    //  6.3.4 Using @Query
        // Declare query at the query method using @Query
    @Query(value = "select u from User u where u.Email = ?1")
    User findByEmailAddress(String email);

        // a. Advanced like expressions in @Query
    @Query(value = "select u from User u where u.Email like %?1%")
    List<User> findByNameContaining(String email);

        // b. Native Queries
    @Query(value = "select u from qtUsers u where u.userName = :userName or u.userLogin = :userLogin",
            nativeQuery = true)
    User findByLastnameOrFirstname(@Param("userName") String userName,
                                   @Param("userLogin") String userLogin);

        // c. Jpa Pageable
    @Query(value = "SELECT * FROM qtUsers WHERE UserName = ?1",
            countQuery = "SELECT count(*) FROM qtUsers WHERE UserName = ?1",
            nativeQuery = true)
    Page<User> findByLastname(String userName, Pageable pageable);

    // 6.3.5 Using Sort JPA
        @Query("select u from User u where u.UserName like ?1%")
        List<User> findByUserNameAndSort(String userName, Sort sort);

    // 6.3.6. Using Named Parameters
    @Query(value = "select u from qtUsers u where u.userName = :userName or u.userLogin = :userLogin",
            nativeQuery = true)
    User findByUserNameAndUserLogin(@Param("userName") String userName,
                                   @Param("userLogin") String userLogin);

    // 6.3.7. Using SpEL Expressions
    @Query("select u from #{#entityName} u where u.userName = ?1")
    List<User> findByUserName1(String userName);

    // 6.3.8. Modifying Queries
    @Modifying
    @Query(value = "update qtUsers u set u.userName = ?1 where u.userLogin = ?2",
            nativeQuery=true)
    int setFixedFirstnameFor(String userName, String userLogin);

    @Modifying
    @Query(value = "delete from qtUsers u where u.userName = ?1",
            nativeQuery=true)
    void deleteInBulkByRoleId(String userName);


    /*
        Continue...
    */

    // II. 6.4. Stored Procedures

    /*
        II.1 https://vladmihalcea.com/map-jpa-entity-to-view-or-sql-query-with-hibernate/
     */
    /*
        II.2 coding sample
         https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.stored-procedures
     */

    @Procedure("plus1inout")
    Integer explicitlyNamedPlus1inout(Integer arg);

    @Procedure(procedureName = "plus1inout")
    Integer callPlus1InOut(Integer arg);

    @Procedure(name = "User.plus1")
    Integer callPlus1InOut1(Integer arg);

    @Procedure
    Integer plus1inout(@Param("arg") Integer arg);

    @Procedure(name = "User.plus1IO")
    Integer entityAnnotatedCustomNamedProcedurePlus1IO(@Param("arg") Integer arg);


    // III. 6.x Views <> (reference : https://docs.jboss.org/hibernate/core/3.6/reference/en-US/html_single/#filters)
    /*
        1. https://vladmihalcea.com/map-jpa-entity-to-view-or-sql-query-with-hibernate/
        2. テーブルとViewsは同じ でもThe most common difficulty with views is that some database engines can't handle inserts
        or updates on views, so be aware of that if your application tries to modify the data
     */

    // Sample view and call Views: UserViewRepository
    // UserViewRepository
}
