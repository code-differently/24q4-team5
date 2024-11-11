import java.util.List;

public class EndangeredMammal extends Mammal {
  private List<EndangermentReason> endangermentReasons;
  private String region;

  public EndangeredMammal(
      String commonName,
      String scientificName,
      Boolean hasHair,
      Boolean isWarmBlooded,
      List<EndangermentReason> endangermentReasons,
      String region) {
    super(commonName, scientificName, hasHair, isWarmBlooded);
    this.endangermentReasons = endangermentReasons;
    this.region = region;
  }

  public List<EndangermentReason> getEndangermentReasons() {
    return endangermentReasons;
  }

  public String getRegion() {
    return region;
  }

  @Override
  public void move() {
    // Example: simulate a simple movement
    System.out.println(getCommonName() + " moves.");
  }
}
