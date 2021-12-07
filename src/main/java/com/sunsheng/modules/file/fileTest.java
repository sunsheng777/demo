package com.sunsheng.modules.file;

import java.io.*;
import java.util.UUID;

public class fileTest {
    public static void main(String[] args) throws IOException {
//        createFile();
//        fileQieFen();
        fileHeBing();
    }


    public static void createFile() throws IOException {
        File file = new File("D:\\下载\\tmp\\test.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < 3333; i++) {
            bufferedWriter.write(UUID.randomUUID().toString().replace("-", ""));
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    public static void fileQieFen() throws IOException {
        File files = new File("D:\\下载\\tmp\\test.txt");
        File outfilepath = new File("D:\\下载\\tmp\\");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(files)));
        PrintWriter writer = null;
        String line = "";
        int countLine = 0;
        int fileLine = 1000;
        while ((line = bufferedReader.readLine()) != null) {
            if (countLine % fileLine == 0) {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
                String filename = files.getName() + (countLine / fileLine);
                String pathname = outfilepath + "\\" + filename + ".txt";
                writer = new PrintWriter(new File(pathname));
            }
            writer.println(line);
            ++countLine;
        }
        if (writer != null) {
            writer.flush();
            writer.close();
        }
    }

    public static void fileHeBing() throws IOException {
        String FileOut = "D:\\下载\\tmp\\test.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(FileOut));
        File[] list = new File("D:\\下载\\tmp").listFiles();
        int fileCout = 0;
        int folderCount = 0;
        for (File file : list) {
            if (file.isFile()) {
                fileCout++;
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                }
                br.close();
            } else {
                folderCount++;
            }
        }
        bw.close();
        System.out.println("输入目录下文件个数为" + fileCout);
        System.out.println("输入目录下文件夹个数为" + folderCount);
    }
}
