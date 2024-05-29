package ru.mirea.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("manufactures")
    public String getManufacturesPage(Model model) {
        model.addAttribute("manufactures", manufactureService.readAll());
        return  "manufactures";
    }

    @GetMapping(path = "/manufactures/get_manufactures")
    public @ResponseBody ResponseEntity getManufactures() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(manufactureService.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "/manufactures/add_manufacture")
    public String createManufacture(Manufacture manufacture) {
        try {
            // manufacture.setManufactureName(new String());
            manufactureService.create(manufacture);
            return "redirect:/manufactures";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/manufactures/delete_manufacture")
    public String deleteManufacture(int id) {
        try {
            manufactureService.delete(id);
            return "redirect:/manufactures";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
