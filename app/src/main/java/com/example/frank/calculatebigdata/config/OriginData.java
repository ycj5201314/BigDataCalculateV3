package com.example.frank.calculatebigdata.config;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class OriginData {
    public static int []input1=new int[7];
    public static int []input2=new int[7];
    public static int []input3=new int[7];
    public static int []input4=new int[7];
    public static int []input5=new int[7];
    public static int []input6=new int[7];
    public static int []input7=new int[7];

    public static String dataMode="";
    public static String result="";
    public static  int index=1;
    public static HashMap<String,String> computeDataResult1for7=new HashMap<>();
    public static HashMap<String,String> computeDataResult2for7=new HashMap<>();
    public static HashMap<String,String> computeDataResult3for7=new HashMap<>();

    public static HashMap<String,String> computeDataResult1for21=new HashMap<>();
    public static HashMap<String,String> computeDataResult2for21=new HashMap<>();
    public static HashMap<String,String> computeDataResult3for21=new HashMap<>();

    //public static HashMap<String,String> computeDataResult=new HashMap<>();
    public static ConcurrentHashMap<String,String> computeDataResult=new ConcurrentHashMap<>();

    public static boolean isNotAuCompute=false;
    public static boolean lookAllResult=false;
    public static boolean isNotSeeven=false;
    public static boolean hadCompute=false;


}
