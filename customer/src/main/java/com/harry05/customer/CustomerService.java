package com.harry05.customer;

import com.harry05.amqp.RabbitMQMessageProducer;
import com.harry05.clients.fraud.FraudCheckResponse;
import com.harry05.clients.fraud.FraudClient;
import com.harry05.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              FraudClient fraudClient,
                              RabbitMQMessageProducer rabbitMQMessageProducer) {

    public void registerCustomer( CustomerRegistrationRequest request ) {
        Customer customer = Customer.builder().
                firstName(request.firstName()).
                lastName(request.lastName()).
                email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if ( fraudCheckResponse.isFraudster() ){
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Harry05...",
                        customer.getFirstName())
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}