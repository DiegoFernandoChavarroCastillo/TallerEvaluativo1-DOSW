package com.taller1.observer;

import com.taller1.model.Product;
import org.springframework.stereotype.Component;

@Component
public class WarningAgent implements StockObserver {
    @Override
    public void notify(Product product) {
        if (product.getStock() < 5) {
            System.out.println("ALERTA: El producto " + product.getName() +
                    " tiene menos de 5 unidades");
        }
    }
}
