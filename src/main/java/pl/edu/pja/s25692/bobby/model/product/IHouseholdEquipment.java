package pl.edu.pja.s25692.bobby.model.product;

import java.util.Set;

public interface IHouseholdEquipment {

    HouseholdEquipment asHouseholdEquipment();

    default Set<String> getCertificates() {
        return asHouseholdEquipment().getCertificates();
    }

    default void setCertificates(Set<String> certificates) {
        asHouseholdEquipment().setCertificates(certificates);
    }

    default boolean isForSelfAssembly() {
        return asHouseholdEquipment().isForSelfAssembly();
    }

    default void setForSelfAssembly(boolean forSelfAssembly) {
        asHouseholdEquipment().setForSelfAssembly(forSelfAssembly);
    }
}
