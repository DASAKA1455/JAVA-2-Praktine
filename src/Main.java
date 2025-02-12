import java.util.Random;

class GeoLocation {
    //Du privatūs kintamieji double lat ir double lon koordinatėms saugoti.
    private double lat;
    private double lon;

    //Privatus kintamasis int numLocations su nuline pradine reikšme
    private static int numLocations = 0;

   //Konstruktorius be parametrų, kuris klasės nariams priskiria atsitiktines koordinates iš intervalo [−90, 90].
    public GeoLocation() {
        Random random=new Random();

        this.lat=Math.round((random.nextDouble()*180-90));
        this.lon=Math.round((random.nextDouble()*360-180));

        //Koordinates suapvalinkite 6 ženklų po kablelio tikslumu:

        lat=Math.round(lat*1000000.0)/1000000.0;
        lon=Math.round(lon*1000000.0)/1000000.0;

        //+ padidintų numLocations reikšmę vienetu.
        numLocations++;

    }
    //Konstruktorius su dviem parametrais, klasės nariams lat ir lon priskiria parametrais perduotas reikšmes, ir padidina numLocations reikšmę vienetu.
    public GeoLocation(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
        numLocations++;
    }
    //Kopijavimo konstruktorius, kuris kopijuoja perduotas koordinates ir iš intervalo [-0.1,0.1] prideda atsitiktinį skaičių.
    public GeoLocation(GeoLocation extra) {
        Random random=new Random();
        this.lat=Math.round((extra.lat+(random.nextDouble()*0.2-0.1))*1000000.0)/1000000.0;
        this.lon=Math.round((extra.lon+(random.nextDouble()*0.2-0.1))*1000000.0)/1000000.0;

        //+ padidintų numLocations reikšmę vienetu.
        numLocations++;
    }

    //iš išorės pasiekiamas metodas void print(), atspausdinantis koordinates formatu [lat, lon].
    public void print() {
        System.out.println("["+lat+", "+lon+"]");
    }

    //Haversino formulė atstumui apskaičiuoti
    public static double distance(GeoLocation loc1, GeoLocation loc2) {
        final double R = 6371.0088;
        double lat1Rad = Math.toRadians(loc1.lat);
        double lon1Rad = Math.toRadians(loc1.lon);
        double lat2Rad = Math.toRadians(loc2.lat);
        double lon2Rad = Math.toRadians(loc2.lon);
        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;
        return Math.round(distance * 10.0) / 10.0;
    }

    public static int getNumLocations() {
        return numLocations;
    }
    //Dėstytojo metodo MAIN kodas
    public static void main(String[] args) {
        GeoLocation someLocation = new GeoLocation();
        GeoLocation vilnius = new GeoLocation(54.683333, 25.283333);
        GeoLocation kaunas = new GeoLocation(54.897222, 23.886111);
        GeoLocation nearVilnius = new GeoLocation(vilnius);

        someLocation.print();
        vilnius.print();
        nearVilnius.print();

        System.out.println("Number of locations: " + GeoLocation.getNumLocations());
        System.out.println("From Vilnius to Kaunas: " + GeoLocation.distance(vilnius, kaunas));
        System.out.println("From Vilnius to random location: " + GeoLocation.distance(vilnius, someLocation));
        System.out.println("From Vilnius to random neighbour: " + GeoLocation.distance(vilnius, nearVilnius));
    }

}






