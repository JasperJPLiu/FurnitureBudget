package com.edu.zucc.service;

import com.edu.zucc.mapper.MessageboardMapper;
import com.edu.zucc.model.EButil;
import com.edu.zucc.model.Messageboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class MessageboardService {
    private MessageboardMapper messageboardMapper;

    @Autowired
    public MessageboardService(MessageboardMapper messageboardMapper) {
        this.messageboardMapper = messageboardMapper;
    }

    /*根据标题查*/
    public List<Messageboard> findByTitle(String title) {
        Messageboard messageboard = new Messageboard();
        messageboard.setTitle(title);
        return messageboardMapper.findByTitle(messageboard);
    }

    /*根据发布用户查*/
    public List<Messageboard> findByUser(int user) {
        Messageboard messageboard = new Messageboard();
        messageboard.setUser(user);
        return messageboardMapper.findByUser(messageboard);
    }

    public Messageboard findById(int id) {
        Messageboard messageboard = new Messageboard();
        messageboard.setId(id);
        return messageboardMapper.findByKey(messageboard);
    }

    public List<Messageboard> findAll() {
        return messageboardMapper.findAll();
    }

    public EButil add(Messageboard messageboard) {
        EButil result = new EButil();
        messageboardMapper.add(messageboard);
        result.Success();
        return result;
    }

    public EButil delete(Messageboard messageboard) {
        EButil result = new EButil();
        if (findById(messageboard.getId()) == null) {
            result.Error("Messageboard is not existed");
            return result;
        }
        messageboardMapper.delete(messageboard);
        result.Success();
        return result;
    }

    public EButil update(Messageboard messageboard) {
        EButil result = new EButil();
        if (findById(messageboard.getId()) == null) {
            result.Error("Messageboard is not existed");
            return result;
        }
        messageboardMapper.update(messageboard);
        result.Success();
        return result;
    }

}
