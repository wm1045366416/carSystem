package com.jkxy.car.api.controller;

import com.jkxy.car.api.pojo.CarRecord;
import com.jkxy.car.api.service.CarRecordService;
import com.jkxy.car.api.utils.JSONResult;
import com.jkxy.car.api.utils.StringUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("carBuy")
public class CarBuyController {
    @Autowired
    private CarRecordService carService;


    /**
     * 通过id购买车辆
     *
     * @return
     */
    @PostMapping("buyCarById")
    public JSONResult buyCarById(CarRecord car) {
        if(StringUnit.isEmpty(String.valueOf(car.getId()))||StringUnit.isEmpty(car.getUserName())
                ||StringUnit.isEmpty(String.valueOf(car.getAmount()))){
            return JSONResult.errorMsg("缺失必要参数");
        }
        if(car.getAmount()<=0){
            return JSONResult.errorMsg("amount参数错误");
        }
        CarRecord carInfo = carService.findById(car.getId());
        if(carInfo!=null){
            int count = carInfo.getStockAccount()-car.getAmount();
            if(count<0){
                return JSONResult.errorMsg("库存数量不足:当前库存为:"+carInfo.getStockAccount());
            }else{
                car.setStockAccount(count);
                boolean b = carService.updateById(car);
                if(b){
                    carService.insertBuyRecord(car);
                }else{
                    return JSONResult.errorMsg("购车失败!");
                }
            }
        }else{
            return JSONResult.errorMsg("该车辆不存在！");
        }
        return JSONResult.ok();
    }



}
