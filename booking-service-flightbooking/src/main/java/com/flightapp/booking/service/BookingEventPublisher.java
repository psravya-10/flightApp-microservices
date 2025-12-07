package com.flightapp.booking.service;

import com.flightapp.booking.dto.BookingEvent;
import com.flightapp.booking.dto.BookingStatus;
import com.flightapp.booking.entity.Booking;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookingEventPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final String exchange;
    private final String routingKey;

    public BookingEventPublisher(RabbitTemplate rabbitTemplate,
                                 @Value("${app.rabbitmq.exchange}") String exchange,
                                 @Value("${app.rabbitmq.routing-key}") String routingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public void publishBookingConfirmed(Booking booking) {
        BookingEvent event = new BookingEvent(
                booking.getPnr(),
                booking.getEmail(),
                booking.getCustomerName(),
                BookingStatus.CONFIRMED
        );
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
    }

    public void publishBookingCancelled(Booking booking) {
        BookingEvent event = new BookingEvent(
                booking.getPnr(),
                booking.getEmail(),
                booking.getCustomerName(),
                BookingStatus.CANCELLED
        );
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
    }
}
