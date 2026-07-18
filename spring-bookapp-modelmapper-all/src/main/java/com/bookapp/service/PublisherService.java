package com.bookapp.service;

import com.bookapp.dto.PublisherRequestDTO;

public interface PublisherService {

    void addPublisher(PublisherRequestDTO requestDTO);

    void updatePublisher(PublisherRequestDTO requestDTO);

    void deletePublisher(int publisherId);

    PublisherRequestDTO getById(int publisherId);


}
