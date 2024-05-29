package ru.mirea.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import ru.mirea.model.Manufacture;
import ru.mirea.model.Worker;
import ru.mirea.repository.WorkerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final EntityManager entityManager;

    public WorkerServiceImpl(WorkerRepository workerRepository, EntityManager entityManager) {
        this.workerRepository = workerRepository;
        this.entityManager = entityManager;
    }

    public List<Worker> filterWorkers(String firstName, String middleName, String lastName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Worker> query = cb.createQuery(Worker.class);
        Root<Worker> worker = query.from(Worker.class);

        List<Predicate> predicates = new ArrayList<>();

        if (firstName != null) {
            predicates.add(cb.like(worker.get("firstName"), "%" + firstName + "%"));
        }
        if (middleName != null) {
            predicates.add(cb.like(worker.get("middleName"), "%" + middleName + "%"));
        }
        if (lastName != null) {
            predicates.add(cb.like(worker.get("lastName"), "%" + lastName + "%"));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
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
