package Battle;

public class MoveList {


    public Move Breeze(){

        Move toReturn = new Move() {

            @Override
            protected void setEverything() {
                primaryType = SubType.AIR;
                damTier = DamageTier.MILD;
                basePower = 20;
            }

            @Override
            protected void effect() {
                System.out.println("Breeze!");
            }
        };
        /*
        class toReturn extends Battle.Move{}
        {



        };*/


        return toReturn;
    }


};

