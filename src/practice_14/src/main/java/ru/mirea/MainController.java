package ru.mirea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@Controller
public class MainController {
    private ArrayList<Worker> workers = new ArrayList<>();
    private ArrayList<Manufacture> manufactures = new ArrayList<>();

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Main page");
        return "home";
    }

    @GetMapping("/workers")
    public @ResponseBody String returnItems() {
        StringBuilder builder = new StringBuilder();
        for (Worker item : workers) {
            builder.append(item.getFirstName()).append(" ")
                    .append(item.getMiddleName()).append(" ")
                    .append(item.getLastName()).append("\n");

        }
        return builder.toString();
    }

    @GetMapping("/manufactures")
    public @ResponseBody String returnOrders() {
        StringBuilder builder = new StringBuilder();
        for (Manufacture order : manufactures) {
            builder.append(order.getWorker().getFirstName()).append(" ")
                    .append(order.getWorker().getMiddleName()).append(" ")
                    .append(order.getWorker().getLastName()).append(" ")
                    .append(order.getName()).append(" ")
                    .append(order.getAddress()).append("\n");
        }
        return builder.toString();
    }

    @PutMapping("/workers/add")
    public @ResponseBody String addItem(@RequestParam String firstName,
                                        @RequestParam String middleName,
                                        @RequestParam String lastName) {
        if (findWorker(firstName) != -1) {
            return "This Worker is already exists";
        }
        workers.add(new Worker(firstName, middleName, lastName));
        return "Success!";
    }

    @PutMapping("/manufactures/add")
    public @ResponseBody String addOrder(@RequestParam String firstName,
                                         @RequestParam String middleName,
                                         @RequestParam String lastName,
                                         @RequestParam String name,
                                         @RequestParam String address) {
        Worker worker = new Worker(firstName, middleName, lastName);
        if (findManufacture(worker, name) != -1) {
            return "This Manufacture already exists";
        }
        manufactures.add(new Manufacture(name, address, worker));
        return "Success!";
    }

    @DeleteMapping("/workers/delete")
    public @ResponseBody String removeWorker(@RequestParam String firstName) {
        int id = findWorker(firstName);
        if (id == -1) {
            return "There is no such Worker";
        }
        workers.remove(id);
        return "Success";
    }

    @DeleteMapping("/manufactures/delete")
    public @ResponseBody String removeOrder(@RequestParam String firstName,
                                            @RequestParam String middleName,
                                            @RequestParam String lastName,
                                            @RequestParam String name) {
        Worker item = new Worker(firstName, middleName, lastName);
        int id = findManufacture(item, name);
        if (id == -1) {
            return "There is no such Manufacture";
        }
        manufactures.remove(id);
        return "Success!";
    }

    private int findWorker(String firstName) {
        for (int i = 0; i < workers.size(); ++i) {
            if (workers.get(i).getFirstName().equals(firstName))
                return i;
        }
        return -1;
    }

    private int findManufacture(Worker worker, String name) {
        for (int i = 0; i < manufactures.size(); ++i) {
            if (manufactures.get(i).getWorker().equals(worker) && manufactures.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }
}