package com.example.apicrud.service;

import com.example.apicrud.model.TblclassEntity;
import com.example.apicrud.repository.TblclassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TblclassServiceImpl implements  TblclassService{
    @Autowired
    TblclassRepository tblclassRepository;

    @Override
    public void saveTblClass(TblclassEntity a) {
        tblclassRepository.save(a);
    }

    @Override
    public void deleteTblClass(Integer id) {tblclassRepository.deleteById(id);
    }

    @Override
    public TblclassEntity findById(Integer id) {return tblclassRepository.findById(id).get();
    }

    @Override
    public List<TblclassEntity> findAll() {
        return tblclassRepository.findAll();
    }

    @Override
    public List<TblclassEntity> findAllByName(String name) {
        return tblclassRepository.findAllByNameContainsignoreCase(name);
    }
}
