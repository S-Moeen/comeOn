package Logic;

/**
 * Created by moeen on 5/2/16.
 */
public class BiAttackWrapperClass {
    private AttackWrapperClass effectsOnCaster = new AttackWrapperClass();
    private AttackWrapperClass effectsOnTarget = new AttackWrapperClass();

    public AttackWrapperClass getEffectsOnCaster() {
        return effectsOnCaster;
    }

    public AttackWrapperClass getEffectsOnTarget() {
        return effectsOnTarget;
    }

    public void setEffectsOnCaster(AttackWrapperClass effectsOnCaster) {
        this.effectsOnCaster = effectsOnCaster;
    }

    public void setEffectsOnTarget(AttackWrapperClass effectsOnTarget) {
        this.effectsOnTarget = effectsOnTarget;
    }

}

