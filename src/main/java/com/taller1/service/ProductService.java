package com.taller1.service;
import com.taller1.model.Product;
import com.taller1.observer.StockObserver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private final List<StockObserver> observers;

    public ProductService(List<StockObserver> observers) {
        this.observers = observers;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateStock(String name, int newStock) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                p.setStock(newStock);
                notifyObservers(p);
                break;
            }
        }
    }

    private void notifyObservers(Product product) {
        for (StockObserver obs : observers) {
            obs.notify(product);
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
