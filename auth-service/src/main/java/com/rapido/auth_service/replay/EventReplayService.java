package com.rapido.auth_service.replay;

import org.springframework.stereotype.Service;

@Service
public class EventReplayService {

    public void replayEvent(String eventId) {

        System.out.println("Replaying Event: " + eventId);

        System.out.println("Event Replay Completed");
    }
}