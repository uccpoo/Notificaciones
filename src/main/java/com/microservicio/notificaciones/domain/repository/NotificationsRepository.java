package com.microservicio.notificaciones.domain.repository;

import com.microservicio.notificaciones.domain.dto.NotificationsDto;

public interface NotificationsRepository {

    String sendEmailNotification(NotificationsDto notificacionDto);
    String sendPushNotification(NotificationsDto notificacionDto);
}
