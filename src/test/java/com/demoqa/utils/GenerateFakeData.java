package com.demoqa.utils;
import com.github.javafaker.Faker;

import java.util.*;

public class GenerateFakeData {

    private static final Faker fakerRU = new Faker(new Locale("ru"));
    private static final Faker fakerEn = new Faker(new Locale("en-US"));

    public String randomFirstName = fakerRU.name().firstName();
    public String randomLastName = fakerRU.name().lastName();
    public String randomEmail = fakerEn.internet().emailAddress();
    public String randomGender = getRandomGender();
    public String randomPhone = fakerRU.phoneNumber().subscriberNumber(10);
    public String randomDay = getRandomDay();
    public String randomMonth = getRandomMonth();
    public String randomYear = String.valueOf(fakerRU.number().numberBetween(1900, 2100));
    public String randomSubject = getRandomSubject();
    public String randomHobbies = getRandomHobbies();
    public String RandomPicture = "1.png";
    public String randomCurrentAddress = fakerRU.address().fullAddress();
    public String randomState = getRandomState();
    public String randomCity = getRandomCity(randomState);


    private static String getRandomDay() {
        int generateRandomDay = fakerRU.number().numberBetween(1, 31);
        String randomDay = String.valueOf(generateRandomDay);

        if (generateRandomDay < 10) {
            return "0" + randomDay;
        }
        return randomDay;
    }

    private static String getRandomMonth() {
        List<String> months = Arrays.asList(
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December");

        return months.get(new Random().nextInt(months.size()));
    }

    private static String getRandomGender() {
        List<String> gender = Arrays.asList("Male", "Female", "Other");

        return gender.get(new Random().nextInt(gender.size()));
    }

    private static String getRandomHobbies() {
        List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");

        return hobbies.get(new Random().nextInt(hobbies.size()));
    }

    private static String getRandomSubject() {
        List<String> subject = Arrays.asList("Physics", "Computer Science", "Maths", "Economics");

        return subject.get(new Random().nextInt(subject.size()));
    }

    private static String getRandomState() {
        List<String> state = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

        return state.get(new Random().nextInt(state.size()));
    }

    private static String getRandomCity(String state) {

        List<String> citiesOfNCR = Arrays.asList("Delhi", "Gurgaon", "Noida");
        List<String> citiesOfUttarPradesh = Arrays.asList("Agra", "Lucknow", "Merrut");
        List<String> citiesOfHaryana = Arrays.asList("Karnal", "Panipat");
        List<String> citiesOfRajasthan = Arrays.asList("Jaipur", "Jaiselmer");

        HashMap<String, List<String>> mapCountryCities = new HashMap<>();

        mapCountryCities.put("NCR", citiesOfNCR);
        mapCountryCities.put("Uttar Pradesh", citiesOfUttarPradesh);
        mapCountryCities.put("Haryana", citiesOfHaryana);
        mapCountryCities.put("Rajasthan", citiesOfRajasthan);

        List<String> city = new ArrayList<>(mapCountryCities.get(state));

        return city.get(new Random().nextInt(city.size()));
    }

}
