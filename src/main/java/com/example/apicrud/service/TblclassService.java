package com.example.apicrud.service;

import com.example.apicrud.model.TblclassEntity;

import java.util.List;

public interface TblclassService {
    public void saveTblClass(TblclassEntity u);
    public void deleteTblClass(Integer id);
    public TblclassEntity findById(Integer id);
    public List<TblclassEntity> findAll();

    public List<TblclassEntity> findAllByName(String name);
}
