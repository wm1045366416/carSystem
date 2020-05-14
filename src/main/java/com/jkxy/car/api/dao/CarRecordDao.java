package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.CarRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CarRecordDao {
    @Select("select * from carStock")
    List<CarRecord> findAll();

    @Select("select * from carStock where id = #{id}")
    CarRecord findById(int id);

    @Update("update carStock set stockAccount=#{stockAccount},updatedTime=now() where id = #{id}")
    int updateById(CarRecord car);

    @Insert("insert into carRecord(userName,carId,account,createdTime) values(#{userName},#{id},#{amount},now())")
    int insertBuyRecord(CarRecord car);

}
