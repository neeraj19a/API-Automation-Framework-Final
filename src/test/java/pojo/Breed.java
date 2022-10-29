package pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Breed {
    public Weight weight;
    public String id;
    public String name;
    public String cfaUrl;
    public String vetstreetUrl;
    public String vcahospitalsUrl;
    public String temperament;
    public String origin;
    public String countryCodes;
    public String countryCode;
    public String description;
    public String lifeSpan;
    public Integer indoor;
    public Integer lap;
    public String altNames;
    public Integer adaptability;
    public Integer affectionLevel;
    public Integer childFriendly;
    public Integer dogFriendly;
    public Integer energyLevel;
    public Integer grooming;
    public Integer healthIssues;
    public Integer intelligence;
    public Integer sheddingLevel;
    public Integer socialNeeds;
    public Integer strangerFriendly;
    public Integer vocalisation;
    public Integer experimental;
    public Integer hairless;
    public Integer natural;
    public Integer rare;
    public Integer rex;
    public Integer suppressedTail;
    public Integer shortLegs;
    public String wikipediaUrl;
    public Integer hypoallergenic;
    public String referenceImageId;

}
