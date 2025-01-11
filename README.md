# Transactional Annotation

This annotation is used to mark methods or classes in a Spring application to participate in transaction management. 

## Usage

To use the `@Transactional` annotation, you need to have the `spring-tx` dependency in your project's dependencies.

```java
import org.springframework.transaction.annotation.Transactional;

 @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Order processOrder(Order order) {
        log.info("Processing order: {}", order);
        Long productId = order.getProductId();

        Product product = inventoryHandler.getProduct(productId);
        if (product.getStockQuantity() < order.getQuantity()) {
            log.error("Not enough stock for product: {}", productId);
            throw new RuntimeException("Not enough stock for product: " + productId);
        }
     }
}
```