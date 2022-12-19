package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.SelectionStateAndCity;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.open;

public class AutomationPracticeFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    SelectionStateAndCity selectionStateAndCity = new SelectionStateAndCity();

    public AutomationPracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }


    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderSelect = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSelect = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            submitButton = $("#submit"),
            modalForm = $(".modal-dialog");


    private AutomationPracticeFormPage clearForm(SelenideElement element) {
        element.clear();
        return this;
    }

    public AutomationPracticeFormPage setFirstName(String firstName) {
        clearForm(firstNameInput);
        firstNameInput.setValue(firstName);

        return this;
    }

    public AutomationPracticeFormPage setLastName(String lastName) {
        clearForm(lastNameInput);
        lastNameInput.setValue(lastName);

        return this;
    }

    public AutomationPracticeFormPage setEmail(String email) {
        clearForm(emailInput);
        emailInput.setValue(email);

        return this;
    }

    public AutomationPracticeFormPage selectGender(String gender) {
        genderSelect.$(byText(gender)).click();

        return this;
    }

    public AutomationPracticeFormPage setPhone(String phone) {
        clearForm(phoneInput);
        phoneInput.setValue(phone);

        return this;
    }

    public AutomationPracticeFormPage setCalendar(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.calendar(day, month, year);

        return this;
    }

    public AutomationPracticeFormPage setSubjects(String subject) {
        clearForm(subjectsInput);
        subjectsInput.setValue(subject).pressEnter();

        return this;
    }

    public AutomationPracticeFormPage selectHobbies(String hobbies) {
        hobbiesSelect.$(byText(hobbies)).click();

        return this;
    }

    public AutomationPracticeFormPage uploadPicture(String picture) {
        uploadPicture.uploadFromClasspath(picture);

        return this;
    }

    public AutomationPracticeFormPage setCurrentAddress(String currentAddress) {
        clearForm(currentAddressInput);
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    public AutomationPracticeFormPage selectionStateAndCity(String state, String city) {
        selectionStateAndCity.selectionStateAndCity(state, city);

        return this;
    }

    public AutomationPracticeFormPage submitClick() {
        submitButton.click();

        return this;
    }

    public AutomationPracticeFormPage checkResultModalForm() {
        modalForm.should(Condition.appear);

        return this;
    }
}
