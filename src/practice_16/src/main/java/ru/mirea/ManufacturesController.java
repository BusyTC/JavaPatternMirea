package ru.mirea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mirea.service.ManufactureServiceImpl;
import ru.mirea.model.Manufacture;

@Controller
public class ManufacturesController {
    @Autowired
    private ManufactureServiceImpl manufactureService;

    @GetMapping(path = "/manufactures")
    public @ResponseBody ResponseEntity getManufactures() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(manufactureService.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping(path = "/manufactures")
    public @ResponseBody ResponseEntity createManufacture(Manufacture manufacture) {
        try {
            manufactureService.create(manufacture);;
            return ResponseEntity.status(HttpStatus.OK).body("Manufacture was created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/manufactures")
    public @ResponseBody ResponseEntity deleteManufacture(int id) {
        try {
            if (manufactureService.delete(id)) {
                return ResponseEntity.status(HttpStatus.OK).body("Manufacture was deleted");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error during deleting");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
