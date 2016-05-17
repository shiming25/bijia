package com.sou.common.util;

import java.util.LinkedList;

/**
 * 方法返回值工具类，在前面的返回值优先返回，可以实现方法返回值与程序业务逻辑的解耦，可以减少代码的分支数。<br>
 * 
 * @author 
 */
public class MethodResultUtil<T> {

    private LinkedList<T> resultList;

    private LinkedList<T> preResultList;

    public MethodResultUtil(T[] possibleValues) {
        super();

        resultList = new LinkedList<T>();
        preResultList = new LinkedList<T>();

        for (T t : possibleValues) {
            resultList.add(t);
        }
    }

    public void registerFirst(T value) {
        resultList.addFirst(value);
    }

    public void registerLast(T value) {
        resultList.addLast(value);
    }

    public T unregisterAt(int index) {
        return resultList.remove(index);
    }

    public boolean unregisterValue(T value) {
        return resultList.remove(value);
    }

    public void preRegisterFirst(T value) {
        preResultList.addLast(value);
    }

    public void preRegisterExecute() {
        for (T t : preResultList) {
            resultList.addFirst(t);
        }
    }

    public T getResult() {
        return resultList.getFirst();
    }
}
