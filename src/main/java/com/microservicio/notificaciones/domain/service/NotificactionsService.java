package com.microservicio.notificaciones.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.notificaciones.domain.dto.NotificationsDto;
import com.microservicio.notificaciones.infraestructure.repositories.NotificacionesRepository;

import jakarta.transaction.Transactional;

@Service
public class NotificactionsService {

    @Autowired
    private NotificacionesRepository notificacionesRepository;

    @Transactional
    public String sendEmailNotification(NotificationsDto notificacionDto) {
        return notificacionesRepository.sendEmailNotification(notificacionDto);
    }

    @Transactional
    public String sendPushNotification(NotificationsDto notificacionDto) {
        return notificacionesRepository.sendPushNotification(notificacionDto);
    }

}
