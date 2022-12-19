package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.AutomationPracticeFormPage;
import com.demoqa.utils.GenerateFakeData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormTests {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    GenerateFakeData fakeData = new GenerateFakeData();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void firstTest() {
        automationPracticeFormPage.openPage()
                .setFirstName(fakeData.randomFirstName)
                .setLastName(fakeData.randomLastName)
                .setEmail(fakeData.randomEmail)
                .selectGender(fakeData.randomGender)
                .setPhone(fakeData.randomPhone)
                .setCalendar(fakeData.randomDay, fakeData.randomMonth, fakeData.randomYear)
                .setSubjects(fakeData.randomSubject)
                .selectHobbies(fakeData.randomHobbies)
                .uploadPicture(fakeData.RandomPicture)
                .setCurrentAddress(fakeData.randomCurrentAddress)
                .selectionStateAndCity(fakeData.randomState, fakeData.randomCity)
                .submitClick()
                .checkResultModalForm();
    }
}
