package com.lt.dsandalg.tree.binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 英雄实体类
 * @author: ~Teng~
 * @date: 2022/9/4 17:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {
    /**
     * id
     */
    private int id;

    /**
     * 姓名
     */
    private String name;
}
