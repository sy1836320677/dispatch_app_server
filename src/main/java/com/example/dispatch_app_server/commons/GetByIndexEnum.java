package com.example.dispatch_app_server.commons;

import java.util.EnumSet;

public interface GetByIndexEnum {
    int getIndex();
    String getName();

    /**
     * 得到enmu
     *
     * @param index 指数
     * @param clazz clazz
     * @return {@link E}
     */
    static <E extends Enum<E> & GetByIndexEnum> E getEnmu(Integer index, Class<E> clazz) {
        EnumSet<E> all = EnumSet.allOf(clazz);
        return all.stream().filter(e -> e.getIndex() == index).findFirst().orElse(null);
    }

    /**
     * 得到enmu
     *
     * @param name  的名字
     * @param clazz clazz
     * @return {@link E}
     */
    static <E extends Enum<E> & GetByIndexEnum> E getEnmu(String name, Class<E> clazz) {
        EnumSet<E> all = EnumSet.allOf(clazz);
        return all.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
