public class CommandLine {

   public CommandLine() {

   }


   public static void main(String[] var0) {

      if (var0.length == 0) {

         System.out.println("No arguments provided.");

      } else {

         String var1 = var0[0];

         if (var0.length < 3) {

            System.out.println("not enough arguments");

         } else {

            double var2 = Double.parseDouble(var0[1]);


            for(int var4 = 2; var4 < var0.length; ++var4) {

               double var5 = Double.parseDouble(var0[var4]);

               switch (var1) {

                  case "+":

                     var2 += var5;

                     break;

                  case "-":

                     var2 -= var5;

                     break;

                  case "*":

                     var2 *= var5;

                     break;

                  case "/":

                     if (var5 == 0.0) {

                        System.out.println("Error: Division by zero.");

                        return;

                     }


                     var2 /= var5;

                     break;

                  default:

                     System.out.println("not supported operator: " + var1);

                     return;

               }

            }


            System.out.println("Result: " + var2);

         }

      }

   }

}


