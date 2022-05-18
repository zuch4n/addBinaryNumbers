public class A8_P2_IQBAL_ZAMAR  {

   // replace "LASTNAME_FIRSTNAME" with your lastname_firstname, like KIMMEL_PETER,
   // in both the file name, the class name, and the String below.

   public static String name = "IQBAL_ZAMAR";

   // Write the method below.
   // Remember, A and B may have different lengths.
   // Your program must NOT crash--no out of bounds exceptions!

   public static int [] addBinaryNumbers(int [] x, int [] y)
   {
      int largerLength;
      
      //Initialize two new arrays, both to size of larger input array
      if(arrLength(x) > arrLength(y))
         largerLength = arrLength(x);
      else
         largerLength = arrLength(y);

      int a[] = new int [largerLength];
      int b[] = new int [largerLength];
      
      //Copy input array x to array a, copy input array y to array b
      if(arrLength(x) > arrLength(y))
      {
         for(int i = 0; i < arrLength(x); i++)
         {
            a[i] = x[i];
         }
         for(int i = 0; i < arrLength(y); i++)
         {
            b[arrLength(b) - 1 - i] = y[arrLength(y) - 1 - i];
         }
      }
      else if(arrLength(x) < arrLength(y))
      {
         for(int i = 0; i < arrLength(y); i++)
         {
            b[i] = y[i];
         }
         for(int i = 0; i < arrLength(x); i++)
         {
            a[arrLength(a) - 1 - i] = x[arrLength(x) - 1 - i];
         }
      }
      else
      {
         for(int i = 0; i < arrLength(y); i++)
         {
            a[i] = x[i];
            b[i] = y[i];
         }
      }
      
      //Initialize output array z to size of larger input array + 1
      int z[] = new int [largerLength + 1];

      //Logic for adding binary numbers
      //"No carry" state
      for(int i = 1; i < arrLength(z); i++)
      {
         if(a[arrLength(a) - i] == 0 && b[arrLength(b) - i] == 0)
         {
            z[arrLength(z) - i] = 0;
         }
         
         else if(a[arrLength(a) - i] == 0 && b[arrLength(b) - i] == 1)
         {
            z[arrLength(z) - i] = 1;
         }
         
         else if(a[arrLength(a) - i] == 1 && b[arrLength(b) - i] == 0)
         {
            z[arrLength(z) - i] = 1;
         }
         
         //Trigger "carry state"
         else if (a[arrLength(a) - i] == 1 && b[arrLength(b) - i] == 1)
         {
            z[arrLength(z) - i] = 0;
            i++;
            
            //"Carry state"
            while(i < arrLength(z))
            {
                  //Break out of "carry state"
                  if(a[arrLength(a) - i] == 0 && b[arrLength(b) - i] == 0)
                  {
                     if(i == arrLength(z) - 1)
                     {
                       z[arrLength(z) - i] = 1;
                       z[arrLength(z) - i - 1] = 1;
                       break;
                     }
                     else
                     {
                       z[arrLength(z) - i] = 1;
                       break;
                     }
                  }
                 
                 else if(a[arrLength(a) - i] == 0 && b[arrLength(b) - i] == 1)
                  {
                    if(i == arrLength(z) - 1)
                    {
                      z[arrLength(z) - i] = 0;
                      z[arrLength(z) - i - 1] = 1;
                    }
                    else
                    {
                      z[arrLength(z) - i] = 0;
                    }
                  }
                  
                  else if(a[arrLength(a) - i] == 1 && b[arrLength(b) - i] == 0)
                  {
                    if(i == arrLength(z) - 1)
                    {
                      z[arrLength(z) - i] = 0;
                      z[arrLength(z) - i - 1] = 1;
                    }
                    else
                    {
                      z[arrLength(z) - i] = 0;
                    }
                  }
                  
                  else if (a[arrLength(a) - i] == 1 && b[arrLength(b) - i] == 1)
                  {
                    if(i == arrLength(z) - 1)
                    {
                      z[arrLength(z) - i] = 1;
                      z[arrLength(z) - i - 1] = 1;
                    }
                    else
                    {
                      z[arrLength(z) - i] = 1;
                    }
                  }
                  
                  i++;
            }
         }
      }
      return z;
   }
  
  //Method which returns array length
  public static int arrLength(int[] x) 
  {
	   int length = 0;
	   while(true) 
      {
		   try 
         {
			   int temp = x[length];
			   length += 1;
		   }
		   catch(Exception f) 
         {
			   return length;
		   }
	   }
   }
   
//********************************************************************
// DO NOT CHANGE ANYTHING BELOW THIS LINE!!!
//*********************************************************************


   public static void main(String [] args)
   {
      System.out.println("\n" + name);
      System.out.println("CS-325, A7_P1: Adding Binary Numbers in Arrays.\n");

      int [] x, y, z;

      for (int i = 0; i < data.length/2; i++) {

         System.out.println("Test " + (i+1) + ":  \n");

         x = data[2*i];
         y = data[2*i + 1];
         z = addBinaryNumbers(x, y);

         int m = x.length;
         int n = y.length;
         int p = Math.max(m,n);

         printChars(4 + p - m, ' ');
         printArray(x);
         System.out.print("  + ");
         printChars(p - n, ' ');
         printArray(y);
         System.out.print("  ");
         printChars(2+p, '=');
         System.out.print("\n   ");
         printArray(z);
         System.out.println();

      }
   }


   public static int [][] data = {

      {1,0},
      {0,1},

      {1,1,1,1,1},
      {1},

      {1},
      {1,1,1,1,1},

      {1,1,1,0},
      {1,1,0,1,1,1},

      {1,0,1,0},
      {1,1,1,0,1,1,0,1,1},

      {1,1,0,1,1,0,1},
      {1,1,1,0,0,1},

      {1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1},

      {1,0,1,1,1,1,0,1,0,1},
      {1,1,1,0,0,0,1,1}


   };



   public static void printArray(int [] A) {

      for (int i = 0; i < A.length; i++)
         System.out.print(A[i]);
      System.out.println();
   }

   public static void printChars(int n, char c) {

      for (int i = 1; i <= n; i++)
         System.out.print(c);
   }



}
