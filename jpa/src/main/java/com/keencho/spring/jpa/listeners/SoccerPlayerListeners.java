package com.keencho.spring.jpa.listeners;

import com.keencho.spring.jpa.model.SoccerPlayer;
import com.keencho.spring.jpa.repository.SoccerPlayerRepository;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;

@Component
public class SoccerPlayerListeners implements SimpleEventListeners {

    private static SoccerPlayerRepository soccerPlayerRepository;

    @PrePersist
    public void prePersist(SoccerPlayer soccerPlayer) {
        System.out.println("size: " + soccerPlayerRepository.findAll().size());
    }
}
