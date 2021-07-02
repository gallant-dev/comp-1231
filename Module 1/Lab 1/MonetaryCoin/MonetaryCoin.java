public class MonetaryCoin extends Coin
{
    private int value = 5;

    //Constructor.
    public MonetaryCoin(int coinValue){
        value = coinValue;
    }

    //Mutator.
    public void setValue(int coinValue){
        value = coinValue;
    }

    //Accessor.
    public int getValue(){
        return value;
    }
}