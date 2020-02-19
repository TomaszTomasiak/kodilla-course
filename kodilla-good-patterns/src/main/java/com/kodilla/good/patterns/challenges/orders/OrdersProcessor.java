package com.kodilla.good.patterns.challenges.orders;

public class OrdersProcessor {


    private UserOrder userOrder;
    private Communication communication;
    private OrderRepository orderRepository;
    private SourceOfProducts sourceOfProducts;

    public OrdersProcessor(UserOrder userOrder, Communication communication, OrderRepository orderRepository, SourceOfProducts sourceOfProducts) {
        this.userOrder = userOrder;
        this.communication = communication;
        this.orderRepository = orderRepository;
        this.sourceOfProducts = sourceOfProducts;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = sourceOfProducts.productOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getOrderedPieces());

        if (isOrdered) {

            communication.sendConfirmation(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getOrderedPieces());
            userOrder.addProductToOrder(orderRequest.getProduct(), orderRequest.getOrderedPieces());

            System.out.println("Product ordered. DTO created");

            return new OrderDto(orderRequest.getUser(), true);

        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
