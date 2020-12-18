package com.sparta.rashawn.controller;

import com.sparta.rashawn.model.Employee;
import com.sparta.rashawn.model.ThreadedDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GenerateThreads {


    private int numberOfThreads = 2;
    private Thread[] threadList = new Thread[numberOfThreads];

    private static Logger logger = LogManager.getLogger(GenerateThreads.class);


    public List<Employee> splitList(ArrayList<Employee> employees, int counter) {

       List<Employee> split;
        int size = employees.size() / numberOfThreads;
        int remainder = 0;
        int dividedTotal = size * numberOfThreads;

        if(dividedTotal != employees.size()){
            remainder = employees.size() - dividedTotal;
        }

            if (counter > 0 && counter >(numberOfThreads-1)){
                int finish = size * (counter + 1);
                int start = size * counter;
                split = employees.subList(start,finish);
            }else if(counter == (numberOfThreads-1)) {
                int finish = size * (counter + 1);
                int start = size * counter;
                split = employees.subList(start, finish + remainder);
            }
            else{
                split =  employees.subList(0,size);
            }

         return split;

    }
    public Thread[] getThreads(){
        return threadList;
    }
    public void runThreads(ArrayList<Employee> employees) {
        List<Employee> split;
        for (int i = 0; i <= numberOfThreads-1; i++) {
            logger.info("Generating thread: " + i);
            split = splitList(employees,i);
            threadList[i] = new Thread(new ThreadedDAO(split));
            logger.info("Thread: " + i + "is doing " + split.size());
            startThreads(i);
        }
    }

    public void startThreads(int i){
        threadList[i].start();
    }

}
