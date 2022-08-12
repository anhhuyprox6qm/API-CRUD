package com.example.apicrud.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tblclass", schema = "admin", catalog = "")
public class TblclassEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    @NotNull
    @Size(min = 2, message = "Name should have at least 2 characters")

    private String name;
    @Basic
    @Column(name = "room")
    @NotNull
    @Size(min = 2, message = "Room should have at least 2 characters")
    private String room;
    @Basic
    @Column(name = "note")
    @NotNull
    @Size(min = 2, message = "Note should have at least 2 characters")
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblclassEntity that = (TblclassEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(room, that.room) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, room, note);
    }
}
