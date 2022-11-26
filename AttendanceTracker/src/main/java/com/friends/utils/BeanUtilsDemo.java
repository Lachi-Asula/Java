package com.friends.utils;

import com.friends.dto.Batch_Info_Dto;
import com.friends.dto.Emp_Info_Dto;
import com.friends.dto.Staff_Info_Dto;
import com.friends.model.Batch_Info_Entity;
import com.friends.model.Emp_Info_Entity;
import com.friends.model.Staff_Info_Entity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class BeanUtilsDemo {

    public static Logger logger = Logger.getLogger(BeanUtilsDemo.class.getName());

    public Batch_Info_Dto getBatchInfoDto(Batch_Info_Entity batchInfoEntity){
        Batch_Info_Dto batchInfoDto = new Batch_Info_Dto();
        try{
            BeanUtils.copyProperties(batchInfoEntity, batchInfoDto);
        }catch (Exception e){
            logger.info("Error occurred in BeanUtilsDemo while coping the properties : " + e);
        }

        return batchInfoDto;
    }

    public Batch_Info_Entity getBatchInfoEntity(Batch_Info_Dto batchInfoDto){
        Batch_Info_Entity batchInfoEntity = new Batch_Info_Entity();
        try{
            BeanUtils.copyProperties(batchInfoDto, batchInfoEntity);
        }catch (Exception e){
            logger.info("Error occurred in BeanUtilsDemo while coping the properties : " + e);
        }

        return batchInfoEntity;
    }

    public Emp_Info_Dto getEmpInfoDto(Emp_Info_Entity empInfoEntity){
        Emp_Info_Dto empInfoDto = new Emp_Info_Dto();
        try{
            BeanUtils.copyProperties(empInfoEntity, empInfoDto);
        }catch (Exception e){
            logger.info("Error occurred in BeanUtilsDemo while coping the properties : " + e);
        }

        return empInfoDto;
    }

    public Emp_Info_Entity getEmpInfoEntity(Emp_Info_Dto empInfoDto){
        Emp_Info_Entity empInfoEntity = new Emp_Info_Entity();
        try{
            BeanUtils.copyProperties(empInfoDto, empInfoEntity);
        }catch (Exception e){
            logger.info("Error occurred in BeanUtilsDemo while coping the properties : " + e);
        }

        return empInfoEntity;
    }

    public Staff_Info_Dto getStaffInfoDto(Staff_Info_Entity staffInfoEntity){
        Staff_Info_Dto staffInfoDto = new Staff_Info_Dto();
        try{
            BeanUtils.copyProperties(staffInfoEntity, staffInfoDto);
            List<Batch_Info_Dto> batchInfoDto = new ArrayList<>();
            for(Batch_Info_Entity batchInfoEntity : staffInfoEntity.getFld_Staff_Id()){
                batchInfoDto.add(getBatchInfoDto(batchInfoEntity));
            }
            staffInfoDto.setFld_Staff_Id(batchInfoDto);
        }catch (Exception e){
            logger.info("Error occurred in BeanUtilsDemo while coping the properties : " + e);
        }

        return staffInfoDto;
    }

    public Staff_Info_Entity getStaffInfoEntity(Staff_Info_Dto staffInfoDto){
        Staff_Info_Entity staffInfoEntity = new Staff_Info_Entity();
        try{
            BeanUtils.copyProperties(staffInfoDto, staffInfoEntity);
            List<Batch_Info_Entity> batchInfoEntities = new ArrayList<>();
            for(Batch_Info_Dto batchInfoDto : staffInfoDto.getFld_Staff_Id()){
                batchInfoEntities.add(getBatchInfoEntity(batchInfoDto));
            }
            staffInfoEntity.setFld_Staff_Id(batchInfoEntities);
        }catch (Exception e){
            logger.info("Error occurred in BeanUtilsDemo while coping the properties : " + e);
        }

        return staffInfoEntity;
    }
}
