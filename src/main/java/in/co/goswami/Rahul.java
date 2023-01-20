package in.co.goswami;

public class Rahul extends Human{

    public void canRun(){
        System.out.println("Rahul can Run");
    }

    public void canWalk(){
        System.out.println("Rahul can Walk");
    }

    public int checkPrime(int n){
        int i, m=0, flag=0;
        m=n/2;
        if(n==0||n==1){
            System.out.println(n+" is not prime number");
        }else{
            for(i=2;i<=m;i++){
                if(n%i==0){
                    System.out.println(n+" is not prime number");
                    flag=1;
                    break;
                }
            }
            if(flag==0)  { System.out.println(n+" is prime number"); }
        }
        return n;
    }

    public byte[] convertBase64(String str){
        byte[] encoded = Base64.getEncoder().encode(str.getBytes());
        return encoded;
    }

    public String convertBase64ToString(byte[] encoded){
        String decoded = new String(Base64.getDecoder().decode(encoded));
        return decoded;
    }

    public double factorial(int n){
        double fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }

    public double fibonacci(int n){
        int a=0,b=1,c=0;
        for(int i=1;i<=n;i++){
            System.out.print(a+" ");
            c=a+b;
            a=b;
            b=c;
        }
        return a;
    }

    public int[] sortArray(int[] arr){
        int temp;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }

    public int[] reverseArray(int[] arr){
        int temp;
        for(int i=0;i<arr.length/2;i++){
            temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        return arr;
    }


}