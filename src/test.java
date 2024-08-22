class test {
    public static void main(String[] args) {
        try{
            int a = 1/0; //Dividir por cero arroja una ArithmeticException
        }catch(ArithmeticException e){
            System.out.print("Catch 1");
        }catch(Exception e){
            System.out.print("Catch 2");
        }finally{
            System.out.print("Finally");
        }
    }
}