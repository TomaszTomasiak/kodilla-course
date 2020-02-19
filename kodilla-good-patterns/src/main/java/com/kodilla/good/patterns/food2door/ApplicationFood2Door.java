package com.kodilla.good.patterns.food2door;

public class ApplicationFood2Door {

    public static void main(String[] args) {

        DataGenerator dataGenerator = new DataGenerator();
        OrderRequest orderRequest = dataGenerator.sampleOrder();

        OrderProcessor orderProcessor = new OrderProcessor();

        boolean isRealized = orderProcessor.realizeOrder(orderRequest).isRealized();
      }
}
