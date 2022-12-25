package com.demoqa.tests;

import com.demoqa.pages.AutomationPracticeFormPage;
import com.demoqa.utils.GenerateFakeData;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AutomationPracticeFormTests extends BaseTestConfiguration {

    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();
    GenerateFakeData fakeData = new GenerateFakeData();

    @Test
    void firstTest() {

        step("Открываем страницу", () -> {
            automationPracticeFormPage.openPage();
        });

        step("Заполняем форму", () -> {
            automationPracticeFormPage
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
                    .submitClick();
        });

        step("Проверяем форму результатов", () -> {
            automationPracticeFormPage.checkResultModalForm()
                    .checkResult("Student Name", fakeData.randomFirstName + " " + fakeData.randomLastName)
                    .checkResult("Student Email", fakeData.randomEmail)
                    .checkResult("Gender", fakeData.randomGender)
                    .checkResult("Mobile", fakeData.randomPhone)
                    .checkResult("Date of Birth", fakeData.randomDay + " " + fakeData.randomMonth + "," + fakeData.randomYear)
                    .checkResult("Subjects", fakeData.randomSubject)
                    .checkResult("Hobbies", fakeData.randomHobbies)
                    .checkResult("Picture", fakeData.RandomPicture)
                    .checkResult("Address", fakeData.randomCurrentAddress)
                    .checkResult("State and City", fakeData.randomState + " " + fakeData.randomCity);
        });

    }
}
