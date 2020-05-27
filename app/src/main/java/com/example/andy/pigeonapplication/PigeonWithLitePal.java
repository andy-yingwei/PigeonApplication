package com.example.andy.pigeonapplication;

import android.util.Log;

import org.litepal.LitePal;
import org.litepal.crud.callback.FindMultiCallback;
import org.litepal.crud.callback.SaveCallback;

import java.util.List;

public class PigeonWithLitePal {

    PigeonBean pigeonBean = new PigeonBean();

    public void save(String country,
                     String year,
                     String area,
                     String number,
                     String sex,
                     String eye,
                     String color,
                     String birth,
                     String father,
                     String mather,
                     String state,
                     String notes){
        pigeonBean.setCountry(country);
        pigeonBean.setYear(year);
        pigeonBean.setArea(area);
        pigeonBean.setNumber(number);
        pigeonBean.setSex(sex);
        pigeonBean.setEye(eye);
        pigeonBean.setColor(color);
        pigeonBean.setBirth(birth);
        pigeonBean.setFather(father);
        pigeonBean.setMather(mather);
        pigeonBean.setState(state);
        pigeonBean.setNotes(notes);
        //pigeonBean.save();
        pigeonBean.saveThrows();
        if (pigeonBean.save()) {
            Log.d("MyLog", "save添加记录成功！");
        } else {
            Log.d("MyLog", "save添加记录失败！");
        }

    }

    public void update(String country,
                       String year,
                       String area,
                       String number,
                       String sex,
                       String eye,
                       String color,
                       String birth,
                       String father,
                       String mather,
                       String state,
                       String notes,
                       String conditions){
        pigeonBean.setCountry(country);
        pigeonBean.setYear(year);
        pigeonBean.setArea(area);
        pigeonBean.setNumber(number);
        pigeonBean.setSex(sex);
        pigeonBean.setEye(eye);
        pigeonBean.setColor(color);
        pigeonBean.setBirth(birth);
        pigeonBean.setFather(father);
        pigeonBean.setMather(mather);
        pigeonBean.setState(state);
        pigeonBean.setNotes(notes);
        int count = pigeonBean.updateAll(conditions);
        if (count > 0) {
            Log.d("MyLog", "updateAll成功更新" + count + "条记录");
        } else {
            Log.d("MyLog", "updateAll没有找到符合条件的记录！");
        }

    }

    public void delete(String conditions){
        int count = LitePal.deleteAll(PigeonBean.class, conditions);
        if (count > 0){
            Log.d("MyLog", "deleteAll删除了" + count + "条记录");
        }else{
            Log.d("MyLog", "deleteAll没有找到符合条件的记录！");
        }
    }

    public void find(String conditions){
        //List<PigeonBean> allPigeon = LitePal.findAll(PigeonBean.class);  //查询全部记录
        List<PigeonBean> allPigeon = LitePal.where(conditions).find(PigeonBean.class);
        if(allPigeon.size() > 0){
            Log.d("MyLog", "where查询到" + allPigeon.size() + "条记录");
            for (int i = 0; i < allPigeon.size(); i++) {
                Log.d("MyLog", allPigeon.get(i).getCountry() + " "
                                       + allPigeon.get(i).getYear() + " "
                                       + allPigeon.get(i).getArea() + " "
                                       + allPigeon.get(i).getNumber() + " "
                                       + allPigeon.get(i).getSex() + " "
                                       + allPigeon.get(i).getEye() + " "
                                       + allPigeon.get(i).getColor() + " "
                                       + allPigeon.get(i).getBirth() + " "
                                       + allPigeon.get(i).getFather() + " "
                                       + allPigeon.get(i).getMather() + " "
                                       + allPigeon.get(i).getState() + " "
                                       + allPigeon.get(i).getNotes() + " ");
            }
        }else {
            Log.d("MyLog", "where没有找到符合条件的记录！");
        }
    }

    public void findAll() {
        List<PigeonBean> allPigeon = LitePal.findAll(PigeonBean.class);
        if (allPigeon.size() > 0) {
            Log.d("MyLog", "findAll查询到" + allPigeon.size() + "条记录");
            for (int i = 0; i < allPigeon.size(); i++) {
                Log.d("MyLog", allPigeon.get(i).getCountry() + " "
                        + allPigeon.get(i).getYear() + " "
                        + allPigeon.get(i).getArea() + " "
                        + allPigeon.get(i).getNumber() + " "
                        + allPigeon.get(i).getSex() + " "
                        + allPigeon.get(i).getEye() + " "
                        + allPigeon.get(i).getColor() + " "
                        + allPigeon.get(i).getBirth() + " "
                        + allPigeon.get(i).getFather() + " "
                        + allPigeon.get(i).getMather() + " "
                        + allPigeon.get(i).getState() + " "
                        + allPigeon.get(i).getNotes() + " ");
            }
        } else {
            Log.d("MyLog", "findAll没有找到符合条件的记录！");
        }

    }

    //异步查询
    public void findAllAsync(){
        LitePal.findAllAsync(PigeonBean.class).listen(new FindMultiCallback<PigeonBean>() {
            @Override
            public void onFinish(List<PigeonBean> allPigeon) {
                if (allPigeon.size() > 0) {
                    Log.d("MyLog", "findAllAsync查询到" + allPigeon.size() + "条记录");
                    for (int i = 0; i < allPigeon.size(); i++) {
                        Log.d("MyLog", allPigeon.get(i).getCountry() + " "
                                + allPigeon.get(i).getYear() + " "
                                + allPigeon.get(i).getArea() + " "
                                + allPigeon.get(i).getNumber() + " "
                                + allPigeon.get(i).getSex() + " "
                                + allPigeon.get(i).getEye() + " "
                                + allPigeon.get(i).getColor() + " "
                                + allPigeon.get(i).getBirth() + " "
                                + allPigeon.get(i).getFather() + " "
                                + allPigeon.get(i).getMather() + " "
                                + allPigeon.get(i).getState() + " "
                                + allPigeon.get(i).getNotes() + " ");
                    }
                } else {
                    Log.d("MyLog", "findAllAsync没有找到符合条件的记录！");
                }
            }
        });
    }

    //异步保存
    public void saveAsync(String country,
                          String year,
                          String area,
                          String number,
                          String sex,
                          String eye,
                          String color,
                          String birth,
                          String father,
                          String mather,
                          String state,
                          String notes){
        pigeonBean.setCountry(country);
        pigeonBean.setYear(year);
        pigeonBean.setArea(area);
        pigeonBean.setNumber(number);
        pigeonBean.setSex(sex);
        pigeonBean.setEye(eye);
        pigeonBean.setColor(color);
        pigeonBean.setBirth(birth);
        pigeonBean.setFather(father);
        pigeonBean.setMather(mather);
        pigeonBean.setState(state);
        pigeonBean.setNotes(notes);
        pigeonBean.saveAsync().listen(new SaveCallback() {
            @Override
            public void onFinish(boolean success) {
                if (success){
                    Log.d("MyLog", "saveAsync添加记录成功");
                }else{
                    Log.d("MyLog", "saveAsync添加记录失败！");
                }
            }
        });
    }
}

