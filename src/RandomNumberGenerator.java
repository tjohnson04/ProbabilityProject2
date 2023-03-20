public class RandomNumberGenerator {
    private int count;
    private double seed;
    private double multiplier;
    private double modulus;
    private double increment;
    private double U;
    private double callTime;
    public RandomNumberGenerator(){
        this.count=0;
        this.seed=1000;
        this.multiplier=24693;
        this.increment=3517;
        this.modulus= Math.pow(2,17);
        this.U=0;
        this.callTime=0;
    }

    public void calculateX(){
        this.seed=(multiplier*seed+increment)%modulus;
        U=seed/modulus;
    }
    public double getU(){
        return this.U;
    }

    public double inverse(){
        return -12*Math.log(1-this.U);
    }

    public double findW(){
        callTime=0;
        int numCalls=0;
        while (numCalls<4){
            callTime+=6;
            this.calculateX();
            if (this.U<=.2){
                callTime+=3;
            }
            else if (this.U<=.5){
                callTime+=25;
            }
            else if (this.U<=1){
                this.calculateX();
                double limit= 1- Math.exp(-25/12);
                if (this.U>limit){
                    callTime+=25;
                }
                else if (this.U<limit){
                    callTime+= inverse();
                    callTime+=1;
                    return callTime;
                }
            }
            callTime+=1;
            numCalls++;

        }
        return callTime;
    }
}
