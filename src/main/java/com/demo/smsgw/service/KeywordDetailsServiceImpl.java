package com.demo.smsgw.service;

import com.demo.smsgw.model.KeywordDetails;
import com.demo.smsgw.repository.KeywordDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeywordDetailsServiceImpl implements KeywordDetailsService {
    final private KeywordDetailsRepository keywordDetailsRepository;

    @Override
    public List<KeywordDetails> getAllKeywordDetails() {
        return keywordDetailsRepository.findAll();
    }
}
