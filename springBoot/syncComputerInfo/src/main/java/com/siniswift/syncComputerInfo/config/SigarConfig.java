package com.siniswift.syncComputerInfo.config;

import java.io.File;

import org.hyperic.sigar.Sigar;
import org.springframework.util.ResourceUtils;

/**
 * @ClassName:  SigarConfig   
 * @author: WangYong 
 * @date:   2018年7月17日
 * @Description:sigar插件配置类
 */
public class SigarConfig {
	
	public final static Sigar sigar = initSigar();
    private static Sigar initSigar() {
        try {
            //此处只为得到依赖库文件的目录，可根据实际项目自定义
            File classPath = ResourceUtils.getFile("classpath:static");
            String path = System.getProperty("java.library.path");
            String sigarLibPath = classPath.getCanonicalPath();
            //为防止java.library.path重复加，此处判断了一下
            if (!path.contains(sigarLibPath)) {
                if (isOSWin()) {
                    path += ";" + sigarLibPath;
                } else {
                    path += ":" + sigarLibPath;
                }
                System.setProperty("java.library.path", path);
            }
            return new Sigar();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isOSWin(){//OS 版本判断
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("win") >= 0) {
            return true;
        } else return false;
    }
	
}
