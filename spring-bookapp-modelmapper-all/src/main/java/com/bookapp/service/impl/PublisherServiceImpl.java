package com.bookapp.service.impl;

import com.bookapp.dto.PublisherRequestDTO;
import com.bookapp.model.Publisher;
import com.bookapp.repository.PublisherRepository;
import com.bookapp.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addPublisher(PublisherRequestDTO requestDTO) {
        Publisher publisher = modelMapper.map(requestDTO, Publisher.class);
        publisherRepository.save(publisher);
    }

    @Override
    public void updatePublisher(PublisherRequestDTO requestDTO) {
        Publisher publisher = modelMapper.map(requestDTO, Publisher.class);
        publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisher(int publisherId) {
        publisherRepository.deleteById(publisherId);
    }

    @Override
    public PublisherRequestDTO getById(int publisherId) {
        Publisher publisher = publisherRepository.getById(publisherId);
        return modelMapper.map(publisher, PublisherRequestDTO.class);
    }
}
