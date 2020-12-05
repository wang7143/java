// package Batch_modify_files;


  
// import java.io.BufferedReader;  
// import java.io.BufferedWriter;  
// import java.io.File;  
// import java.io.FileReader;  
// import java.io.FileWriter;  
  
// /** 
//  * 替换所有文件的内容 
//  * @author Administrator 
//  * 
//  */  
// public class test1 {  
//     private static  int i=0;  
//     public static void main(String[] args) {  
//         File file = new File("examples");  
//         list(file);  
//     }  
      
//     private static void list(File file){  
//         File[] listFiles = file.listFiles();  
//         for (File file2 : listFiles) {  
//             if (file2.isFile() && file2.getName().contains("java") ) {  
//                 //BufferedInputStream bs = new BufferedInputStream(new FileInputStream(file2));  
//                 try {
//                     System.out.println(file2.getName());  
//                     StringBuffer sb = new StringBuffer();  
//                     BufferedReader br = new BufferedReader(new FileReader(file2));  
//                     String s="";  
//                     boolean change=false;  
//                     while ((s=br.readLine())!=null) {  
//                         if (s.indexOf("package ") > -1) {  
//                             change=true;  
//                             sb.append("     <script type=\"text/javascript\" src=\"../../jquery-1.6.js\"></script>");  
//                         }else {  
//                             sb.append(s);  
//                         }  
//                         sb.append("\r\n");  
//                     }  
//                     br.close();  
//                     if (change) {  
//                         BufferedWriter bw = new BufferedWriter(new FileWriter(file2));  
//                         bw.write(sb.toString());  
//                         bw.close();  
//                         System.out.println(++i);  
//                     }  
  
//                 } catch (Exception e) {  
//                     //  Auto-generated catch block  
//                     e.printStackTrace();  
//                 }  
//             }else {  
//                 list(file2);  
//             }  
//         }  
//     }  
// }