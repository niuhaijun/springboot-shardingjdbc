package com.niu.uidgenerator.service;

/**
 * @Author: niuhaijun
 * @Date: 2019-11-05 00:30
 * @Version 1.0
 */
public interface UidGenService {

  long getUID();

  String parseUID(long uid);
}
