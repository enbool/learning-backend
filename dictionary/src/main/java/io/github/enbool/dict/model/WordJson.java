package io.github.enbool.dict.model;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: wumin2
 * @Date: 2023/4/4 19:33
 */
@Data
public class WordJson {
    private String name;

    private List<String> trans;

    private String usphone;

    private String ukphone;

}
