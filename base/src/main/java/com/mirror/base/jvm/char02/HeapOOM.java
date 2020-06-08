/**
 * FileName: HeapOOM
 * Author:   HYJ
 * Date:     2019/3/31 0:07
 * Description:
 * History:
 */
package com.mirror.base.jvm.char02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mirror_huang
 * @date: 2019/3/31 00:07
 * @qq: 1755496180
 * @description: java堆内存溢出异常测试
 * VM Args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    public static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> oomObjectList = new ArrayList();
        while (true) {
            oomObjectList.add(new OOMObject());
        }
    }

}
