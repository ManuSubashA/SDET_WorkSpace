package com.apiautomation.in.CountryTranslation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CountriesTranslation {

    @DataProvider(name = "countryData")
    public Object[][] getCountryData() {
        String path = ".\\Files\\datafile.xlsx";
        List<String> countryList = ExcelFileReader.getTranslationWords(path);

        Object[][] data = new Object[countryList.size()][1];
        for (int i = 0; i < countryList.size(); i++) {
            data[i][0] = countryList.get(i);
        }

        return data;
    }

    @Test(dataProvider = "countryData")
    public void testCountryTranslationAPI(String country) {
        String url = "https://restcountries.com/v3.1/translation/" + country;

        Response response = RestAssured
                .given()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("✔ Country: " + country);
        System.out.println(response.asPrettyString());

        assertThat("Response should not be empty", response.jsonPath().getList("$"), not(empty()));
    }
}
