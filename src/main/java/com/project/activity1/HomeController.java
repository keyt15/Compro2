package com.project.activity1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    private List<Coffee> coffeeList = new ArrayList<>();

    public HomeController() {
        coffeeList.add(new Coffee(1, "Espresso", "Arabica", "Small", 3.50, "Dark", "Ethiopia", false, 10, Arrays.asList("Chocolate", "Nutty"), "Espresso"));
        coffeeList.add(new Coffee(2, "Latte", "Arabica", "Medium", 4.50, "Medium", "Brazil", false, 8, Arrays.asList("Creamy", "Sweet"), "Drip"));
        coffeeList.add(new Coffee(3, "Cappuccino", "Robusta", "Large", 5.00, "Medium", "Colombia", false, 12, Arrays.asList("Fruity", "Bold"), "French Press"));
        coffeeList.add(new Coffee(4, "Mocha", "Arabica", "Medium", 4.75, "Dark", "Guatemala", false, 6, Arrays.asList("Chocolate", "Smooth"), "Espresso"));
        coffeeList.add(new Coffee(5, "Americano", "Robusta", "Large", 3.25, "Light", "Kenya", false, 15, Arrays.asList("Citrus", "Balanced"), "Drip"));
    }

    @GetMapping("/")
    public String getCoffees(Model model) {
        model.addAttribute("coffees", coffeeList);
        return "index";
    }

    @GetMapping("/delete")
    public String deleteCoffee(@RequestParam int id) {
        coffeeList.removeIf(coffee -> coffee.getId() == id);
        return "redirect:/";
    }
    @GetMapping("/add")
    public String addCoffeeForm() {
        return "new";
    }
    @PostMapping("/save")
    public String saveCoffee(@RequestParam String firstName, @RequestParam String Price) {
        int newId = Coffee.get(Coffee.size() - 1).getId() + 1;
        Coffee.add(new Coffee(newId, Name, Type));
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String editStudent(@RequestParam int id, Model model) {
        for (Coffee coffee : coffee) {
            if (coffee.getId() == id) {
                model.addAttribute("Coffee", coffee);
                return "edit";
            }
        }
        return "redirect:/";
    }
    @PostMapping("/update")
    public String updateStudent(@RequestParam int id, @RequestParam String Name, @RequestParam String Price) {
        for (Coffee coffee : coffee) {
            if (coffee.getId() == id) {
                coffee.setName(Name);
                coffee.setPrice(Price);
                break;
            }
        }
        return "redirect:/";
    }

}