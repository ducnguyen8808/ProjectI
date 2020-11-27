//
// Created by ducng on 11/26/2020.
//

#ifndef CREATEMAP_SUDOKU_H
#define CREATEMAP_SUDOKU_H
#include <iostream>
#include <random>
#include <cstdlib>
#include <ctime>
#include <chrono>
#include<stdlib.h>
#include <iomanip>
#include <fstream>

#define UNASSIGNED 0

using namespace std;
int cnt=0;
class sudoku
{
public :
    int comp[9][9];
    int data[9][9];
    int arr[9][9];

    void getdata()
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                data[i][j]=0;
            }
        }
    }
    void showEasy() {
        fstream easy;
        easy.open("MapEasy.txt", ios::app);
        string temp = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                temp += to_string(arr[i][j]) + " ";
            }
            temp += to_string(arr[i][8]) + "\n";

            easy << temp;
            temp = "";
        }
        easy << "\n";
    }
    void showNormal() {
        fstream normal;
        normal.open("MapNormal.txt", ios::app);
        string temp = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                temp += to_string(arr[i][j]) + " ";
            }
            temp += to_string(arr[i][8]) + "\n";

            normal << temp;
            temp = "";
        }
        normal << "\n";
    }
    void showHard() {
        fstream hard;
        hard.open("D:MapHard.txt", ios::app);
        string temp = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                temp += to_string(arr[i][j]) + " ";
            }
            temp += to_string(arr[i][8]) + "\n";

            hard << temp;
            temp = "";
        }
        hard << "\n";
    }
    void psuedogen();
    bool findzero(int&,int&);
    bool checkgrid(int,int,int);
    bool checkrow(int,int);
    bool checkcol(int,int);
    bool check(int,int,int);
    bool sudogen();
    bool finalsudogen();
};
bool sudoku :: findzero(int &i,int &j)
{
    for(i=0;i<9;i++)
    {
        for(j=0;j<9;j++)
        {
            if(data[i][j] == UNASSIGNED)
            {
                return true;
            }
        }
    }
    return false;
}
bool sudoku :: checkrow(int num,int i)
{
    for(int k=0;k<9;k++)
    {
        if(data[i][k] == num)
        {
            return true;
        }
    }
    return false;
}
bool sudoku :: checkcol(int num,int j)
{
    for(int k=0;k<9;k++)
    {
        if(data[k][j] == num)
        {
            return true;
        }
    }
    return false;
}
bool sudoku :: checkgrid(int i,int j,int num1)
{
    int ch=0,ch1=0,limit=i-i%3,lim=j-j%3;

    for(int k=ch;k<3;k++)
    {
        for(int x=ch1;x<3;x++)
        {
            if(num1==data[k+limit][x+lim])
            {
                return true;
            }
        }
    }
    return false;
}
bool sudoku :: check(int i,int j,int num)
{
    return !checkrow(num,i) && !checkcol(num,j) && !checkgrid(i,j,num);
}
bool sudoku :: sudogen()
{
    int i, j;
    cnt++;
    if (!findzero(i,j))
    {
        return true;
    }

    for (int num = 1; num <= 9; num++)
    {
        if (check(i,j,num))
        {
            data[i][j] = num;
            if (sudogen())
            {
                return true;
            }
            data[i][j] = UNASSIGNED;
        }
    }
    return false;
}

void sudoku :: psuedogen()
{
    int s=0,v=0,num=0;
    unsigned seed = chrono::system_clock::now().time_since_epoch().count();
    default_random_engine generator(seed);
    uniform_int_distribution<int> distribution(1,9);
    uniform_int_distribution<int> pos(0,8);

    for(int k=0;k<18;k++)
    {
        label : s=pos(generator);
        v=pos(generator);
        num=distribution(generator);
        if(!checkrow(num,s))
        {
            if(!checkcol(num,v))
            {
                if(!checkgrid(s-s%3,v-v%3,num))
                {
                    data[s][v] = num;
                }
                else
                {
                    goto label;
                }
            }
            else
            {
                goto label;
            }
        }
        else
        {
            goto label;
        }

    }
}
bool sudoku :: finalsudogen()
{
    int ch1;

    int s=0,v=0;
    getdata();
    unsigned seed = chrono::system_clock::now().time_since_epoch().count();
    default_random_engine generator(seed);
    uniform_int_distribution<int> distribution(0,8);
    psuedogen();
    sudogen();

    for(int i=0;i<9;i++)
    {
        for(int j=0;j<9;j++)
        {
            arr[i][j]=data[i][j];
        }
    }
    //try
    for(int i=0;i<25;i++)
    {
        s=distribution(generator);
        v=distribution(generator);
        arr[s][v]=0;
    }
    showEasy();
    for(int i=0;i<39;i++)
    {
        s=distribution(generator);
        v=distribution(generator);
        arr[s][v]=0;
    }
    showNormal();
    for(int i=0;i<50;i++)
    {
        s=distribution(generator);
        v=distribution(generator);
        arr[s][v]=0;
    }
    showHard();

    return true;
}

#endif //CREATEMAP_SUDOKU_H
