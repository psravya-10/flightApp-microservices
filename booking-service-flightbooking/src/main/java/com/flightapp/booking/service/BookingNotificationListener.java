package com.flightapp.booking.service;

import com.flightapp.booking.dto.BookingEvent;
import com.flightapp.booking.dto.BookingStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class BookingNotificationListener {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String from;

    public BookingNotificationListener(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void handleBookingEvent(BookingEvent event) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(event.getEmail());

        if (event.getStatus() == BookingStatus.CONFIRMED) {
            message.setSubject("Booking Confirmed - PNR: " + event.getPnr());
            message.setText("""
                    Hello %s,
                    
                    Your flight booking with PNR %s is CONFIRMED.
                    
                    Thank you for booking with FlightApp.
                    """.formatted(event.getCustomerName(), event.getPnr()));
        } else if (event.getStatus() == BookingStatus.CANCELLED) {
            message.setSubject("Booking Cancelled - PNR: " + event.getPnr());
            message.setText("""
                    Hello %s,
                    
                    Your flight booking with PNR %s has been CANCELLED.
                    
                    If this was not done by you, please contact support.
                    """.formatted(event.getCustomerName(), event.getPnr()));
        }

        mailSender.send(message);
    }
}
