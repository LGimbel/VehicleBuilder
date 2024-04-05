public class Main {
    public static void main(String[] args) {
        DepartmentOfDefence dod = new DepartmentOfDefence();
        F35Builder f35Builder = new F35Builder();
        B1BBuilder b1BBuilder = new B1BBuilder();
        SB1Builder sb1Builder = new SB1Builder();
        Aircraft f35;
        Aircraft b1b;
        Aircraft sb1;
        dod.setAircraftBuilder(f35Builder);
        dod.assembleAircraft();
        f35 = dod.getAircraft();
        f35.printAircraft();
        System.out.println("\n\n\n");
        dod.setAircraftBuilder(b1BBuilder);
        dod.assembleAircraft();
        b1b = dod.getAircraft();
        b1b.printAircraft();
        System.out.println("\n\n\n");
        dod.setAircraftBuilder(sb1Builder);
        dod.assembleAircraft();
        sb1 = dod.getAircraft();
        sb1.printAircraft();
    }
}
enum AircraftType{
    FixedWing,RotaryWing,SweepWing;
}
class Aircraft{
   private AircraftType aircraftType;
   private String aircraftName;
   private String engine;
   private String engineType;
   private String manufacturer;

   public void printAircraft(){
       System.out.println("Im a ".concat(aircraftName));
       System.out.println("Im a ".concat(aircraftType.toString()));
       System.out.println("My power plant is a ".concat(engineType).concat(" called the ".concat(engine)));
       System.out.println("Im made by ".concat(manufacturer));
   }


    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
abstract class AircraftBuilder{
    protected Aircraft aircraft;
    public Aircraft getAircraft() {
        return aircraft;
    }
    public void makeNewAircraft(){
        aircraft = new Aircraft();
    }
    public abstract void buildType();
    public abstract void buildName();
    public abstract void buildEngine();
    public abstract void buildEngineType();
    public abstract void buildManufacturer();

}
class F35Builder extends AircraftBuilder{
    @Override
    public void buildType() {
        aircraft.setAircraftType(AircraftType.FixedWing);
    }

    @Override
    public void buildName() {
        aircraft.setAircraftName("F-35 Lightning II");
    }

    @Override
    public void buildEngine() {
        aircraft.setEngine("Pratt & Whitney F135");
    }

    @Override
    public void buildEngineType() {
        aircraft.setEngineType("afterburning turbofan");
    }

    public void buildManufacturer() {
        aircraft.setManufacturer("Boeing");
    }
}
class B1BBuilder extends AircraftBuilder{

    @Override
    public void buildType() {
        aircraft.setAircraftType(AircraftType.SweepWing);
    }

    @Override
    public void buildName() {
        aircraft.setAircraftName("B-1 Lancer");

    }

    @Override
    public void buildEngine() {
        aircraft.setEngine("General Electric F101");

    }

    @Override
    public void buildEngineType() {
        aircraft.setEngineType("afterburning turbofan");

    }

    @Override
    public void buildManufacturer() {
        aircraft.setManufacturer("Rockwell International"); // Technically boeing as they sold most of their stuff in 1996,
        // although they still oversee some of the b1 production, but I digress.

    }

}
class SB1Builder extends AircraftBuilder{

    @Override
    public void buildType() {
        aircraft.setAircraftType(AircraftType.RotaryWing);
    }

    @Override
    public void buildName() {
        aircraft.setAircraftName("SB-1 Defiant");
    }

    @Override
    public void buildEngine() {
        aircraft.setEngine("Honeywell T55");
    }

    @Override
    public void buildEngineType() {
        aircraft.setEngineType("turboshaft");

    }

    @Override
    public void buildManufacturer() {
        aircraft.setManufacturer("Sikorsky-Boeing");
    }
}
class DepartmentOfDefence{// I could not think of anything elso to name it like who just give out these aircraft.
    private AircraftBuilder aircraftBuilder;
    public void setAircraftBuilder(AircraftBuilder builder){
        aircraftBuilder = builder;
    }
    public Aircraft getAircraft(){
        return aircraftBuilder.getAircraft();
    }
    public void assembleAircraft(){
        aircraftBuilder.makeNewAircraft();
        aircraftBuilder.buildType();
        aircraftBuilder.buildName();
        aircraftBuilder.buildEngine();
        aircraftBuilder.buildEngineType();
        aircraftBuilder.buildManufacturer();
    }
}