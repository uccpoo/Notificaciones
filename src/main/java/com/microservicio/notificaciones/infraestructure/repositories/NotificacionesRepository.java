package com.microservicio.notificaciones.infraestructure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservicio.notificaciones.infraestructure.crud_interface.NotificacionesCrudRepository;
import com.microservicio.notificaciones.infraestructure.entity.Notificaciones;
import com.microservicio.notificaciones.infraestructure.mapper.NotificationsMapper;
import com.microservicio.notificaciones.domain.dto.NotificationsDto;
import com.microservicio.notificaciones.domain.repository.NotificationsRepository;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public class NotificacionesRepository implements NotificationsRepository{

    @Autowired
    private NotificacionesCrudRepository notificacionesCrudRepository;

    @Autowired
    private NotificationsMapper mapper;

    @Transactional
    public String sendEmailNotification(NotificationsDto notificacionDto) {
        Notificaciones notificacion = mapper.toNotificacion(notificacionDto);

        notificacion.setFechaCreacion(LocalDateTime.now()); 
        notificacion.setEstado(0); 

        notificacionesCrudRepository.save(notificacion);
        
        System.out.println("Enviando correo a: " + notificacion.getDestinatario());
        System.out.println("Encabezado: " + notificacion.getEncabezado());
        System.out.println("Contenido: " + notificacion.getContenido());

        notificacion.setEstado(1); 
        notificacion.setFechaEntrega(LocalDateTime.now());
        notificacionesCrudRepository.save(notificacion); 

        return "{ \"message\": \"Correo enviado\" }";
    }

    @Transactional
    public String sendPushNotification(NotificationsDto notificacionDto) {
        Notificaciones notificacion = mapper.toNotificacion(notificacionDto);
        
        notificacion.setFechaCreacion(LocalDateTime.now()); 
        notificacion.setEstado(0); 

        notificacionesCrudRepository.save(notificacion);
        
        System.out.println("Enviando notificación push a: " + notificacion.getDestinatario());
        System.out.println("Título: " + notificacion.getEncabezado());
        System.out.println("Mensaje: " + notificacion.getContenido());

        notificacion.setEstado(1); 
        notificacion.setFechaEntrega(LocalDateTime.now());
        notificacionesCrudRepository.save(notificacion); 

        return "{ \"message\": \"Notificación enviada\" }"; 
    }
}
