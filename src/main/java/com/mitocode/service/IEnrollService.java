package com.mitocode.service;

import com.mitocode.model.Enroll;

import java.util.List;
import java.util.Map;

public interface IEnrollService extends ICRUD<Enroll, Integer> {
    Map<String, List<String>> getStudentsEnrolledByCourse();
}
