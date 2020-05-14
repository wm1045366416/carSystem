package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarRecordDao;
import com.jkxy.car.api.pojo.CarRecord;
import com.jkxy.car.api.service.CarRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("carRecordService")
public class CarRecordServiceImpl implements CarRecordService {
    @Autowired
    private CarRecordDao carRecordDao;

    @Override
    public List<CarRecord> findAll() {
        return carRecordDao.findAll();
    }

    @Override
    public CarRecord findById(int id) {
        return carRecordDao.findById(id);
    }

    @Override
    public boolean updateById(CarRecord car) {
        int row = carRecordDao.updateById(car);
        return row>0?true:false;
    }
    @Override
    public boolean insertBuyRecord(CarRecord car) {
        int row = carRecordDao.insertBuyRecord(car);
        return row>0?true:false;
    }

}
