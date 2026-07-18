package com.bookapp.service.impl;

import com.bookapp.dto.PublisherRequestDTO;
import com.bookapp.model.Publisher;
import com.bookapp.repository.PublisherRepository;
import com.bookapp.service.PublisherService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Transactional
    public PublisherRequestDTO getById(int publisherId) {

        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        return modelMapper.map(publisher, PublisherRequestDTO.class);
    }

    @Override
    @Transactional
    public List<PublisherRequestDTO> getAllPublishers() {
        List<Publisher> requestDTOList = publisherRepository.findAll();
        return requestDTOList.stream()
                .map(publisher -> modelMapper
                                .map(publisher, PublisherRequestDTO.class))
                .toList();
    }
}
