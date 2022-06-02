package com.github.kmusial1988.teamManagerBeta.parent.service.impl;

import com.github.kmusial1988.teamManagerBeta.parent.exception.ParentIsAlreadyExistsException;
import com.github.kmusial1988.teamManagerBeta.parent.exception.ParentIsNotFoundException;
import com.github.kmusial1988.teamManagerBeta.parent.mapper.ParentMapper;
import com.github.kmusial1988.teamManagerBeta.parent.model.Parent;
import com.github.kmusial1988.teamManagerBeta.parent.model.ParentArchives;
import com.github.kmusial1988.teamManagerBeta.parent.model.ParentRequest;
import com.github.kmusial1988.teamManagerBeta.parent.model.ParentResponse;
import com.github.kmusial1988.teamManagerBeta.parent.repository.ParentArchivesRepository;
import com.github.kmusial1988.teamManagerBeta.parent.repository.ParentRepository;
import com.github.kmusial1988.teamManagerBeta.parent.service.ParentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ParentServiceImpl implements ParentService {


   private final ParentRepository parentRepository;
   private final ParentMapper parentMapper;
   private final ParentArchivesRepository parentArchivesRepository;

    public ParentServiceImpl(ParentRepository parentRepository, ParentMapper parentMapper, ParentArchivesRepository parentArchivesRepository) {
        this.parentRepository = parentRepository;
        this.parentMapper = parentMapper;
        this.parentArchivesRepository = parentArchivesRepository;
    }


    @Override
    public List<ParentResponse> listParent() {
        log.info("List of parent downloaded");
        return parentRepository.findAll().stream()
                .map(parentMapper::mapFromEntityToResponse).collect(Collectors.toList());
    }

    @Override
    public ParentResponse getParentById(Long id) {
        Parent parent = parentRepository.findById(id).orElseThrow(() ->{
            throw new ParentIsNotFoundException();
        });
        log.info("Downloading the parent: {}", id);
        return parentMapper.mapFromEntityToResponse(parent);
    }

    @Override
    public ParentResponse createParent(ParentRequest parentRequest) {
        Parent parent = parentMapper.mapFromRequestToEntity(parentRequest);
        parentRepository.findByLogin(parent.getLogin()).ifPresent(pa -> {
            throw new ParentIsAlreadyExistsException(parent.getLogin());
        });
        log.info("Saving new parent: {}", parent.getLogin());
        return parentMapper.mapFromEntityToResponse(parentRepository.save(parent));
    }

    @Override
    public ParentResponse updateParent(ParentRequest parentRequest) {
        Parent parent = parentMapper.mapFromRequestToEntity(parentRequest);
        System.out.println(" pierwszy    "+parentRequest);
        parentRepository.findById(parentRequest.getId()).orElseThrow(() ->{
            throw new ParentIsNotFoundException();
        });

        parentRepository.findByIdNotAndLogin(parentRequest.getId(), parentRequest.getLogin()).ifPresent(pa -> {
            throw new ParentIsAlreadyExistsException(parent.getLogin());
        });
        log.info("Updating parent: {}", parent.getLogin());

        System.out.println(" ostatni "+parentMapper.mapFromEntityToResponse(parent));
        return parentMapper.mapFromEntityToResponse(parentRepository.save(parent));
    }

    @Override
    public void deleteParent(Long id) {
        Parent parent = parentRepository.findById(id).orElseThrow(() ->{
            throw new ParentIsNotFoundException();
        });

        parentArchivesRepository.save(parentMapper.mapFromEntityToArchive(parent));

        log.info("Deleting parent by ID: {}", id);
        parentRepository.delete(parent);
    }

    @Override
    public List<ParentArchives> listParentArchives() {
        log.info("List of PlayerArchives downloaded");
        return parentArchivesRepository.findAll();
    }
}
