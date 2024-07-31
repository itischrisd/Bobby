package pl.edu.pja.s25692.bobby;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.edu.pja.s25692.bobby.model.client.RegularClient;
import pl.edu.pja.s25692.bobby.model.misc.ConfigParameter;
import pl.edu.pja.s25692.bobby.model.order.Invoice;
import pl.edu.pja.s25692.bobby.model.product.Product;
import pl.edu.pja.s25692.bobby.repository.config.ConfigParameterRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final ConfigParameterRepository configParameterRepository;

    @EventListener
    public void atStart(ApplicationStartedEvent event) {
        List<ConfigParameter> parameters = (List<ConfigParameter>) configParameterRepository.findAll();

        for (var parameter : parameters) {
            switch (parameter.getParameterKey()) {
                case "vatInProducts":
                    Product.setVatRate(Double.parseDouble(parameter.getParameterValue()));
                    break;
                case "vatInInvoices":
                    Invoice.setVatRate(Double.parseDouble(parameter.getParameterValue()));
                    break;
                case "initialDiscount":
                    RegularClient.setInitialDiscount(Double.parseDouble(parameter.getParameterValue()));
                    break;
            }
            System.out.println("Loaded parameter: " + parameter.getParameterKey() + " = " + parameter.getParameterValue());
        }

        System.out.println("Loaded " + parameters.size() + " parameters.");
    }
}