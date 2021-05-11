/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;


public class Sample {

   public static boolean bear(int n){
while (n>42)

 

{

 

//As in example 250 is divisible by 2 even as well as by 5 but

 

// Exclusively the divisible by 5 operation is done first

 

// so condition is added that it should only enter when it is not divisible by 5

 

// but is a even number

 

 

 

//Few things are missing in the requirement which just infered by the step

 

// after bear from 208 to 104 to 52

 

// 52 still is even number but not halfed , so in order to avoid it logic colud be to check

 

// if the half is greater than 42

 

if (n % 2 == 0 && !(n % 5 == 0) && (n / 2 >42))

 

{

 

    System.out.println(" is even so the bear count now is " +  n / 2); 

 

n = n / 2;

 

}

 

else if ((n % 3 == 0 ) || (n % 4 == 0))

 

{

 

int n1 = n % 10;

 

int n2 = ((n % 100) / 10);

 

    System.out.println(" is divisible by 3 or 4 so the bear count now is " +(n - (n1*n2)));

 

n = n - (n1*n2);

 

}

 

else if (n % 5 == 0)

 

{

    System.out.println(" Divisible by 5 and the count of bear is now "+ (n-42) ); 

n = n - 42;

 

}

 

}

 

if (n == 42){
    return true;

}
else{
return false;

}

 

}



 








 



    public static void main(String[] args) {
        // TODO code application logic here
int Be = 250;
boolean x = bear(250);

 

if (x){

 
System.out.println("You reached the Goal " ); 
}
else{

 System.out.println("You failed " ); 
        }
    

}
}
