package Battle;

public abstract class Type {

    protected Type(){
        //most of the time this is irrelevant
        MainType mainType;

        int test;
        //this is the more important part
        SubType subType;
    }


}

enum MainType {
    ELEMENTAL,
    PHYSICAL,
    //SPECTRAL,
    META,
}

enum SubType {
    AIR,
    WATER,
    ELECTRIC,
    FIRE,
    EARTH,

    PIERCE,
    SLASH,
    BLUNT,
    FRICTIVE,
    BLAST,
/*
    DARK,
    LIGHT,
    VISIBLE,
    INFRARED,
    ULTRAVIOLET,
*/
    METAPHYSICAL;

    public MainType getMainType()
    {
        MainType type = MainType.META;

        switch(this)
        {
            case AIR:
            case WATER:
            case ELECTRIC:
            case FIRE:
            case EARTH:
                type = MainType.ELEMENTAL;
                break;

            case PIERCE:
            case SLASH:
            case BLUNT:
            case FRICTIVE:
            case BLAST:
                type = MainType.PHYSICAL;
                break;

            /*
            case DARK:
            case LIGHT:
            case VISIBLE:
            case INFRARED:
            case ULTRAVIOLET:
                type = Maintype.SPECTRAL;
                break;
            */

            default:
                type = MainType.META;

        }


        return type;
    }

}

enum SkillProperty{

    FIERY, /*All Fire skills have a (Luk*n/2)% chance to inflict BURN where n is the strength of the skill;
            severity of BURN increases with each proc*/
    ACIDIC,
    ABSOLUTE,
    FRICTIVE, //All Friction attacks have a (Luk*[5-n]/2)% chance to inflict BIND where n is the strength of the skill
    CRITICAL //Luk chance to do all 1.5*damage and ignore DEF buffs

}

enum Ailment{

}
