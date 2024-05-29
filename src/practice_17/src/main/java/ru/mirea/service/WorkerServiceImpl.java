package ru.mirea.service;

import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.mirea.model.Manufacture;
import ru.mirea.model.Worker;
import ru.mirea.repository.WorkerRepository;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;

    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    public Manufacture getManufactureByWorker(Integer workerId) {
        return session.createQuery("from Worker where id =:id", Worker.class)
                .setParameter("id", workerId).getSingleResult().getManufacture();
    }

    public WorkerServiceImpl(WorkerRepository workerRepository, SessionFactory sessionFactory) {

        this.workerRepository = workerRepository;
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void create(Worker worker) {

        workerRepository.save(worker);
    }

    @Override
    public List<Worker> readAll() {

        return workerRepository.findAll();
    }

    @Override
    public Worker read(int id) {

        return workerRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Worker worker, int id) {
        if (workerRepository.existsById(id)) {
            worker.setId(id);
            workerRepository.save(worker);
            return  true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (workerRepository.existsById(id)) {
            workerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
