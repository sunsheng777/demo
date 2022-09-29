package com.sunsheng.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunsheng.project.dao.BookMapper;
import com.sunsheng.project.entity.BookEntity;
import com.sunsheng.project.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author PC
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookEntity> implements BookService {
}
