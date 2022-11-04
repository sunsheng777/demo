package com.sunsheng.project.click.service;

import com.sunsheng.project.click.entity.ClickEntity;
import org.springframework.stereotype.Service;

/**
 * @author PC
 */
@Service
public interface ClickService{
    ClickEntity getTestById(Integer id);

    void saveData(ClickEntity click);
}