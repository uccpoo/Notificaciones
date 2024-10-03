package com.microservicio.notificaciones.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservicio.notificaciones.domain.dto.NotificationsDto;
import com.microservicio.notificaciones.domain.service.NotificactionsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Notis")
public class NotificationsController {
    
    @Autowired
    private NotificactionsService notificationService;

    @PostMapping("/email")
    public ResponseEntity<String> enviarNotificacionEmail(@RequestBody NotificationsDto notificacionDto) {
        String respuesta = notificationService.sendEmailNotification(notificacionDto);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("/push")
    public ResponseEntity<String> enviarNotificacionPush(@RequestBody NotificationsDto notificacionDto) {
        String respuesta = notificationService.sendPushNotification(notificacionDto);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    

    
}
