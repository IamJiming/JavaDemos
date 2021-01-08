package com.jiming.daily;


    class LowHighSwap
    {
      public static void doIt( int[] z )
        {
            int temp = z[z.length-1];
            System.out.print("temp" + temp +"\n");
            z[z.length-1] = z[0];
            System.out.print("z[z.length-1]" + z[z.length-1]+"\n");
            System.out.print("z[0]" + z[0]+"\n");
            z[0] = temp;
            System.out.print("z[0]11" + z[0]+"\n");
            System.out.print("temp11" + temp+"\n");
        }
    }

class TestIt
{
    public static void main( String[] args )
    {
        int[] myArray = {1, 2, 3, 4, 5};
        LowHighSwap.doIt(myArray);
        for (int i = 0; i < myArray.length; i++)
        {
            System.out.print(myArray[i] + " ");
        }
    }
}
