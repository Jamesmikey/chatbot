package tz.ac.udsm.chatBot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.chatBot.models.Message;
import tz.ac.udsm.chatBot.services.MessageService;

import javax.naming.OperationNotSupportedException;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {


    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAll(){
        return messageService.getAll();
    }


    @PostMapping
    public String add(@RequestBody Message message){

        messageService.add(message);

        return "Message ameongezwa";
    }

    @PutMapping("/{id}")
    public String edit( @PathVariable Long id,@RequestBody Message newMessage) throws OperationNotSupportedException {

        messageService.edit(id,newMessage);

        return "Message with ID "+id+" edited";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Long id) throws OperationNotSupportedException {

        messageService.deleteById(id);

        return id+" Message deleted ";
    }
}
