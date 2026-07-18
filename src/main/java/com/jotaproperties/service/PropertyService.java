package com.jotaproperties.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jotaproperties.model.Apartment;
import com.jotaproperties.model.House;
import com.jotaproperties.model.Property;
import com.jotaproperties.repository.PropertyFileRepository;

/** Gerencia o catálogo e os filtros escolhidos pelo usuário. */
public class PropertyService {
    private final PropertyGenerator generator;
    private final PropertyFileRepository repository;
    private List<Property> registeredProperties;
    private List<Property> selectedProperties = new ArrayList<>();

    public PropertyService() {
        this(Path.of(System.getProperty("user.home"), ".jota-properties", "properties.tsv"));
    }

    PropertyService(Path catalogPath) {
        generator = new PropertyGenerator();
        repository = new PropertyFileRepository(catalogPath);
        registeredProperties = loadOrCreateCatalog();
    }

    public List<Property> getSelectedProperties() {
        return selectedProperties;
    }

    public List<Property> getRegisteredProperties() {
        return registeredProperties;
    }

    public void selectProperties(boolean forRent, String propertyType, String state, String city) {
        selectedProperties = new ArrayList<>();

        for (Property property : registeredProperties) {
            boolean requestedType = (propertyType.equalsIgnoreCase("Casa") && property instanceof House)
                    || (propertyType.equalsIgnoreCase("Apartamento") && property instanceof Apartment);
            boolean requestedLocation = property.getEstado().equalsIgnoreCase(state)
                    && property.getCidade().equalsIgnoreCase(city);

            if (requestedType && requestedLocation) {
                if (forRent) {
                    property.setValor(property.getValor() * 0.005);
                }
                selectedProperties.add(property);
            }

            if (selectedProperties.size() == 10) {
                break;
            }
        }

        assignPropertyImages();
    }

    private List<Property> loadOrCreateCatalog() {
        try {
            if (repository.exists()) {
                return repository.load();
            }

            List<Property> generatedProperties = generator.geraImoveis();
            repository.save(generatedProperties);
            return generatedProperties;
        } catch (IOException | RuntimeException exception) {
            System.err.println("Não foi possível acessar o catálogo local; usando dados temporários.");
            return generator.geraImoveis();
        }
    }

    private void assignPropertyImages() {
        List<Integer> imageNumbers = new ArrayList<>();
        for (int number = 1; number <= 30; number++) {
            imageNumbers.add(number);
        }
        Collections.shuffle(imageNumbers);

        for (int index = 0; index < selectedProperties.size(); index++) {
            Property property = selectedProperties.get(index);
            String prefix = property instanceof House ? "house-" : "apartment-";
            property.setfonteImagem("/images/properties/" + prefix + imageNumbers.get(index) + ".jpg");
        }
    }
}
