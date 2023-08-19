import java.util.ArrayList;

public class MainClass{
    public static void main(String[] args){
        BasicJava basic = new BasicJava();
        System.out.println("Imprimir la Suma\n");
        basic.ImprimirLaSuma();
        
        System.out.println("\nRecorrer Arreglo\n");
        ArrayList<Object> arr = new ArrayList<Object>();

        arr.add(1.0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        // arr.add(basic.Test());

        int[] arr2 = new int[5];
        arr2[0] = 1;
        arr2[1] = 3;
        arr2[2] = 0;
        arr2[3] = 9;
        arr2[4] = -1;

        // basic.RecorrerArregloConArreglo(arr2);
        basic.RecorrerArreglo(arr);
        System.out.println("\nFuncion sobrecargada\n");
        // basic.RecorrerArreglo();
        System.out.println("Maximo: "+basic.FindMaximum(arr2));

        System.out.println("Promedio: "+basic.FindAverage(arr2));

        System.out.println("Array: "+basic.OddNumbers());

        System.out.println("Cantidad: "+basic.GreaterThan(arr2, 0));

        int[] arr3 = new int[5];
        arr3[0] = 1;
        arr3[1] = 3;
        arr3[2] = 0;
        arr3[3] = 9;
        arr3[4] = -1;
        basic.SquareValues(arr3);
        System.out.println("Valores al cuadrado: \n");
        for(int i = 0; i < 5; ++i){
            System.out.println(arr3[i]);
        }
        arr3[0] = 1;
        arr3[1] = 3;
        arr3[2] = 0;
        arr3[3] = 9;
        arr3[4] = -1;
        System.out.println("Elementos incluyendo Negativos: \n");
        basic.PrintArray(arr3);
        System.out.println("Elementos sin Negativos: \n");
        basic.DeleteNegatives(arr3);
        basic.PrintArray(arr3);
        System.out.println("Max, Min, Avg: \n");
        int[] res = basic.MinMaxAvg(arr3);
        basic.PrintArray(res);
        arr3[0] = 1;
        arr3[1] = 3;
        arr3[2] = 0;
        arr3[3] = 9;
        arr3[4] = -1;
        System.out.println("Swapping (Before): \n");
        basic.PrintArray(arr3);
        basic.SwapNext(arr3);
        System.out.println("Swapping (After): \n");
        basic.PrintArray(arr3);
    }
}