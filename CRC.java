import java.util.*;
public class p1{
public static void main(String args[]){
Scanner s=new Scanner(System.in);
int n;
System.out.println("enter the size of the data");
n=s.nextInt();
int data[]=new int[n];
System.out.println("enter the data bit by bit");
for(int i=0;i<n;i++){
data[i]=s.nextInt();
}
System.out.println("enter the size of the divisor");
n=s.nextInt();
int divisor[]=new int [n];
System.out.println("enter the divisor bit by bit");
for(int i=0;i<n;i++)
divisor[i]=s.nextInt();
int remainder []= divide (data,divisor);
System.out.println("\n the crc code generates is");
for(int i=0;i<data.length;i++)
System.out.print(data[i]);
for(int i=0;i<remainder.length-1;i++)
System.out.print(remainder[i]);
System.out.println();
int sent_data[]=new int [data.length+remainder.length-1];
System.out.println("enter the data to be sent:");
for(int i=0;i<sent_data.length;i++)
sent_data[i]=s.nextInt();
recieve(sent_data,divisor);
}
static int [] divide (int old_data[],int divisor[])
{
int remainder[],i;
int data[]=new int [old_data.length+divisor.length];
System.arraycopy(old_data,0,data,0,old_data.length);
System.out.println("message bits after appending divisor length-1;");
for(i=0;i<data.length-1;i++)
System.out.println(data[i]);
remainder=new int [divisor.length];
System.arraycopy(data,0,remainder,0,divisor.length);
for(i=0;i<old_data.length;i++){
if(remainder[0]==1){
for (int j=1;j<divisor.length;j++){
remainder[j-1]=exor(remainder[j],divisor[j]);
}}else{
for(int j=1;j<divisor.length;j++){
remainder[j-1]=exor(remainder[j],0);
}
}
remainder[divisor.length-1]=data[i+divisor.length];
}
return  remainder;
}

static int exor(int a,int b){
if(a==b){
return 0;
}
return 1;
}
static void recieve (int data[],int divisor[]){
int remainder[]=divide(data,divisor);
for(int i=0;i<remainder.length;i++){
if(remainder[i]!=0){
System.out.println("there is an error in received data");
return;
}
}
System.out.println("data was received without any error");
}
}
/*
enter the size of the data
7
enter the data bit by bit
1
0
1
1
0
0
1
enter the size of the divisor
3
enter the divisor bit by bit
1
0
1
message bits after appending divisor length-1;
1
0
1
1
0
0
1
0
0

 the crc code generates is
101100111
enter the data to be sent:
1
0
1
1
0
0
1
0
1
message bits after appending divisor length-1;
1
0
1
1
0
0
1
0
1
0
0
there is an error in received data
*/
