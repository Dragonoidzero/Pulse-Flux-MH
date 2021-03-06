package azzy.fabric.pulseflux.energy;

import dev.technici4n.fasttransferlib.api.Simulation;

/**
 * An object that can hold and optionally take and provide pressure.
 */
public interface PressureIo {
    
    /**
     * Get the pressure stored.
     */
    double getPressure();

    /**
     * Get the maximum amount of pressure that can be stored, or 0 if unsupported or unknown.
     */

    default double getPressureCapacity() {
        return 0;
    }

    void requestPressureRecalc();

    /**
     * Return false if this object does not support insertion at all, meaning that insertion will always return the passed amount,
     * and insert-only cables should not connect.
     */
    default boolean supportsPressurization() {
        return false;
    }

    /**
     * Return false if this object does not support extraction at all, meaning that extraction will always return 0,
     * and extract-only cables should not connect.
     */
    default boolean supportsDepressurization() {
        return false;
    }

    /**
     * Insert pressure into this inventory, and return the amount of leftover pressure.
     *
     * <p>If simulation is {@link Simulation#SIMULATE}, the result of the operation must be returned, but the underlying state of the object must not change.
     *
     * @param amount     The amount of pressure to insert
     * @param simulation If {@link Simulation#SIMULATE}, do not mutate this object
     * @return the amount of pressure that could not be inserted
     */
    default double insertPressure(double amount, Simulation simulation) {
        return amount;
    }

    /**
     * Extract pressure from this inventory, and return the amount of leftover pressure.
     *
     * <p>If simulation is {@link Simulation#SIMULATE}, the result of the operation must be returned, but the underlying state of the object must not change.
     *
     * @param maxAmount     The maximum amount of pressure to extract
     * @param simulation 	If {@link Simulation#SIMULATE}, do not mutate this object
     * @return the amount of pressure that was extracted
     */
    default double extractPressure(double maxAmount, Simulation simulation) {
        return 0;
    }
}
