package com.github.kmusial1988.teamManagerBeta.parent.service;

import com.github.kmusial1988.teamManagerBeta.parent.model.ParentArchives;
import com.github.kmusial1988.teamManagerBeta.parent.model.ParentRequest;
import com.github.kmusial1988.teamManagerBeta.parent.model.ParentResponse;

import java.util.List;

public interface ParentService {

    List<ParentResponse> listParent();

    ParentResponse getParentById(Long id);

    ParentResponse createParent(ParentRequest parentRequest);

    ParentResponse updateParent(ParentRequest parentRequest);

    void deleteParent(Long id);

    List<ParentArchives> listParentArchives();
}
