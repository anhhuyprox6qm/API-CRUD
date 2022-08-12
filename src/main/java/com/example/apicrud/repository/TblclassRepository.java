package com.example.apicrud.repository;

import com.example.apicrud.model.TblclassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TblclassRepository extends JpaRepository<TblclassEntity, Integer> {
    List<TblclassEntity> findAllByName(String name);

    List<TblclassEntity> findAllByNameContainsignoreCase(String name);

//    List<TbclassEntity> findAllByNameAndEmail(String name, String email);
//
//    List<TbclassEntity> findAllByNameOrderByEmailAsc(String name);

//    void saveTbClass(TbclassEntity a);
}
