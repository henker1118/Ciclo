package com.thomas.gimnasio.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thomas.gimnasio.dao.MessageRepository;
import com.thomas.gimnasio.entities.Category;
import com.thomas.gimnasio.entities.Message;

@Service
public class MessageService {
	@Autowired
	MessageRepository messageRepository;

	public List<Message> getAll() {
		return (List<Message>) messageRepository.getAll();
	};

	public Optional<Message> getMessage(int id) {
		return messageRepository.getMessage(id);
	};

	public Message save(Message message) {
		if (message.getIdMessage() == null) {
			return messageRepository.save(message);
		} else {
			Optional<Message> co = messageRepository.getMessage(message.getIdMessage());
			if (co.isEmpty()) {
				return messageRepository.save(message);
			} else {
				return message;
			}
		}
	}

	public Message update(Message message) {
        if (message.getIdMessage()!= null) {
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText()!= null) {
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();

            } else {
                return message;
            }
        } else {
            return message;
        }
    }

	public boolean deleteMessage(int id) {
		Boolean result = getMessage(id).map(message -> {
			messageRepository.delete(message);
			return true;
		}).orElse(false);
		return result;
	}
}
