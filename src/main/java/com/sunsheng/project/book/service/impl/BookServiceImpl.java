package com.sunsheng.project.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunsheng.project.book.dao.BookMapper;
import com.sunsheng.project.book.entity.BookEntity;
import com.sunsheng.project.book.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author PC
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookEntity> implements BookService {
}
