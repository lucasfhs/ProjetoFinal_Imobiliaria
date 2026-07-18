package com.jotaproperties.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.jotaproperties.model.Apartment;
import com.jotaproperties.model.House;
import com.jotaproperties.model.Property;

/** Persiste o catálogo de imóveis em um arquivo TSV no diretório do usuário. */
public class PropertyFileRepository {
    private static final String HOUSE_TYPE = "HOUSE";
    private static final String APARTMENT_TYPE = "APARTMENT";

    private final Path file;

    public PropertyFileRepository(Path file) {
        this.file = file;
    }

    public boolean exists() {
        return Files.isRegularFile(file);
    }

    public void save(List<Property> properties) throws IOException {
        Files.createDirectories(file.getParent());

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            for (Property property : properties) {
                if (property instanceof House house) {
                    writeCommonFields(writer, HOUSE_TYPE, house);
                    writer.write('\t');
                    writer.write(house.getDescricaoQuintal());
                    writer.write('\t');
                    writer.write(house.getNomeDoCondominio());
                } else if (property instanceof Apartment apartment) {
                    writeCommonFields(writer, APARTMENT_TYPE, apartment);
                    writer.write('\t');
                    writer.write(Integer.toString(apartment.getAndar()));
                    writer.write('\t');
                    writer.write(Boolean.toString(apartment.isPossuiElevador()));
                }
                writer.newLine();
            }
        }
    }

    public List<Property> load() throws IOException {
        List<Property> properties = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\t", -1);
                int listingNumber = Integer.parseInt(data[1]);
                String description = data[2];
                double price = Double.parseDouble(data[3]);
                String city = data[4];
                String state = data[5];
                int parkingSpaces = Integer.parseInt(data[6]);
                double area = Double.parseDouble(data[7]);

                if (HOUSE_TYPE.equals(data[0])) {
                    properties.add(new House(data[8], data[9], listingNumber, description, price,
                            city, state, parkingSpaces, area));
                } else if (APARTMENT_TYPE.equals(data[0])) {
                    properties.add(new Apartment(Integer.parseInt(data[8]), Boolean.parseBoolean(data[9]),
                            listingNumber, description, price, city, state, parkingSpaces, area));
                }
            }
        }

        return properties;
    }

    private void writeCommonFields(BufferedWriter writer, String type, Property property) throws IOException {
        writer.write(String.join("\t",
                type,
                Integer.toString(property.getNumeroDoAnuncio()),
                property.getDescricao().replace('\t', ' '),
                Double.toString(property.getValor()),
                property.getCidade().replace('\t', ' '),
                property.getEstado().replace('\t', ' '),
                Integer.toString(property.getVagasGaragem()),
                Double.toString(property.getArea())));
    }
}
