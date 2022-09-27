package Battle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Unit {

    protected int HP = 50;
    protected int HPMAX = 50;

    protected int ATT = 1;
    protected int DEF = 5;
    protected int LUK = 0;
    protected int SPE = 1;

    protected int abSlots = 5;

    public int location;

    protected Map<SubType, Float> resistances = new ConcurrentHashMap<>(); /*{
        @Override
        public int size() {
            return Battle.SubType.values().length;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Object get(Object key) {
            return null;
        }

        @Override
        public Object put(Object key, Object value) {
            return null;
        }

        @Override
        public Object remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set keySet() {
            return null;
        }

        @Override
        public Collection values() {
            return null;
        }

        @Override
        public Set<Entry> entrySet() {
            return null;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    };*/
    protected Map<MainType, Float> typeResistances = new ConcurrentHashMap();/*{
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Object get(Object key) {
            return null;
        }

        @Override
        public Object put(Object key, Object value) {
            return null;
        }

        @Override
        public Object remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set keySet() {
            return null;
        }

        @Override
        public Collection values() {
            return null;
        }

        @Override
        public Set<Entry> entrySet() {
            return null;
        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    };*/

    public Unit(){

        //we want a hash for each element to quickly view if a skill is effective
        for (int i = 0; i < SubType.values().length; i++)
        {
            //Puts all Subtypes from Air - Metaphysical at a resistance value of 1
            resistances.put(SubType.values()[i], 1f);
        }

        for (int i = 0; i < MainType.values().length; i++)
        {
            //Puts all Subtypes from Air - Metaphysical at a resistance value of 1
            typeResistances.put(MainType.values()[i], (float)1);
        }
    }


    //sets the effectiveness of a damage type by being passed the type (Battle.SubType someType)
    //and the damage multiplier (float resistivity)
    public void setResistance(SubType someType, float resistivity) {

        resistances.replace(someType, resistivity);
    }

    //sets the effectiveness of several types by being passed the type (Battle.MainType someType)
    //and the damage multiplier (float resistivity)
    public void setResistance(MainType someType, float resistivity){

        if(resistivity < 0.25)
        {
            resistivity = 0.25f;
        }

        //assigns maintypes to subtypes
        switch(someType){
            case ELEMENTAL:

                resistances.replace(SubType.AIR, resistivity);
                resistances.replace(SubType.WATER, resistivity);
                resistances.replace(SubType.ELECTRIC, resistivity);
                resistances.replace(SubType.FIRE, resistivity);
                resistances.replace(SubType.EARTH, resistivity);
                break;

            case PHYSICAL:
                resistances.replace(SubType.PIERCE, resistivity);
                resistances.replace(SubType.SLASH, resistivity);
                resistances.replace(SubType.BLUNT, resistivity);
                resistances.replace(SubType.FRICTIVE, resistivity);
                resistances.replace(SubType.BLAST, resistivity);
                break;

            //ideally this code should never be reached
            //ie Metaphysical damage should never have resistivity besides 1
            //in case of an error nothing will be updated
            default:
            case META:
                break;
        }
    }

    public float getResistance(SubType someType){
        return resistances.get(someType);
    }

    //(attack * base power * type potency) / (defense * five) ∈ rand Range(75- LUK + 1, 75);
    //(attacker's) / (defender's)
    public int damageCalc(int incATT, int incBP, int incLUK, SubType someType)
    {
        float damage = 0;

        float potency = getResistance(someType);

        int min = 0;
        int max = 0;

        //Damage is meant to be a scale of values from 0.5 to 1.0 the previously calculated value
        //the luckier and individual is the closer to the 1.00 damage mod they'll be (effective LUK above 50 will
        //generally not be considered

        int lukMultiplier = 100;
        if( lukMultiplier/2 >= incLUK)
        {
            max = lukMultiplier + 1;
            min = incLUK + 50;
        }
        else
        {
            min = lukMultiplier + 1;
            max = incLUK;
        }


        damage = (incATT * incBP * potency) / (DEF * 5);

        float RNGesus = ThreadLocalRandom.current().nextInt(min, max);
        RNGesus /= 100;
        damage *= RNGesus;

        return (int) damage;
    }
}


