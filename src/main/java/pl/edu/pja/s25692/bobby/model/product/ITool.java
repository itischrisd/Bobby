package pl.edu.pja.s25692.bobby.model.product;

import java.util.Set;

public interface ITool {

    Tool asTool();

    default Double getPower() {
        return asTool().getPower();
    }

    default void setPower(Double power) {
        asTool().setPower(power);
    }

    default Double getVoltage() {
        return asTool().getVoltage();
    }

    default void setVoltage(Double voltage) {
        asTool().setVoltage(voltage);
    }

    default Set<Brand> getBrands() {
        return asTool().getBrands();
    }

    default void setBrands(Set<Brand> brands) {
        asTool().setBrands(brands);
    }
}
