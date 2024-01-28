package com.muke.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 途径车站查询
 *
 * @author tangcj
 * @date 2024/01/28 10:40
 **/
public class DailyTrainStationQueryAllReq {

    /**
     * 日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "【日期】不能为空")
    private Date date;

    /**
     * 车次编号
     */
    @NotBlank(message = "【车次编号】不能为空")
    private String trainCode;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DailyTrainStationQueryReq{");
        sb.append("date=").append(date);
        sb.append(", trainCode='").append(trainCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
