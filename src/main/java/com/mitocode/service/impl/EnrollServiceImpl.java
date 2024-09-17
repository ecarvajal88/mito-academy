package com.mitocode.service.impl;

import com.mitocode.model.Enroll;
import com.mitocode.model.EnrollDetail;
import com.mitocode.repo.IEnrollRepo;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.service.IEnrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EnrollServiceImpl extends CRUDImpl<Enroll, Integer> implements IEnrollService {

    private final IEnrollRepo repo;

    @Override
    protected IGenericRepo<Enroll, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<String>> getStudentsEnrolledByCourse() {
        Stream<Enroll> enrollStream = repo.findAll().stream();
        Stream<List<EnrollDetail>> listStream = enrollStream.map(Enroll::getDetails);
        Stream<EnrollDetail> steramDetail = listStream.flatMap(Collection::stream);
        return steramDetail.collect(Collectors.groupingBy(d -> d.getCourse().getName(),
                Collectors.mapping(d -> d.getEnroll().getStudent().getFirstName() + " " + d.getEnroll().getStudent().getLastName(), Collectors.toList())));
    }
}
