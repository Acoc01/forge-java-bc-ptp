public class FizzBuzz{
    public String fizzBuzz(int n){
        //Uso el operador ternario, es equivalente a un if(n%3 == 0), si se cumple pregunta
        // si también es divisible por 5, si también es divisible por 5, entonces retorna FizzBuzz
        // Si no es divisible por 5 entonces retorna Fizz.
        // Si no era divisible por 3, entonces pregunta si era divisible por 5 (Esto es equivalente a que es divisible por 5 pero no por 3)
        // Si es divisible por 5 pero no por 3 retorna Buzz
        // Si no se cumplió ninguna de las anteriores retorna n como un String utilizando la función Integer.toString() de java
        return n % 3 == 0 ? n % 5 == 0 ? "FizzBuzz": "Fizz" : n % 5 == 0 ? "Buzz" : Integer.toString(n);
    }
}