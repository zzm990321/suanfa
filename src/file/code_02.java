package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class code_02 {
    /**
     * 计算所有文件大小
     * @param directory
     * @return
     */
    public static long sizeOfDirectory(final File directory){
        long size = 0;
        //如果是文件
        if(directory.isFile()){
            return directory.length();
        }else{
            for(File file : directory.listFiles()){
                if(file.isFile()){
                    size += file.length();
                }else {
                    //递归
                    size += sizeOfDirectory(file);
                }
            }
        }
        return size;
    }

    /**
     *查出给定文件名的所有文件
     * @param directory
     * @param fileName
     * @return
     */
    public static Collection<File> findFile(final File directory,final String fileName){
        List<File> files = new ArrayList<>();
        for(File f : directory.listFiles()){
            if(f.isFile() && f.getName().equals(fileName)){
                files.add(f);
            }else if(f.isDirectory()){
                //若果是文件夹递归调用
                files.addAll(findFile(f,fileName));
            }
        }
        return files;
    }

    /**
     * 删除非空目录
     * @param file
     * @throws IOException
     */
    public static void deleteRecursively(final File file) throws IOException {
        if(file.isFile()){
            if(!file.delete()){
                throw new IOException("Failed to delete" + file.getCanonicalPath());
            }
        }else if(file.isDirectory()){
            for(File child : file.listFiles()){
                deleteRecursively(child);
            }
            if(!file.delete()){
                throw new IOException("Failed to delete" + file.getCanonicalPath());
            }
        }
    }
}
