package ru.mirea.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mirea.model.Worker;
import ru.mirea.service.WorkerServiceImpl;

@Controller
public class WorkersController {
    @Autowired
    private WorkerServiceImpl workerService;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("workers")
    public String getWorkersPage(Model model, @RequestParam(required = false) String sort) {
        model.addAttribute("workers", workerService.readAll());
        return "workers";
    }

    @GetMapping(path = "/workers/get_workers")
    public @ResponseBody ResponseEntity getWorkers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(workerService.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "/workers/add_worker")
    public String createWorker(Worker worker) {
        try {
            // worker.setFirstName(new String());
            workerService.create(worker);;
            return "redirect:/workers";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/workers/delete_worker")
    public String deleteWorker(int id) {
        try {
            workerService.delete(id);
            return "redirect:/workers";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/workers/filter")
    public @ResponseBody ResponseEntity filterWorkers(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String middleName,
            @RequestParam(required = false) String lastName) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(workerService.filterWorkers(firstName, middleName, lastName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
