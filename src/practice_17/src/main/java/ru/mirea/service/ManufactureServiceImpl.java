package ru.mirea.service;

import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.mirea.model.Manufacture;
import ru.mirea.repository.ManufactureRepository;

import java.util.List;

@Service
public class ManufactureServiceImpl implements ManufactureService {
    private final ManufactureRepository manufactureRepository;

    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }
    public List<Manufacture> getManufactures() {
        return session.createQuery("select m from Manufacture m",
                Manufacture.class).getResultList();
    }

    public ManufactureServiceImpl(ManufactureRepository manufactureRepository, SessionFactory sessionFactory) {
        this.manufactureRepository = manufactureRepository;
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void create(Manufacture manufacture) {
        manufactureRepository.save(manufacture);
    }

    @Override
    public List<Manufacture> readAll() {
        return manufactureRepository.findAll();
    }

    @Override
    public Manufacture read(int id) {
        return manufactureRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Manufacture manufacture, int id) {
        if (manufactureRepository.existsById(id)) {
            manufacture.setId(id);
            manufactureRepository.save(manufacture);
            return  true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (manufactureRepository.existsById(id)) {
            manufactureRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
