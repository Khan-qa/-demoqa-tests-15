package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.AutomationPracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTests {

    String firstName = "Хан";
    String lastName = "Ханов";
    String email = "han@hanov.com";
    String gender = "Female";
    String phone = "7123456789";

    String day = "17",
            month = "May",
            year = "1999";
    String subject = "Physics";
    String hobbies = "Sports";
    String picture = "1.png";

    String currentAddress = "Han KZ";

    String state = "NCR";
    String city = "Delhi";

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void firstTest() {
        automationPracticeFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGender(gender)
                .setPhone(phone)
                .setCalendar(day, month, year)
                .setSubjects(subject)
                .selectHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .selectionStateAndCity(state, city)
                .submitClick();

        automationPracticeFormPage.checkResultModalForm()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}
