package com.example.finalproject.service;

import com.example.finalproject.domain.FileUploadResponse;
import com.example.finalproject.domain.Lost;
import com.example.finalproject.mapper.LostMapper;
import com.example.finalproject.upload.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class LostServiceImpl implements LostService {
    @Autowired
    private LostMapper lostMapper;

    @Override
    public int save(Lost lost) {
        System.out.println("35135131351");
        System.out.println(lost);
        System.out.println("dfadfhafhahf");
        return lostMapper.save(lost);
    }

    @Override
    public List<Lost> findAll() {
        return lostMapper.findAll();
    }

    @Override
    public int update(Lost lost) {
        return lostMapper.update(lost);
    }

    @Override
    public int delete(int id) {
        return lostMapper.delete(id);
    }

    @Override
    public Lost findById(int id) {
        return lostMapper.findById(id);
    }
}
