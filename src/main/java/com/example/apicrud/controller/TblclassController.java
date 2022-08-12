package com.example.apicrud.controller;

import com.example.apicrud.model.TblclassEntity;
import com.example.apicrud.service.TblclassService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

public class TblclassController {
    @Autowired
    TblclassService tblclassService;

    @RequestMapping(value = "tblclass", method = RequestMethod.GET)
    public ResponseEntity<List<TblclassEntity>> findAllUser(){
        List<TblclassEntity> lsTblclass = tblclassService.findAll();
        if (lsTblclass.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
//            return new ResponseEntity.ok(lsUser);
        }
        return new  ResponseEntity<List<TblclassEntity>>(lsTblclass,HttpStatus.OK);
    }
    @RequestMapping(value = "tblclass", method = RequestMethod.GET)
    public ResponseEntity<List<TblclassEntity>> findAllUser(@PathParam("name") String name){
        List<TblclassEntity> lsTblclass = tblclassService.findAllByName(name);
        if (lsTblclass.size() == 0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
//            return new ResponseEntity.ok(lsUser);
        }
        return new  ResponseEntity<List<TblclassEntity>>(lsTblclass,HttpStatus.OK);
    }

    @RequestMapping(value = "savetblclass", method = RequestMethod.POST)
    public ResponseEntity<TblclassEntity> saveNewUser(@RequestBody TblclassEntity a){
        tblclassService.saveTblClass(a);
        return new ResponseEntity<TblclassEntity>(a, HttpStatus.OK);
    }
    @RequestMapping(value = "updatetblclass", method = RequestMethod.PUT)
    public ResponseEntity<TblclassEntity> updateUser(
            @PathParam("id") Integer id,
            @RequestBody TblclassEntity a){
        TblclassEntity oldTblclass = tblclassService.findById(id);
        oldTblclass.setId(a.getId());
        oldTblclass.setName(a.getName());
        oldTblclass.setRoom(a.getRoom());
        oldTblclass.setNote(a.getNote());
        tblclassService.saveTblClass(oldTblclass);
        return new ResponseEntity<TblclassEntity>(a, HttpStatus.OK);
    }
    @RequestMapping(value = "updateuser2/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TblclassEntity> updateUser2(
            @PathParam(value = "id") Integer id,
            @RequestBody TblclassEntity a){
        TblclassEntity oldTblclass = tblclassService.findById(id);
        oldTblclass.setId(a.getId());
        oldTblclass.setName(a.getName());
        oldTblclass.setRoom(a.getRoom());
        oldTblclass.setNote(a.getNote());
        tblclassService.saveTblClass(oldTblclass);
        return new ResponseEntity<TblclassEntity>(a, HttpStatus.OK);
    }
    @RequestMapping(value = "updatetbclass/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TblclassEntity> deleteUser(@PathVariable(value = "id") Integer id){
        tblclassService.deleteTblClass(id);
        return ResponseEntity.ok().build();
    }
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName()  + " "
                    + violation.getPropertyPath() + ": "
                    + violation.getMessage());
        }
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
