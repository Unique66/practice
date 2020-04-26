package com.sxh.io;/**
 * Created by SXH on 2019/7/6 16:58.
 */

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author SXH
 * @description
 * @date 2019/7/6 16:58.
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        System.out.println(args.toString());
        System.out.println(args.length);
        if (args.length != 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter (String regex) {
        pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
