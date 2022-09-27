package Battle;

import java.util.List;

public abstract class Move {

    public int basePower;

    public int stamCost;

    public SubType primaryType;
    public SubType secondaryType;

    public List<SubType> typeList;

    public List<SkillProperty> prop;

    public boolean isFusion;

    public int priorityBracket;

    public enum areaEffect{

    }

    public enum DamageTier {
        Base,
        MILD,       //("Mild", 20);
        MODERATE,   //("Moderate", 40);
        MAJOR,      //("Major", 60);
        MASSIVE,    //("Massive", 80);
        MEGA        //("Mega", 100);
    }
    /*protected Map damageTier = new Map() {

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

    DamageTier damTier;

    protected Move(){

        int basePower = 1;

        SubType primaryType = null;
        SubType secondaryType = null;

        List<SubType> typeList;

        List<SkillProperty> prop;

        boolean isFusion = false;

        int priorityBracket = 1;

        damTier = DamageTier.MILD;

        /*
        damageTier.put//("Mild", 20);
        damageTier.put//("Moderate", 40);
        damageTier.put//("Major", 60);
        damageTier.put//("Massive", 80);
        damageTier.put//("Mega", 100);

        basePower = (int) damageTier.get("Mild");
        */
    }


    protected void setEverything(){}

    //by default a move does damage and that's all
    protected void effect(){}



}


/*
enum damageTier{
    Base,
    Mild,
    Moderate,
    Major,
    Massive,
    Mega
}
*/


