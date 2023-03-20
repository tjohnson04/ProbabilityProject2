public class Main {
    public static int count;
    public static void main (String[] args){
        double x=0;
        RandomNumberGenerator r1= new RandomNumberGenerator();
        double total=0;
        for (int i=0; i<500; i++){
            x= r1.findW();
            System.out.println(i+1+": "+x);
            total+=x;
        }
    }
}
