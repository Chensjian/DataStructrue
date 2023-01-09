package com.chen;



import java.io.*;

/**
 * @author chenchenchen
 * @create 2023-01-09 21:31
 */
public class SparseArray {
    public static void main(String[] args) {
        //先创建原始数组
        int[][] array=new int[11][11];
        array[1][2]=1;
        array[2][3]=2;
        array[2][4]=2;
        System.out.println("原始数组");
        for(int[] arr:array){
            for(int data:arr){
                System.out.print(data+"\t");
            }
            System.out.println();
        }
        //遍历元素数组得到有效数值个数
        int sum=0;
        for(int[] arr:array){
            for(int data:arr){
                if(data!=0){
                    sum++;
                }
            }
        }
        System.out.println("原始数组有效数值个数为:"+sum);
        //创建稀疏数组
        //稀疏数组的row等于数值个数加一 因为第一行需要保存原始数组的信息
        //稀疏数组的col等于3
        //第一行第一列保存的是元素数组的行数，第一行第二列保存的是原始数组的行数，第一行第三列保存的是原始数组的数值个数
        int[][] sparseArray2=new int[sum+1][3];
        //将二维数组的有效数据存入到稀疏数组
        sparseArray2[0][0]=array.length;
        sparseArray2[0][1]=array[0].length;
        sparseArray2[0][2]=sum;
        int count=0;//计数器
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(array[i][j]!=0){
                    count++;
                    sparseArray2[count][0]=i;
                    sparseArray2[count][1]=j;
                    sparseArray2[count][2]=array[i][j];
                }
            }
        }
        System.out.println("稀疏数组");
        System.out.println("row\tcol\tval");
        for(int i=0;i<sparseArray2.length;i++){
            System.out.println(sparseArray2[i][0]+"\t"+sparseArray2[i][1]+"\t"+sparseArray2[i][2]);
        }

        //将稀疏数组保存到文件
        System.out.println("将稀疏数组保存到文件");
        File writeFile = new File("sparseArray.data");
        ObjectOutputStream objectOutputStream=null;
        try{
            objectOutputStream=new ObjectOutputStream(new FileOutputStream(writeFile));
            objectOutputStream.writeObject(sparseArray2);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("保存成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        //从文件中读取数据
        System.out.println("从文件中读取数据,还原数组");
        File readFile=new File("sparseArray.data");
        ObjectInputStream objectInputStream=null;
        int [][] sparseArray3=null;
        try{
            objectInputStream=new ObjectInputStream(new FileInputStream(readFile));
            sparseArray3 = (int[][])objectInputStream.readObject();
            System.out.println("输出还原后的数组");
            for (int i=0;i<sparseArray3.length;i++){
                for (int j=0;j<sparseArray3[i].length;j++){
                    System.out.print(sparseArray3[i][j]+"\t");
                }
                System.out.println();
            }
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        //将稀疏数组转换回原始数组
        System.out.println("将稀疏数组还原成初始数组");
        int[][] array2=new int[sparseArray3[0][0]][sparseArray3[0][1]];
        for(int i=1;i<sparseArray3.length;i++){
            array2[sparseArray3[i][0]][sparseArray3[i][1]]=sparseArray3[i][2];
        }
        System.out.println("输出还原后的初始数组");
        for(int i=0;i<array2.length;i++){
            for(int j=0;j<array2[i].length;j++){
                System.out.print(array2[i][j]+"\t");
            }
            System.out.println();
        }


    }
}
