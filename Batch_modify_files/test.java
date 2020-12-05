// package Batch_modify_files;

// import java.io.*;
// import java.util.ArrayList;
// import java.util.LinkedList;

// public class test {
//     public static void main(String[] args) {
//         // create_folder();
//         // create_file(name);
//         enum_all_files();
//     }

//     public static void create_folder(File name) {
//         try {
//             if (!name.exists()){
//                 name.mkdir();
//             }
//         }
//         catch (Exception e){
//             System.out.println("新建目录操作出错");
//             e.printStackTrace();
//         }
//     }

//     public static void create_file(File name) {
//         try{
//             if (!name.exists()){
//                 name.createNewFile();
//             }
//             FileWriter result = new FileWriter(name);
//             PrintWriter myfile = new PrintWriter(result);
//             myfile.println("str2");
//             result.close();
//         }
//         catch (Exception e){
//             System.out.println("失败");
//             e.printStackTrace();
//         }
//     }

//     public static void enum_all_files() {
//         LinkedList<String> folderList = new LinkedList<String>();
//         folderList.add("examples");
//         while (folderList.size() > 0){
//             File file = new File(folderList.peek());
//             folderList.removeLast();
//             File[] files = file.listFiles();
//             ArrayList<File> fileList = new ArrayList<File>();
//             for (int i = 0; i < files.length; i++){
//                 if (files[i].isDirectory()){
//                     folderList.add(files[i].getPath());
//                     System.out.println(files[i]);
//                 }
//                 else{
//                     fileList.add(files[i]);
//                 }
//             }

//         }
//     }
// }