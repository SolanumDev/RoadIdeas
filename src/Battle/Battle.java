package Battle;

public class Battle {
    /*Logic behind battles

    Using a priority queue where the number before is the priority bracket and the unit's speed stat determines
    when its effect activates within said bracket

    Priority 0
    See if there's any effects that should be applied before that turn begins (but after the previous turn ends and
    before any moves are selected)
    These effects are applied on turn 0 (ie the start of an encounter)
    before any moves are selected but will *not* be applied if a unit hits the field mid-turn.
    If this needs to be applied throughout the turn we should have a flag to say so.

    //Battle.Move selection

    Priority 1
    See if there's any effects that should be applied before the turn begins (but after moves are selected)
    These effects are applied on turn 1 and beyond and will be applied if a unit hits the field mid-turn

    Priority 2
    Battle.Battle occurs here

    Priority 3
    See if there's any effects that should be applied after the turn ends (but before the next turn begins)
    The flag to decrement any active field effects is applied here

     */




}
