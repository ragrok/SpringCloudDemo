package cn.com.github.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderStep {

    private long orderId;
    private String desc;
}
