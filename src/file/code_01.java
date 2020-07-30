package file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 找出所有以txt结尾的文件
 */
public class code_01 {
    File f = new File(".");
    File[] files = f.listFiles(new FilenameFilter() {
        //过滤器用来筛选
        @Override
        public boolean accept(File dir, String name) {
            if(name.endsWith(".txt")){
                return true;
            }
            return false;
        }
    });
}
