package ru.mirea.service;

import ru.mirea.model.Manufacture;

import java.util.List;

public interface ManufactureService {
    void create(Manufacture manufacture);
    List<Manufacture> readAll();
    Manufacture read(int id);
    boolean update(Manufacture manufacture, int id);
    boolean delete(int id);
}
