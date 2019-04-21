package net.wanho.service.news.impl;

import net.wanho.mapper.NewsMapper;
import net.wanho.pojo.News;
import net.wanho.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceimpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Long deleteByPrimaryKey(Long tid) {
        return newsMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public Long insert(News record) {
        return newsMapper.insert(record);
    }

    @Override
    public Long insertSelective(News record) {
        return newsMapper.insertSelective(record);
    }

    @Override
    public News selectByPrimaryKey(Long tid) {
        return newsMapper.selectByPrimaryKey(tid);
    }

    @Override
    public Long updateByPrimaryKeySelective(News record) {
        return newsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Long updateByPrimaryKey(News record) {
        return newsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<News> selectnewsList() {
        return newsMapper.selectnewsList();
    }
}
