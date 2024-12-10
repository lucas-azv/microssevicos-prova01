package main.java.br.edu.iftm.tspi.shopping_api.controller;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.tspi.shopping_api.model.dto.ShoppingDTO;
import br.edu.iftm.tspi.shopping_api.service.ShopService;
import main.java.br.edu.iftm.tspi.shopping_api.model.Shop;

@RestController
@RequestMapping("/shopping")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping
    public ResponseEntity<List<ShoppingDTO>> getAll() {
        List<ShoppingDTO> shops = shopService.findAll();
        return ResponseEntity.ok(shops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingDTO> findById(@PathVariable ObjectId id) {
        ShoppingDTO shop = shopService.findById(id);
        return ResponseEntity.ok(shop);
    }

    @PostMapping
    public ResponseEntity<ShoppingDTO> save(@RequestBody Shop shop) {
        ShoppingDTO savedShop = shopService.save(shop);
        return ResponseEntity.ok(savedShop);
    }

    @GetMapping("/shopByUser")
    public ResponseEntity<List<ShoppingDTO>> getByUser(@RequestParam String userIdentifier) {
        List<ShoppingDTO> shops = shopService.getByUser(userIdentifier);
        return ResponseEntity.ok(shops);
    }

    @GetMapping("/shopByDate")
    public ResponseEntity<List<ShoppingDTO>> getByDate(@RequestParam LocalDate date) {
        List<ShoppingDTO> shops = shopService.getByDate(date);
        return ResponseEntity.ok(shops);
    }

    @GetMapping("/{productIdentifier}")
    public ResponseEntity<List<ShoppingDTO>> findByProductIdentifier(@PathVariable String productIdentifier) {
        List<ShoppingDTO> shops = shopService.findByProductIdentifier(productIdentifier);
        return ResponseEntity.ok(shops);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ShoppingDTO>> getShopsByFilter(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim,
            @RequestParam double valorMinimo) {
        List<ShoppingDTO> shops = shopService.getShopsByFilter(dataInicio, dataFim, valorMinimo);
        return ResponseEntity.ok(shops);
    }

    @GetMapping("/report")
    public ResponseEntity<List<ShoppingDTO>> getReportByDate(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {
        List<ShoppingDTO> report = shopService.getReportByDate(dataInicio, dataFim);
        return ResponseEntity.ok(report);
    }
}
