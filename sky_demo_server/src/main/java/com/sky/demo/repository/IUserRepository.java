package com.sky.demo.repository;

import com.sky.demo.entity.UserSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends ElasticsearchRepository<UserSearch, Long> {

    List<UserSearch> findAllByTitleLike(String word);
}
