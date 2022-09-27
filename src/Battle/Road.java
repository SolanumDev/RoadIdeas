package Battle;

import java.util.Hashtable;

public class Road {
    public static void main(String[] args)
    {
        /*
        for (int i = 0; i < Subtype.values().length; i++)
        {
            System.out.println(Subtype.values()[i]);
        }
        */

        Unit dave = new Unit();


        Hashtable<SubType, Float> immunities = new Hashtable<>();
        immunities.put(SubType.AIR,  1f);

        //The Agidyne Surtr when I null fire
        dave.setResistance(SubType.FIRE, 0);

        //The Gae Bulg Cu Chulain when I null physical
        dave.setResistance(MainType.PHYSICAL, 0);
        /*
        Battle.SubType Agidyne = Battle.SubType.FIRE;
        Battle.SubType Megidolaon = Battle.SubType.METAPHYSICAL;
        Battle.SubType Garudyne = Battle.SubType.AIR;
        System.out.println("Garudyne Test");
        System.out.println( dave.damageCalc(5, 10, 0, Battle.SubType.AIR));
        System.out.println("Agidyne Test");
        System.out.println( dave.damageCalc(50, 99, 50, Battle.SubType.FIRE));
        System.out.println("Hassou Tobi Test");
        System.out.println( dave.damageCalc(50, 100, 50, Battle.SubType.BLAST));
        System.out.println("Megidolaon Test");
        System.out.println( dave.damageCalc(50, 198, 50, Battle.SubType.METAPHYSICAL));
        */
        //System.out.println(Garudyne.ordinal());
        //System.out.println(Subtype.values()[Garudyne.ordinal()]);



        System.out.println("Breeze Test");
        MoveList moveHandler = new MoveList();
        Move usedMove = moveHandler.Breeze();
        usedMove.setEverything();

        //System.out.println(usedMove.primaryType);
        //System.out.println(usedMove.basePower);

        SubType type = usedMove.primaryType;
        System.out.println( dave.damageCalc(5, usedMove.basePower, 0, usedMove.primaryType));
        usedMove.effect();
        //System.out.println( dave.damageCalc(50, 200, 50, usedMove.primaryType));




    }
}
