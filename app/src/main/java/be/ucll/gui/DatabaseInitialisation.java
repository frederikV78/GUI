package be.ucll.gui;

import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.content.Context;
import android.util.Log;

/**
 * Created by Frederik on 12/9/2016.
 */

public class DatabaseInitialisation {
    DatabaseActivity dbo;
    UserObject user;
    LocationObject location;


    public DatabaseInitialisation(DatabaseActivity dboPassed){
        initiateUsers();
        initiateLocations();
    }

    public void initiateUsers(){
        //adding users
        user = new UserObject("r0486914","Elias","elias","student","IWT");
        dbo.AddUserToDb(user);
        user = new UserObject("r0488080","Frederik","frederik","student","IWT");
        dbo.AddUserToDb(user);
        user = new UserObject("r0581302","Tom","tom","student","IWT");
        dbo.AddUserToDb(user);
    }

    private void initiateLocations(){
        //adding Campi
        location = new LocationObject("Tom thuis","Welkom op het erf!"
                ,50.949325,5.340922,50,1);
        dbo.AddLocationToDb(location);
        location = new LocationObject("Tom huis","Welkom aan de voordeur!"
                ,50.949325,5.340922,20,0);
        dbo.AddLocationToDb(location);

        location = new LocationObject("CAMPUS COMENIUS","Campus Comenius is de enige campus van UC Leuven-Limburg die binnen de ring van Leuven ligt. Het station van Leuven is – letterlijk – vlak bij de deur. De campus huist momenteel de opleidingen Kleuteronderwijs, Lager Onderwijs en Secundair Onderwijs. Er worden ook postgraduaten aangeboden."
                ,50.879153,4.715298,100,1);
        dbo.AddLocationToDb(location);
        location = new LocationObject("CAMPUS GASTHUISBERG","Deze Leuvense campus is gelegen op site Gasthuisberg. De keuze voor deze locatie was een heel bewuste. Gasthuisberg staat in binnen- en buitenland bekend om zijn expertise op gebied van gezondheidszorg en technologie. Door onze aanwezigheid op deze site willen we de goede samenwerking met het UZ Leuven en de Associatie KU Leuven nog verder versterken. Via deze onderlinge kruisbestuiving kunnen wij de kwaliteit van ons professioneel onderwijs, waar UC Leuven-Limburg om bekend staat, voortdurend verbeteren. Deze campus huist de opleidingen Verpleegkunde, Vroedkunde, Voedings- en Dieetkunde, Biomedische Laboratoriumtechnologie en Chemie."
                ,50.879949,4.672500,100,1);
        dbo.AddLocationToDb(location);
        location = new LocationObject("CAMPUS HERTOGSTRAAT","Op onze campus in Heverlee kun je de Lerarenopleiding Kleuter, Lager en Secundair Onderwijs vinden en de bacheloropleidingen Bedrijfsmanagement en Office Management. Heel wat lessen van de lerarenopleiding vinden ook plaats in het aanpalende gebouw ‘Flos Campi’ aan de Naamsesteenweg, dat op wandelafstand ligt van het hoofdgebouw. De moderne campus heeft verschillende auditoria, een open leercentrum en bibliotheek, een studentenrestaurant en tal van sportfaciliteiten. Er is een ruime en moderne sporthal en de campus is gelegen naast het Meerdaalwoud, zodat sportieve ontspanning binnen of buiten perfect mogelijk is."
                ,50.856551,4.703122,100,1);
        dbo.AddLocationToDb(location);
        location = new LocationObject("CAMPUS PROXIMUS","Campus Proximus was tot nu toe bekend als het Telindusgebouw, een begeesterend stuk architectuur en als dusdanig een uitzondering op het bedrijfspark van Haasrode. De site was tot eind december 2014 in het bezit van Belgacom. Deze campus zal vanaf september 2015 de opleiding Toegepaste Informatica onderbrengen, later volgen Bedrijfsmanagement en Office Management. Op deze campus zitten ook alle Leuvense algemene diensten van onze hogeschool. Op 1 september 2015 nemen ook de studenten uit de graduaatsopleidingen."
                ,50.847437,4.724701,100,1);
        dbo.AddLocationToDb(location);
        location = new LocationObject("CAMPUS SOCIALE SCHOOL","Boven aan de Groeneweg in Heverlee, torent een hoog wit gebouw boven de omliggende velden uit. Het is de campus Sociale School. Op een boogscheut ligt de campus Gasthuisberg en Leuven op twee boogscheuten. Studenten kunnen zich op deze ‘groene’ campus even uit de wereld terug trekken om een ‘overview’ te krijgen van mens en samenleving. Studenten Sociaal Werk en Sociale Readaptatiewetenschappen volgen er lessen in de vier blokken met goed ingerichte auditoria, praktijk- en vergaderlokalen. Voor een warme maaltijd of een broodje hoeven ze niet naar buiten. Er is een ‘Alma’."
                ,50.875943,4.662055,100,1);
        dbo.AddLocationToDb(location);
        location = new LocationObject("Campus Clenardus","Kies je voor de lerarenopleiding Kleuter- of Lager Onderwijs aan UC Leuven-Limburg? Dan kan je ook naar Diest uitwijken: een sympathiek provinciestadje op mensenmaat tussen de glooiende heuvels van het Hageland. Met Campus Clenardus als uitvalsbasis hoef je het nooit ver te zoeken. Gezellige straten en trendy winkels liggen om de hoek, en net buiten de kleine kern met stemmige cafeetjes en gezellige restaurantjes zit je alweer in het groen. Campus Clenardus bevindt zich vlak aan het station, lessen vinden ook plaats in ons gebouw in de Demerstraat."
                ,50.989765,5.051344,100,1);
        dbo.AddLocationToDb(location);
        location = new LocationObject("CAMPUS HEMELRIJK","In het hart van Hasselt vind je het statige gebouw waar voorheen de Lerarenopleiding, Kleuter- en Lager onderwijs gevestigd was. Dit gebouw zal vanaf academiejaar 2015-2016 nog slechts sporadisch gebruikt worden door de lerarenopleiding."
                ,50.930319,5.339310,100,1);
        dbo.AddLocationToDb(location);
        location = new LocationObject("OUDE LUIKERBAAN","Achter het cultuurcentrum van Hasselt en het stadspark bevindt zich Campus Oude Luikerbaan (nr. 79). Dit is vanaf nu de thuisbasis van de Lerarenopleiding Kleuter- en Lager Onderwijs. De campus oogt modern met een fraaie centrale onthaalruimte en heel wat open werkplaatsen voor de studenten en een uitgebreide mediatheek. Buiten is er veel ruimte voor evenementen en met het stadspark vlakbij is er veel groen. De cafetaria heeft een ruim aanbod, koud én warm. De campus is vlot bereikbaar met de bus (stopt voor de deur). Een grote fietsenstalling en eigen parking maken deze campus ook handig als je met de fiets of auto komt."
                ,50.921163,5.346908,100,1);
        dbo.AddLocationToDb(location);
        location = new LocationObject("CAMPUS LIZA","Tegenover het ziekenhuis Oost-Limburg (ZOL) op Schiepse bos in Genk beschikt de UC Leuven-Limburg vanaf juni 2015 over een gloednieuwe campus voor de opleidingen Gezondheid: Verpleegkunde en Vroedkunde. De campus beschikt over een restaurant, mediatheek, aula’s en heel wat skills labs. Het ZOL heeft heel wat busverbindingen, o.a. naar het station Genk.  Voor wie met de fiets of wagen komt: er is een fietsenstalling naast het gebouw en parkeren kan in de onmiddellijke nabijheid."
                ,50.956750,5.519060,100,1);
        dbo.AddLocationToDb(location);
        location = new LocationObject("CAMPUS DIEPENBEEK","Op de grootste campus van de UC Leuven-Limburg bevinden zich de gebouwen van Management, Technologie, Welzijn en Lerarenopleiding Secundair Onderwijs. Ook de studenten industrieel ingenieur van de KU Leuven – UHasselt vertoeven vaak op onze campus. In totaal goed voor 4 000 studenten. Op de campus kan je genieten van een centraal gelegen restaurant met een uitgebreid menu (van warm buffet tot salad bar) en een cafetaria. Verder op onze campus: twee mediatheken en het Stuvoor-huis.Wat verderop op deze groene campus vind je ook het Onderzoekscentrum en het Technologiecentrum van UC Leuven-Limburg en enkele faculteiten van de UHasselt en de PXL. Vandaar dat het geheel de “universitaire” campus heet.De campus is vlot bereikbaar met de bus, ongeveer 5 min. vanuit Hasselt. Er zijn uitgebreide gratis parkeermogelijkheden voor je fiets of auto."
                ,50.928472,5.388768,100,1);
        dbo.AddLocationToDb(location);

        //Adding departements and buildings
        location = new LocationObject("Departement IWT gebouw B","Welkom op het departement Industriële Wetenschappen & Technologie van de UCLL Diepenbeek, U staat nu voor gebouw B."
                ,50.928697,5.395702,20,0);
        dbo.AddLocationToDb(location);
        location = new LocationObject("Departement IWT gebouw J","Welkom op het departement Industriële Wetenschappen & Technologie van de UCLL Diepenbeek, U staat nu voor gebouw J."
                ,50.929000,5.394827,20,0);
        dbo.AddLocationToDb(location);
        location = new LocationObject("Departement IWT gebouw N","Welkom op het departement Industriële Wetenschappen & Technologie van de UCLL Diepenbeek, U staat nu voor gebouw N."
                ,50.929601,5.395187,20,0);
        dbo.AddLocationToDb(location);
        location = new LocationObject("Departement MGT","Welkom op het departement Management van de UCLL Diepenbeek."
                ,50.927796,5.396383,20,0);
        dbo.AddLocationToDb(location);
        location = new LocationObject("Departement Leraren Opleiding","Welkom op het departement Leraren Opleiding van de UCLL Diepenbeek."
                ,50.928295,5.397223,20,0);
        dbo.AddLocationToDb(location);
    }



}
