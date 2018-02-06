package clientwsfootball;

import java.util.List;

public class ClientWSFootball {

    public static void main(String[] args) {
        System.out.println("Yellow cards total: " + yellowCardsTotal());  
        System.out.println("Defenders from Spain: " + allDefenders("Spain").getString());
        
        List<TCountryInfo> countryInfoList = countryNames(true).getTCountryInfo();
        for (TCountryInfo country : countryInfoList) {
            System.out.println(country.getSName());
            System.out.println(allDefenders(country.getSName()).getString());
        }
    }

    private static int yellowCardsTotal() {
        clientwsfootball.Info service = new clientwsfootball.Info();
        clientwsfootball.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        clientwsfootball.Info service = new clientwsfootball.Info();
        clientwsfootball.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        clientwsfootball.Info service = new clientwsfootball.Info();
        clientwsfootball.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }
    
    
}
