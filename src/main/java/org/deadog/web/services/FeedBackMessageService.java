package org.deadog.web.services;

import org.deadog.web.models.FeedBackMessage;
import org.springframework.stereotype.Service;
import org.deadog.web.repositories.FeedBackMessageRepository;

@Service
public class FeedBackMessageService {
    private final FeedBackMessageRepository feedBackMessageRepository;


    public FeedBackMessageService(FeedBackMessageRepository feedBackMessageRepository) {
        this.feedBackMessageRepository = feedBackMessageRepository;
    }

    public void create(FeedBackMessage feedBackMessage) {
        feedBackMessageRepository.save(feedBackMessage);
    }
}
