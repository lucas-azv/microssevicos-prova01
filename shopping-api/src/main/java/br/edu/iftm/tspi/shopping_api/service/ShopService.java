package main.java.br.edu.iftm.tspi.shopping_api.service;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.tspi.shopping_api.model.dto.ShoppingDTO;
import main.java.br.edu.iftm.tspi.shopping_api.model.Shop;
import main.java.br.edu.iftm.tspi.shopping_api.repository.ShopRepository;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<ShoppingDTO> findAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops.stream().map(this::convertToDTO).toList();
    }

    public ShoppingDTO findById(ObjectId id) {
        Shop shop = shopRepository.findById(id).orElseThrow();
        return convertToDTO(shop);
    }

    public ShoppingDTO save(Shop shop) {
        Shop savedShop = shopRepository.save(shop);
        return convertToDTO(savedShop);
    }

    public ShoppingDTO update(ObjectId id, ShoppingDTO shoppingDto) {
        Shop shop = shopRepository.findById(id).orElseThrow();
        shop.setUserIdentifier(shoppingDto.getUserIdentifier());
        shop.setDate(shoppingDto.getDate());
        shop.setItems(shoppingDto.getItems());
        shop.setTotal(shoppingDto.getTotal());
        return convertToDTO(shopRepository.save(shop));
    }

    public void delete(ObjectId id) {
        shopRepository.deleteById(id);
    }

    public List<ShoppingDTO> getByUser(String userIdentifier) {
        List<Shop> shops = shopRepository.findByUserIdentifier(userIdentifier);
        return shops.stream().map(this::convertToDTO).toList();
    }

    public List<ShoppingDTO> getByDate(LocalDate date) {
        List<Shop> shops = shopRepository.findByDate(date);
        return shops.stream().map(this::convertToDTO).toList();
    }

    public List<ShoppingDTO> getShopsByFilter(LocalDate dataInicio, LocalDate dataFim, double valorMinimo) {
        List<Shop> shops = shopRepository.findByFilter(dataInicio, dataFim, valorMinimo);
        return shops.stream().map(this::convertToDTO).toList();
    }

    public List<ShoppingDTO> getReportByDate(LocalDate dataInicio, LocalDate dataFim) {
        List<Shop> shops = shopRepository.findByDateRange(dataInicio, dataFim);
        return shops.stream().map(this::convertToDTO).toList();
    }

    private ShoppingDTO convertToDTO(Shop shop) {
        ShoppingDTO dto = new ShoppingDTO();
        dto.setId(shop.getId().toString());
        dto.setUserIdentifier(shop.getUserIdentifier());
        dto.setDate(shop.getDate());
        dto.setItems(shop.getItems());
        dto.setTotal(shop.getTotal());
        return dto;
    }
}
