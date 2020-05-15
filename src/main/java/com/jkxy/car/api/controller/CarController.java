package com.jkxy.car.api.controller;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.CarRequest;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import com.jkxy.car.api.utils.StringUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {
        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public JSONResult findById(@PathVariable int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }

    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById(car);
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }
    /**
     * 模糊查询车辆信息
     *
     * @param car
     * @return
     */
    @PostMapping("findAllByKeyWord")
    public JSONResult findAllByKeyWord(CarRequest car) {
        if(StringUnit.isEmpty(String.valueOf(car.getStartPage()))||StringUnit.isEmpty(String.valueOf(car.getStartPage()))){
            return JSONResult.errorMsg("缺失必要参数");
        }
        if(car.getCarName()==null){
            car.setCarName("");
        }
        if(car.getCarSeries()==null){
            car.setCarSeries("");
        }
        long row = carService.countAllByKeyWord(car);
        Map map = new HashMap();
        map.put("total",row);
        List<Car> list = new ArrayList<Car>();
        if(row>0){
            list = carService.findAllByKeyWord(car);
        }
        map.put("list",list);
       return JSONResult.ok(map);
    }
}
