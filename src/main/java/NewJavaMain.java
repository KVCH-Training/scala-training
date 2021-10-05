public class NewJavaMain {

    public static void main(String[] args) {


        Operator operator = new Operator(23);
        Operator operator1 = new Operator(212);

//        System.out.println(operator * operator1);

        System.out.println(operator.$times(operator1));
    }
}
