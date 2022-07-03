package com.example.Code_Sharing_Platform;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodesRepository extends CrudRepository<Snippets, Long> {
    @Query(value = "Select top 1 * from snippets where uuid=?1", nativeQuery = true)
    Snippets findByUUID(@Param("uuid") String uuid);


    @Query(value = "Select top 10 *from snippets where time<=0 and views<=0 order by id desc", nativeQuery = true)
    List<Snippets> findLast();

    @Query(value = "Select top 1 uuid from snippets order by id desc", nativeQuery = true)
    String lastUuid();

}
