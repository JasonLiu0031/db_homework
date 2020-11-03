package org.scu_db.demo.Repository;

import org.scu_db.demo.model.Book;
import org.scu_db.demo.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //继承于JpaRepository,其中Title为对应的实体类，String为实体类主键属性

    Book findBooksByBookId(Integer bookId);

    @Query(value = "select * from book where book_id =?1", nativeQuery = true)
    List<Book> findBookByIdUseSql(Integer bookId);

    @Query(value = "select Book_ID from Book  where BorrowerMemNo IS NOT NULL",nativeQuery = true)
    List<Integer> findbookidwhichnotborrowed();



    @Query(value = "select count(*) from Title where CallNumber ='Call123' ",nativeQuery = true)
    Integer numofbookcall123();

    @Query(value = "select CallNumber from Book group by CallNumber having count(*) <=2",nativeQuery = true)
    List<String> findcallnum();

    //设置事务注解，当操作失败时进行回滚
    @Transactional
    void deleteBookByBookId(Integer bookId);

}

