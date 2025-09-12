package com.taller1.observer;


import com.taller1.model.Product;

public interface StockObserver {
    void notify(Product product);
}
