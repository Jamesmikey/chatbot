package tz.ac.udsm.chatBot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tz.ac.udsm.chatBot.models.Message;
import tz.ac.udsm.chatBot.repository.MessageRepository;

import javax.naming.OperationNotSupportedException;
import java.util.List;

@Service
public class MessageService {


    @Autowired
    private MessageRepository messageRepository;


    public List<Message> getAll(){

        List<Message> messages=messageRepository.findAll();

//        for (Message message:messages){
//
//            message.getUser().setMessages(null);
//            message.getUser().setAddress(null);
//
//        }

        return messages;
    }


    public void add(Message newMessage){

        messageRepository.save(newMessage);
    }


    public void edit(Long id,Message newMessage) throws OperationNotSupportedException {

            Message existMessage= messageRepository.findById(id).orElseThrow(() -> new OperationNotSupportedException("Message not exist"));

            existMessage.setBody(newMessage.getBody());

            existMessage.setSubject(newMessage.getSubject());

            messageRepository.save(existMessage);



//        for(Message message:messages){
//            if(message.getId().equals(id)){
//                message.setName(newMessage.getName());
//                message.setEmail(newMessage.getEmail());
//                break;
//            }
//        }

    }

    public void deleteById(Long id) throws OperationNotSupportedException {

        Message existMessage= messageRepository.findById(id).orElseThrow(() -> new OperationNotSupportedException("Message not exist"));

//        messageRepository.deleteById(id);
        messageRepository.delete(existMessage);



//        for(Message message:messages){
//            if(message.getId().equals(id)){
//                messages.remove(message);
//                break;
//            }
//        }
    }

}
