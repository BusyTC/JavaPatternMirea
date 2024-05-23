package ru.mirea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.model.Manufacture;
import ru.mirea.model.Worker;
import ru.mirea.service.WorkerServiceImpl;

@Controller
public class WorkersController {
    @Autowired
    private WorkerServiceImpl workerService;

    @GetMapping(path = "/workers")
    public @ResponseBody ResponseEntity getWorkers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(workerService.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping(value = "/workers/{workerId}/manufacture")
    public @ResponseBody Manufacture getWorkerManufacture(@PathVariable("workerId")
                                         Integer workerId){
        return workerService.getManufactureByWorker(workerId);
    }

    @PutMapping(path = "/workers")
    public @ResponseBody ResponseEntity createWorker(Worker worker) {
        try {
            workerService.create(worker);;
            return ResponseEntity.status(HttpStatus.OK).body("Worker was created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/workers")
    public @ResponseBody ResponseEntity deleteWorker(int id) {
        try {
            if (workerService.delete(id)) {
                return ResponseEntity.status(HttpStatus.OK).body("Worker was deleted");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error during deleting");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
