package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.CarRecord;

import java.util.List;


public interface CarRecordService {

    List<CarRecord> findAll();

    CarRecord findById(int id);

    boolean updateById(CarRecord car);
    boolean insertBuyRecord(CarRecord car);
}
