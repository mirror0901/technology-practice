/**
 * Copyright (C), 2019-2022, 海安秩明网络科技工作室
 * FileName: HeapOOM
 * Author:   HYJ
 * Date:     2019/3/31 0:07
 * Description:
 * History:
 * <author>          <微信号>          <version>          <工作室官网>
 * mirror_huang     wwwmirror95top      1.0.0            http://www.mirror95.top
 * 海安秩明网络科技工作室致力于企业网站设计、制作、源码出售、SEO推广，爬虫，微信公众号、小程序开发。
 * 希望为中小微型企业、个体户拓宽销售渠道，紧追互联网+潮流，实现合作共赢。
 * 秩明网络愿与您合作，共创美好生活。
 */
package char02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mirror_huang
 * @date: 2019/3/31 00:07
 * @qq: 1755496180
 * @description:
 * java堆内存溢出异常测试
 * VM Args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> oomObjectList = new ArrayList<>();
        while (true){
            oomObjectList.add(new OOMObject());
        }
    }

}
