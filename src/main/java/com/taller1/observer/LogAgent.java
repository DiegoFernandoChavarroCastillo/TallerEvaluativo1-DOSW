package com.taller1.observer;

import com.taller1.model.Product;
import org.springframework.stereotype.Component;

@Component
public class LogAgent implements StockObserver {
    @Override
    public void notify(Product product) {
        System.out.println("Producto actualizado: " + product.getName() +
                " | Stock disponible: " + product.getStock());
    }
}
