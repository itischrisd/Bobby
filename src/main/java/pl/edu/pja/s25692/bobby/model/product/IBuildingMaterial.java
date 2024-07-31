package pl.edu.pja.s25692.bobby.model.product;

public interface IBuildingMaterial {

    BuildingMaterial asBuildingMaterial();

    default String getUnit() {
        return asBuildingMaterial().getUnit();
    }

    default void setUnit(String unit) {
        asBuildingMaterial().setUnit(unit);
    }
}
